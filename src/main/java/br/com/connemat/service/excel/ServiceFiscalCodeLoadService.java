package br.com.connemat.service.excel;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.connemat.ServiceFiscalCodeBaseService;
import br.com.connemat.ServiceFiscalCodeTreeBaseService;
import br.com.connemat.model.entity.ServiceFiscalCode;
import br.com.connemat.model.entity.ServiceFiscalCodeTree;
import br.com.connemat.sysmat.exception.SysmatEntityException;
import br.com.connemat.util.tree.patricia.CharSequenceKeyAnalyzer;
import br.com.connemat.util.tree.patricia.PatriciaTrie;
import br.com.connemat.util.tree.patricia.PatriciaTrie.TrieEntry;
import br.com.connemat.util.tree.patricia.Trie.Cursor;

@Service
public class ServiceFiscalCodeLoadService {

	public static final String SFC = "C:/Users/jccanova/git/sysmat3/sysmat/src/test/resources/lei116-codigo-servico.xlsx";

	@Autowired
	private ServiceFiscalCodeBaseService codeService;
	
	@Autowired
	private ServiceFiscalCodeTreeBaseService treeService;
	
	public ServiceFiscalCodeLoadService() {
	}
	
	public void loadServiceFiscalCode()
	{
		
		try {
			XSSFWorkbook  wb = new XSSFWorkbook (new File(SFC));
		    XSSFSheet  sheet =  wb.getSheetAt(0);
		    boolean iterate = true;
	    	int i = 0;
	    	List<ServiceCodeEntry> entries = new ArrayList<>();
	    	do {
		    	XSSFRow row = sheet.getRow(i);
		    	if(row !=null) {
			    	ServiceCodeEntry entry = new ServiceCodeEntry();
			    	iterate = Optional.ofNullable(row.getCell(0))
			    	.map( c -> 
			    				{
			    					entry.setCode(getValue(c));
			    					return true;
			    				}).orElse(false);
			    	Optional.ofNullable(row.getCell(1))
			    	.map( c -> 
			    				{
			    					entry.setDesciption(getValue(c));
			    					return true;
			    				}).orElse(false);	
			    	if (iterate) {
			    		adjustCode(entry);
			    		entries.add(entry);
			    	}
		    	}else {
		    		iterate = false;
		    	}
		    	i++;
		    }while (iterate==true);
	    	PatriciaTrie<String,ServiceCodeEntry> trie = populateTrie(entries);
	    	evaluateAndSaveServiceCode(trie);
		}catch (Exception ex) {
			throw new SysmatEntityException(ex);
		}
	}

	private void evaluateAndSaveServiceCode(PatriciaTrie<String, ServiceCodeEntry> trie) {
		
		trie.traverse(new Cursor<String,ServiceCodeEntry>() {

			@Override
			public SelectStatus select(Entry entry) {
				TrieEntry<String , ServiceCodeEntry> te = TrieEntry.class.cast(entry); 
				if(te.getKey().length()==2) {
					ServiceFiscalCodeTree tree = new ServiceFiscalCodeTree();
					tree.setCode(te.getValue().getCode());
					tree.setDescription(te.getValue().getDesciption());
					treeService.addEntity(tree);
				}else if(te.getKey().length()==4) {
					ServiceFiscalCode code = new ServiceFiscalCode();
					code.setId(te.getKey());
					code.setDescription(te.getValue().getDesciption());
					code.setStartDate(LocalDate.now().withYear(1900).withDayOfYear(1));
					String parentCode = te.getKey().substring(0, 2);
					treeService.findServiceFiscalTreeByCode(parentCode)
					.ifPresent(t -> {
						code.setServiceFiscalCodeTree(t);
					});
					codeService.addEntity(code);
				}
				return SelectStatus.CONTINUE;
			}
		});
		
	}

	private PatriciaTrie<String , ServiceCodeEntry> populateTrie(List<ServiceCodeEntry> entries) {
		PatriciaTrie<String , ServiceCodeEntry> trie = 
						new PatriciaTrie<String , ServiceCodeEntry>(new CharSequenceKeyAnalyzer());
		entries
			.stream()
			.forEach(e ->{
				trie.put(e.getCode(), e);   
			});
		return trie;
	}

	private void adjustCode(ServiceCodeEntry entry) {
		String code = entry.getCode();
		String [] codePart = code.split("[.]");
		if(codePart.length==1) {
			String c1 = codePart[0];
			while(c1.length()<2)
				c1 = "0"+c1;
			entry.setCode(c1);
		}
		else if (codePart.length==2) {
			String c1 = codePart[0];
			while(c1.length()<2)
				c1 = "0"+c1;
			String c2 = codePart[1].trim();
			while(c2.length()<2)
				c2 = "0"+c2;
			if ("00".equals(c2)) {
				c2 ="";
				while(c1.length()<2)
					c1 = "0"+c1;
			}	
			entry.setCode(c1+c2);
		}
	}

	private String getValue(XSSFCell c) {
		CellType ct = c.getCellType();
		String ret = null;
		switch (ct) {
		case NUMERIC:
			ret = new Double(c.getNumericCellValue()).toString();
			break;
		case STRING:
			ret = c.getStringCellValue();
			break;
		case BLANK:
			ret= c.getStringCellValue();
			break;
		}
		return ret;
	}
}
