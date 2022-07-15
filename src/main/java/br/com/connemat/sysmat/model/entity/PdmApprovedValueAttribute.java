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
@Valid
@Table(name="pdm_approved_value_attribute")
public class PdmApprovedValueAttribute implements Base<Long>{

	private static final long serialVersionUID = -6406438815480087071L;

	@Id
	@Column(name="pdm_approved_value_attribute_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id;
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class})
	@Size(max=50 , groups= {UpdateValidationGroup.class,CreateValidationGroup.class})
	@Column(name="key_attribute")
	private String keyAttribute; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class})
	@Column(name="value_attribute")
	private String valueAttrbute; 
	
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class,CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class,CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_approved_value_id")
	private PdmApprovedValue pdmApprovedValue; 
	
	
	public PdmApprovedValueAttribute() {
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


	public String getValueAttrbute() {
		return valueAttrbute;
	}


	public void setValueAttrbute(String valueAttrbute) {
		this.valueAttrbute = valueAttrbute;
	}


	public PdmApprovedValue getPdmApprovedValue() {
		return pdmApprovedValue;
	}


	public void setPdmApprovedValue(PdmApprovedValue pdmApprovedValue) {
		this.pdmApprovedValue = pdmApprovedValue;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyAttribute == null) ? 0 : keyAttribute.hashCode());
		result = prime * result + ((pdmApprovedValue == null) ? 0 : pdmApprovedValue.hashCode());
		result = prime * result + ((valueAttrbute == null) ? 0 : valueAttrbute.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmApprovedValueAttribute))
			return false;
		PdmApprovedValueAttribute other = (PdmApprovedValueAttribute) obj;
		if (keyAttribute == null) {
			if (other.keyAttribute != null)
				return false;
		} else if (!keyAttribute.equals(other.keyAttribute))
			return false;
		if (pdmApprovedValue == null) {
			if (other.pdmApprovedValue != null)
				return false;
		} else if (!pdmApprovedValue.equals(other.pdmApprovedValue))
			return false;
		if (valueAttrbute == null) {
			if (other.valueAttrbute != null)
				return false;
		} else if (!valueAttrbute.equals(other.valueAttrbute))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PdmApprovedValueAttribute [id=" + id + ", keyAttribute=" + keyAttribute + ", valueAttrbute="
				+ valueAttrbute + "]";
	}

	
	
}
