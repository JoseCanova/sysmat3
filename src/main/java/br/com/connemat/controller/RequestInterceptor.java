package br.com.connemat.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import br.com.connemat.spring.datasource.TenantContext;
import br.com.connemat.util.LocaleContext;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private AcceptHeaderLocaleResolver acceptHeaderLocaleResolver;
	
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        String tenantID = request.getHeader("X-TenantID");
        if (tenantID != null) {
        	TenantContext.setCurrentTenant(tenantID);
        }
        TenantContext.setCurrentTenant(tenantID);
        Locale locale = Optional.ofNullable( acceptHeaderLocaleResolver.resolveLocale(request)).orElse(Locale.getDefault());
        LocaleContext.setCurrentLocale(locale);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
        LocaleContext.clear();
    }
}