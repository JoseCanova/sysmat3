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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="pdm_value_description")
@Valid
@JsonInclude(Include.NON_EMPTY)
public class PdmValueDescription implements Base<Long>{

	private static final long serialVersionUID = -6400887836185714733L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pdm_value_description_id")
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale;
	
	@Size(max=90 ,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation" , columnDefinition = "VARCHAR(90) NOT NULL")
	private String shortAbbreviation;
	
	@Size(max=90 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation"  , columnDefinition = "VARCHAR(90) NOT NULL")
	private String longAbbreviation;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=255 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description")
	private String description;
	
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name="pdm_value_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private PdmValue pdmValue; 
	
	public PdmValueDescription() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((longAbbreviation == null) ? 0 : longAbbreviation.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmValueDescription))
			return false;
		PdmValueDescription other = (PdmValueDescription) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		if (shortAbbreviation == null) {
			if (other.shortAbbreviation != null)
				return false;
		} else if (!shortAbbreviation.equals(other.shortAbbreviation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PdmValueDescription [locale=" + locale + ", shortAbbreviation=" + shortAbbreviation
				+ ", longAbbreviation=" + longAbbreviation + ", description=" + description + "]";
	}

}
