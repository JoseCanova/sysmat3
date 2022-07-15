package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="pdm_value_attribute")
@Valid
public class PdmValueAttribute implements Base<Long>{

	private static final long serialVersionUID = 6685681408006995944L;

	@Id
	@Column(name="pdm_value_attribute_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	@Column(name="key_attribute")
	private String keyAttribute; 
	
	@Column(name="value_attribute")
	@NotEmpty(groups= {UpdateValidationGroup.class , 
			CreateValidationGroup.class })
	private String valueAttribute;
	
	@JsonSerialize(using = JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class , 
					  		CreateValidationGroup.class })
	@JoinColumn(name = "pdm_value_id")
	@NotNull(groups= {UpdateValidationGroup.class , 
					  CreateValidationGroup.class })
	@ManyToOne(fetch = FetchType.EAGER)
	private PdmValue pdmValue; 
	
	public PdmValueAttribute() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyAttribute() {
		return keyAttribute;
	}

	public void setKeyAttribute(String keyAttribute) {
		this.keyAttribute = keyAttribute;
	}

	public String getValueAttribute() {
		return valueAttribute;
	}

	public void setValueAttribute(String valueAttribute) {
		this.valueAttribute = valueAttribute;
	}

	public PdmValue getPdmValue() {
		return pdmValue;
	}

	public void setPdmValue(PdmValue pdmValue) {
		this.pdmValue = pdmValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyAttribute == null) ? 0 : keyAttribute.hashCode());
		result = prime * result + ((pdmValue == null) ? 0 : pdmValue.hashCode());
		result = prime * result + ((valueAttribute == null) ? 0 : valueAttribute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmValueAttribute))
			return false;
		PdmValueAttribute other = (PdmValueAttribute) obj;
		if (keyAttribute == null) {
			if (other.keyAttribute != null)
				return false;
		} else if (!keyAttribute.equals(other.keyAttribute))
			return false;
		if (pdmValue == null) {
			if (other.pdmValue != null)
				return false;
		} else if (!pdmValue.equals(other.pdmValue))
			return false;
		if (valueAttribute == null) {
			if (other.valueAttribute != null)
				return false;
		} else if (!valueAttribute.equals(other.valueAttribute))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PdmValueAttribute [id=" + id + ", keyAttribute=" + keyAttribute + ", valueAttribute=" + valueAttribute
				+ ", pdmValue=" + pdmValue + "]";
	}
	
}
