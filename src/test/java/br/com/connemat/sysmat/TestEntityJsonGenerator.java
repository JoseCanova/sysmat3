package br.com.connemat.sysmat;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.connemat.sysmat.model.entity.Center;
import br.com.connemat.sysmat.model.entity.Company;
import br.com.connemat.sysmat.model.entity.Manufacturer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestEntityJsonGenerator {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	Validator validator;
	
	@Test
	void testeGenerateManufacturesJson() {
		Manufacturer theMan = createManufacturer();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.writeValue(writer, theMan);
			System.err.println(writer);
		}	catch(Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testeGenerateCompanyJson() {
		Company company = createCompany();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.writeValue(writer, company);
			System.err.println(writer);
		}	catch(Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	void testeGenerateCenterJson() {
		Center center = createCenter();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.writeValue(writer, center);
			System.err.println(writer);
		}	catch(Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	private Center createCenter() {
		Center center = new Center();
		center.setCode("code");
		center.setDisabled(true);
		center.setDescription("description");
		LocalDateTime now = LocalDateTime.now();
		center.setCreatedDate(now);
		center.setLastUpdatedDate(now);
		validateNewCenter(center);
		return center;
	}

	private void validateNewCenter(Center center) {
		assertTrue(validator.validate(center, Default.class).size()==0);
	}
	
	private Company createCompany() {
		Company company = new Company();
		company.setCode("the_code");
		company.setDisabled(true);
		company.setDescription("the_company_description");
		company.setComments("the company comments");
		return company;
	}

	private Manufacturer createManufacturer(){
		Manufacturer theMan = new Manufacturer();
		theMan.setCode("acode");
		theMan.setDisabled(false);
		theMan.setFullName("manufacturer_full_name");
		theMan.setShortName("shortName");
		return theMan;
	}

}
