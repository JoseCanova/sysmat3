package br.com.connemat.util;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.connemat.sysmat.exception.SysmatEntityException;

@Component
public class EntityExceptionSupplierFactory {

	@Autowired
	private MessageSource messageSource; 
	
	public EntityExceptionSupplierFactory() {
	}

	public  Supplier<SysmatEntityException> applyMessage(String messageKey) {
		Holder<String> holder = new Holder<>();
		try {
			String message = messageSource.getMessage(messageKey, null, LocaleContext.getCurrentLocale());
			holder.put(message);
		}catch(Exception ex) {}
	    return () -> new SysmatEntityException(holder.get().orElse(""));
	}
}
