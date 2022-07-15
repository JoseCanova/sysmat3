package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="name_value")
public class NameValueEntity {

	@Id
	@Column(name="name")
	private String name; 
	
	@Column(name="value")
	private String value; 
	
	public NameValueEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
