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
@Table(name="characteristic_description")
@Valid
public class CharacteristicDescription implements Base<Long>{

	private static final long serialVersionUID = -6400887836185714733L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="characteristic_description_id")
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale;
	
	@Size(max=30 ,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;
	
	@Size(max=30 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbreviation;
	
	@Size(max=30 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="characteristic")
	private String characteristic;
	
	@JsonSerialize(using = JsonBaseSerializer.class)
	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name="characteristic_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Characteristic theCharacteristic; 
	
	public CharacteristicDescription() {
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

	public Characteristic getTheCharacteristic() {
		return theCharacteristic;
	}

	public void setTheCharacteristic(Characteristic theCharacteristic) {
		this.theCharacteristic = theCharacteristic;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((longAbbreviation == null) ? 0 : longAbbreviation.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CharacteristicDescription))
			return false;
		CharacteristicDescription other = (CharacteristicDescription) obj;
		if (characteristic == null) {
			if (other.characteristic != null)
				return false;
		} else if (!characteristic.equals(other.characteristic))
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
		return "CharacteristicDescription [id=" + id + ", locale=" + locale + ", shortAbbreviation=" + shortAbbreviation
				+ ", longAbbreviation=" + longAbbreviation + ", characteristic=" + characteristic + "]";
	}

	

}
