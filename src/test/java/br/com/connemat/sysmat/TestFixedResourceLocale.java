package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.JvmFixedLocaleResolver;

@SpringBootTest
public class TestFixedResourceLocale {

	@Autowired 
	private JvmFixedLocaleResolver fixedLocaleResolver;
	
	@Autowired 
	private Validator validator;
	
	public TestFixedResourceLocale() {
	}

	void testFixedResourceLocaleEnglish() {
		assertNotNull(fixedLocaleResolver);
		Locale locale = fixedLocaleResolver.getDefaultLocale();
		assertTrue("en".equals(locale.getLanguage()));
	}
	
	@Test
	void testMessageSource() {
		assertNotNull(fixedLocaleResolver);
		Locale locale = fixedLocaleResolver.getDefaultLocale();
		Name name = new Name();
		Set<ConstraintViolation<TestFixedResourceLocale.Name>> violations = validator.validate(name, Default.class);
		violations
			.stream()
			.forEach(v ->{
				System.err.println(v.getMessage());
			});
	}
	
	
	
	/**
	 * @author jccanova
	 *
	 */
	class Name{
		
		@NotEmpty(message = "{text.empty}")
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
		
	}
}
