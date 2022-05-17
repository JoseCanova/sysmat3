package br.com.connemat;

public interface UrlBaseLocator {

	default String getBaseUrl(Base<?> base) {
		return "/"+base.getId();
	}
	
}
