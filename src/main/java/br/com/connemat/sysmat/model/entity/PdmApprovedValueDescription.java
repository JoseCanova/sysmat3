package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="pdm_approved_value_description")
public class PdmApprovedValueDescription implements Base<Long> {

	private static final long serialVersionUID = 4955339345097492168L;

	@Id
	@Column(name="pdm_approved_value_description_id")
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=255,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="pdm_value")
	private String pdmValue; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=90,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=90,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbreviation;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_approved_value_id")
	private  PdmApprovedValue pdmApprovedValue;
	
	public PdmApprovedValueDescription() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getPdmValue() {
		return pdmValue;
	}

	public void setPdmValue(String pdmValue) {
		this.pdmValue = pdmValue;
	}

	public String getShortAbbreviation() {
		return shortAbbreviation;
	}

	public void setShortAbbreviation(String shortAbbreviation) {
		this.shortAbbreviation = shortAbbreviation;
	}

	public String getLongAbbreviation() {
		return longAbbreviation;
	}

	public void setLongAbbreviation(String longAbbreviation) {
		this.longAbbreviation = longAbbreviation;
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
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((longAbbreviation == null) ? 0 : longAbbreviation.hashCode());
		result = prime * result + ((pdmApprovedValue == null) ? 0 : pdmApprovedValue.hashCode());
		result = prime * result + ((pdmValue == null) ? 0 : pdmValue.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmApprovedValueDescription))
			return false;
		PdmApprovedValueDescription other = (PdmApprovedValueDescription) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (longAbbreviation == null) {
			if (other.longAbbreviation != null)
				return false;
		} else if (!longAbbreviation.equals(other.longAbbreviation))
			return false;
		if (pdmApprovedValue == null) {
			if (other.pdmApprovedValue != null)
				return false;
		} else if (!pdmApprovedValue.equals(other.pdmApprovedValue))
			return false;
		if (pdmValue == null) {
			if (other.pdmValue != null)
				return false;
		} else if (!pdmValue.equals(other.pdmValue))
			return false;
		if (shortAbbreviation == null) {
			if (other.shortAbbreviation != null)
				return false;
		} else if (!shortAbbreviation.equals(other.shortAbbreviation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PdmApprovedValueDescription [id=" + id + ", locale=" + locale + ", shortAbbreviation="
				+ shortAbbreviation + ", longAbbreviation=" + longAbbreviation + ", pdmApprovedValue="
				+ pdmApprovedValue + "]";
	}
	
	
}
