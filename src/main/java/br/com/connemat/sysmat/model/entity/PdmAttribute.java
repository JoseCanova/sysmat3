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

@Valid
@Entity
@Table(name="pdm_attribute")
public class PdmAttribute implements Base<Long>{

	private static final long serialVersionUID = 2308809492953984229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_attribute")
	private String keyAttribute;
	
	@Column(name="value_atttribute")
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	private String valueAttribute;
	
	@JoinColumn(name="pdm_id")
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	private Pdm pdm;
	
	public PdmAttribute() {
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

	public Pdm getPdm() {
		return pdm;
	}

	public void setPdm(Pdm pdm) {
		this.pdm = pdm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyAttribute == null) ? 0 : keyAttribute.hashCode());
		result = prime * result + ((pdm == null) ? 0 : pdm.hashCode());
		result = prime * result + ((valueAttribute == null) ? 0 : valueAttribute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmAttribute))
			return false;
		PdmAttribute other = (PdmAttribute) obj;
		if (keyAttribute == null) {
			if (other.keyAttribute != null)
				return false;
		} else if (!keyAttribute.equals(other.keyAttribute))
			return false;
		if (pdm == null) {
			if (other.pdm != null)
				return false;
		} else if (!pdm.equals(other.pdm))
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
		return "PdmAttribute [id=" + id + ", keyAttribute=" + keyAttribute + ", valueAttribute=" + valueAttribute + "]";
	}
	
}
