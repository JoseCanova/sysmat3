package br.com.connemat.service.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.Map.Entry;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.connemat.NcmBaseService;
import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.Ncm;
import br.com.connemat.model.entity.NcmTree;
import br.com.connemat.util.tree.patricia.CharSequenceKeyAnalyzer;
import br.com.connemat.util.tree.patricia.PatriciaTrie;
import br.com.connemat.util.tree.patricia.PatriciaTrie.TrieEntry;
import br.com.connemat.util.tree.patricia.Trie.Cursor;

@Service
public class NcmCsvLoaderService {

	public NcmCsvLoaderService() {
	}

	@Autowired
	private NcmTreeBaseService ncmTreeService; 

	@Autowired 
	private NcmBaseService ncmService;

	private static final String FILE_TEST = "C:/Users/jccanova/git/sysmat3/sysmat/src/test/resources/nomenclatura.csv";

	public void loadNcmFile() {
		
		PatriciaTrie<String , NcmFileEntry> trie = new PatriciaTrie<String , NcmFileEntry>(new CharSequenceKeyAnalyzer()) ;
		
		try(	
				InputStream is  = new FileInputStream(new File(FILE_TEST));
				final Reader reader = new InputStreamReader(new BOMInputStream(is), "UTF-8");
				final CSVParser parser = new CSVParser(reader, CSVFormat.INFORMIX_UNLOAD_CSV.withIgnoreEmptyLines().withDelimiter('#'));
				) 
		{

			parser.forEach( csvRecord ->{
				processCsvRecord(csvRecord , trie);
			});
			trie.traverse(new Cursor <String , NcmFileEntry>(){

				@Override
				public SelectStatus select(Entry<? extends String, ? extends NcmFileEntry> entry) {
					System.err.println(" The entry " + entry);
					TrieEntry<String , NcmFileEntry> te = TrieEntry.class.cast(entry); 
					NcmFileEntry parentEntry = findClosestParent(te);
					NcmFileEntry fileEntry = entry.getValue();
					if(fileEntry.getCode().length() <=7) {
						NcmTree entryElement = toNcmTree(fileEntry);
						if (parentEntry !=null) {
							Optional<NcmTree> opt = ncmTreeService.findNcmTreeByCode(parentEntry.getCode());
							entryElement.setParent(opt.get());
						}
						addOrUpdateNcmTree(entryElement);
					}else {
						Ncm entryElement = toNcm(fileEntry);
						Optional<NcmTree> opt = ncmTreeService.findNcmTreeByCode(parentEntry.getCode());
						entryElement.setNcmTree(opt.get());
						addOrUpdateNcm(entryElement);
					}
					return SelectStatus.CONTINUE;
				}

				private void addOrUpdateNcm(Ncm entryElement) {
					ncmService
						.findNcmByNcmCode(entryElement.getNcmCode())
						.map(e -> {
							return ncmService.updateNcm(e.getNcmCode(), e);
						}).orElse(ncmService.addNcm(entryElement));
				}

				private void addOrUpdateNcmTree(NcmTree entryElement) {
					ncmTreeService.findNcmTreeByCode(entryElement.getCode())
					.map(e -> {
						entryElement.setId(e.getId());
						return ncmTreeService.updateEntity(e.getId(), entryElement);
					}).orElse(ncmTreeService.addEntity(entryElement));
				}

				private Ncm toNcm(NcmFileEntry fileEntry) {
					Ncm ncm = new Ncm();
					ncm.setNcmCode(fileEntry.getCode());
					ncm.setDescription(applyDescriptionFilter(fileEntry.getDescription()));
					ncm.setStartDate(LocalDate.now().withYear(1900).withDayOfYear(1));
					return ncm;
				}

				private String applyDescriptionFilter(String desc) {
					return desc !=null ? desc.replace("-- ", "").replace("- ", ""):null;
				}
				
				private NcmTree toNcmTree(NcmFileEntry parentEntry) {
					return new NcmTree(parentEntry.getCode() , applyDescriptionFilter(parentEntry.getDescription()));
				}

				private NcmFileEntry findClosestParent(TrieEntry<String, NcmFileEntry> te) {
					String key = te.getKey();
					NcmFileEntry entry = null; 
					int i = key.length();
					while (entry == null && te.getKey().length() > 2 && i>2) {
						key = key.substring(0 , --i);
						entry = trie.get(key);
						if (entry == null ||  !canBeParent( te.getKey() , entry.getCode())) {
							entry = null;
						}
					}
					if (entry !=null)
						System.err.println("Parent " + entry.getCode() + " Key " + te.getKey()); 
					return entry;
				}
				
				private boolean canBeParent(String childKey , String parentKey) {
					return childKey.startsWith(parentKey) && !childKey.equals(parentKey);
				}
				
			});
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void processCsvRecord(CSVRecord csvRecord, PatriciaTrie<String, NcmFileEntry> trie) {
			String code = csvRecord.get(0);
			String description = csvRecord.get(1);
			NcmFileEntry entry  = new NcmFileEntry(code.trim(), description);
			trie.put(code.trim(), entry);
	}
}
