package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import br.com.connemat.spring.datasource.TenantContext;
import br.com.connemat.sysmat.model.entity.NameValueEntity;
import br.com.connemat.sysmat.service.NameValueService;


@SpringBootTest
public class TestTenantDatasourceConfiguration {

	@Autowired 
	EntityManagerFactory tenantEntityManagerFactory; 
	
	@Autowired
	NameValueService nvService; 
	
	public TestTenantDatasourceConfiguration() {
	}
	
	@Test
	void testEntityManagerFactory() {
		assertNotNull(tenantEntityManagerFactory);
	}

	@Test
	void testCreateNameValueDefaultDataSource() {
		assertNotNull(nvService);
		NameValueEntity nv = new NameValueEntity();
		nv.setName("the_name");
		nv.setValue("the_value");
		NameValueEntity nv1 = nvService.save(nv);
		assertNotNull(nv1);
		nvService.delete(nv1);
	}
	
	@Test 
	void testTenantMultipleDataSourceConfiguration() {
		assertNotNull(nvService);
		TenantContext.setCurrentTenant("schindler");
		NameValueEntity nv = new NameValueEntity();
		nv.setName("the_name");
		nv.setValue("the_value");
		NameValueEntity nv1 = nvService.save(nv);
		assertNotNull(nv1);
		TenantContext.setCurrentTenant("uhg");
		List<?> list = nvService.findAll();
		assertTrue(list.size() == 0);
		TenantContext.setCurrentTenant("schindler");
		Example ex = Example.of(nv1);
		NameValueEntity nv2 = (NameValueEntity) nvService.findOne(ex).get();
		assertNotNull(nv2);
		assertTrue("the_name".equals(nv2.getName()));
		nvService.delete(nv2);
		List<?> list1 = nvService.findAll();
		assertTrue(list1.size() == 0);
	}
}
