package br.com.connemat.sysmat.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
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
@Table(name="pdm_approved_value")
@NamedEntityGraph(name = "PdmApprovedValue.descriptions" , attributeNodes = {@NamedAttributeNode("pdmApprovedValueDescriptions")})
public class PdmApprovedValue implements Base<Long>{

	private static final long serialVersionUID = 6539701622213068115L;

	@Id
	@Column(name="pdm_approved_value_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=90 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;

	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=90  , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbbreviation;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	private Boolean showIn;

	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_characteristic_id")
	private PdmCharacteristic pdmCharacteristic;

	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_value_id")
	private PdmValue pdmValue;
	
	@OneToMany(mappedBy = "pdmApprovedValue" , fetch = FetchType.LAZY)
	private Set<PdmApprovedValueAttribute> pdmApprovedValueAttributes;
	
	@OneToMany(mappedBy = "pdmApprovedValue"  , fetch = FetchType.LAZY)
	private Set<PdmApprovedValueDescription> pdmApprovedValueDescriptions;
	
	public PdmApprovedValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortAbbreviation() {
		return shortAbbreviation;
	}

	public void setShortAbbreviation(String shortAbbreviation) {
		this.shortAbbreviation = shortAbbreviation;
	}

	public String getLongAbbbreviation() {
		return longAbbbreviation;
	}

	public void setLongAbbbreviation(String longAbbbreviation) {
		this.longAbbbreviation = longAbbbreviation;
	}

	public PdmCharacteristic getPdmCharacteristic() {
		return pdmCharacteristic;
	}

	public void setPdmCharacteristic(PdmCharacteristic pdmCharacteristic) {
		this.pdmCharacteristic = pdmCharacteristic;
	}

	public PdmValue getPdmValue() {
		return pdmValue;
	}

	public void setPdmValue(PdmValue pdmValue) {
		this.pdmValue = pdmValue;
	}

	public Boolean getShowIn() {
		return showIn;
	}

	public void setShowIn(Boolean showIn) {
		this.showIn = showIn;
	}

	public Set<PdmApprovedValueAttribute> getPdmApprovedValueAttributes() {
		return pdmApprovedValueAttributes;
	}

	public void setPdmApprovedValueAttributes(Set<PdmApprovedValueAttribute> pdmApprovedValueAttributes) {
		this.pdmApprovedValueAttributes = pdmApprovedValueAttributes;
	}

	public Set<PdmApprovedValueDescription> getPdmApprovedValueDescriptions() {
		return pdmApprovedValueDescriptions;
	}

	public void setPdmApprovedValueDescriptions(Set<PdmApprovedValueDescription> pdmApprovedValueDescriptions) {
		this.pdmApprovedValueDescriptions = pdmApprovedValueDescriptions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((longAbbbreviation == null) ? 0 : longAbbbreviation.hashCode());
		result = prime * result + ((pdmCharacteristic == null) ? 0 : pdmCharacteristic.hashCode());
		result = prime * result + ((pdmValue == null) ? 0 : pdmValue.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		result = prime * result + ((showIn == null) ? 0 : showIn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmApprovedValue))
			return false;
		PdmApprovedValue other = (PdmApprovedValue) obj;
		if (longAbbbreviation == null) {
			if (other.longAbbbreviation != null)
				return false;
		} else if (!longAbbbreviation.equals(other.longAbbbreviation))
			return false;
		if (pdmCharacteristic == null) {
			if (other.pdmCharacteristic != null)
				return false;
		} else if (!pdmCharacteristic.equals(other.pdmCharacteristic))
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
		if (showIn == null) {
			if (other.showIn != null)
				return false;
		} else if (!showIn.equals(other.showIn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PdmApprovedvalue [id=" + id + ", shortAbbreviation=" + shortAbbreviation + ", longAbbbreviation="
				+ longAbbbreviation + ", showIn=" + showIn + ", pdmCharacteristic=" + pdmCharacteristic + ", pdmValue="
				+ pdmValue + "]";
	}

}
