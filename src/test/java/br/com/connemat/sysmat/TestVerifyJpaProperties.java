package br.com.connemat.sysmat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class TestVerifyJpaProperties {

	@Autowired
	private JpaProperties jpaProperties;
	 
	public TestVerifyJpaProperties() {
	}

	@Test
	void testJpaProperties() {
		assertNotNull(jpaProperties);
		jpaProperties
		.getProperties()
		.entrySet()
		.stream()
		.forEach((e) -> {
			System.err.println(e.getKey() + "\t" + e.getValue());
		});
	}
	
}
