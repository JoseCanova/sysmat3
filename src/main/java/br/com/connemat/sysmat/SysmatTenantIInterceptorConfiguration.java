package br.com.connemat.sysmat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import br.com.connemat.controller.RequestInterceptor;

@Configuration
public class SysmatTenantIInterceptorConfiguration implements WebMvcConfigurer {

	@Autowired 
	LocaleChangeInterceptor localeChangeInterceptor;
	
    @Bean
    RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(getRequestInterceptor());
        registry.addInterceptor(localeChangeInterceptor);
    }
}