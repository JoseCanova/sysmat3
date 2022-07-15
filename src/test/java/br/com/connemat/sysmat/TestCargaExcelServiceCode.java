package br.com.connemat.sysmat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.service.excel.ServiceFiscalCodeLoadService;

@SpringBootTest
public class TestCargaExcelServiceCode {

	@Autowired
	private ServiceFiscalCodeLoadService service;


	public TestCargaExcelServiceCode() {
	}

	@Test
	public void loadFileAndTrie() {
		service.loadServiceFiscalCode();
	}

}
