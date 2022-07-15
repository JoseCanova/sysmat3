package br.com.connemat.model.api;

import br.com.connemat.Base;

public class AttributeValue<T> implements Base<T>{

	private static final long serialVersionUID = -5703736035528304992L;
	
	private T id;
	
	public AttributeValue(T value) {
		this.id = value;
	}

	public T getId() {
		return id;
	}
	
	public boolean isPresent() {
		return id != null;
	}

}
