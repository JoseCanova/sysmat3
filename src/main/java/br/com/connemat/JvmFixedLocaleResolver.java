package br.com.connemat;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.web.servlet.i18n.FixedLocaleResolver;

public class JvmFixedLocaleResolver extends FixedLocaleResolver {

	public JvmFixedLocaleResolver() {
	}

	public JvmFixedLocaleResolver(Locale locale) {
		super(locale);
	}

	public JvmFixedLocaleResolver(Locale locale, TimeZone timeZone) {
		super(locale, timeZone);
	}
	
	@Override
	public Locale getDefaultLocale() {
		return super.getDefaultLocale();
	}

}
