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

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;

@Valid
@Entity
@Table(name="pdm_characteristic_description")
public class PdmCharacteristicDescription implements Base<Long>{

	private static final long serialVersionUID = -7897123749498569034L;

	@Id
	@Column(name="pdm_characteristic_description_id")
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale;
	
	@Size(max=30 ,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="characteristic")
	private String characteristic;
	
	@Size(max=30 ,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;
	
	@Size(max=30 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbreviation;
	
	@JsonBackReference
	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name="pdm_characteristic_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private PdmCharacteristic pdmCharacteristic; 
	
	public PdmCharacteristicDescription() {
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

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
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

	public PdmCharacteristic getPdmCharacteristic() {
		return pdmCharacteristic;
	}

	public void setPdmCharacteristic(PdmCharacteristic pdmCharacteristic) {
		this.pdmCharacteristic = pdmCharacteristic;
	}
	
}
