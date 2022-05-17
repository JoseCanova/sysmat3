package br.com.connemat.model.api;

import java.util.Map;

import br.com.connemat.Base;

public class SearchContainer <T extends Base<?>>{

	protected T entity;
	
	protected Map<String,String> sortParameters;

	public SearchContainer() {
		super();
	}

	public SearchContainer(T entity, Map<String, String> parameters) {
		super();
		this.entity = entity;
		this.sortParameters = parameters;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Map<String, String> getSortParameters() {
		return sortParameters;
	}

	public void setSortParameters(Map<String, String> sortParameters) {
		this.sortParameters = sortParameters;
	}

}
