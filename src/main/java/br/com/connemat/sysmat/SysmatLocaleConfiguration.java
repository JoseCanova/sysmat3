package br.com.connemat.sysmat;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import br.com.connemat.JvmFixedLocaleResolver;

@Configuration
public class SysmatLocaleConfiguration {

	public SysmatLocaleConfiguration() {
	}

	@Bean
	@Qualifier(value="fixedLocaleResolver")
	public JvmFixedLocaleResolver fixedLocalResolver() {
		JvmFixedLocaleResolver jr =  new JvmFixedLocaleResolver();
		jr.setDefaultLocale(Locale.getDefault());
		return jr;
	}
	
	@Bean
	public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver() {
		return new AcceptHeaderLocaleResolver();
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
}
