package br.com.connemat.sysmat;

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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.NcmBaseService;
import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.Ncm;
import br.com.connemat.model.entity.NcmTree;
import br.com.connemat.service.csv.NcmCsvLoaderService;
import br.com.connemat.service.csv.NcmFileEntry;
import br.com.connemat.util.tree.patricia.CharSequenceKeyAnalyzer;
import br.com.connemat.util.tree.patricia.PatriciaTrie;
import br.com.connemat.util.tree.patricia.PatriciaTrie.TrieEntry;
import br.com.connemat.util.tree.patricia.Trie.Cursor;

@SpringBootTest
public class TestCargaCsvNcm {

	@Autowired
	private NcmCsvLoaderService ncmLoaderService;

	@Autowired
	private NcmTreeBaseService ncmTreeService; 

	@Autowired 
	private NcmBaseService ncmService;

	private static final String FILE_TEST = "C:/Users/jccanova/git/sysmat3/sysmat/src/test/resources/nomenclatura.csv";

	public TestCargaCsvNcm() {
	}

	@Test
	public void loadFileAndTrie() {
		ncmLoaderService.loadNcmFile();
	}

}
