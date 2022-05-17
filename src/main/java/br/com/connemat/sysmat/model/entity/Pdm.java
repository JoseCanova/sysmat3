package br.com.connemat.sysmat.model.entity;

import java.util.HashSet;
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
import br.com.connemat.util.LocaleContext;

@Valid
@Entity
@Table(name="pdm")
@NamedEntityGraph(name="Pdm.descriptions" , attributeNodes = {@NamedAttributeNode(value = "descriptions")})
public class Pdm implements Base<Long>{

	private static final long serialVersionUID = -5167190192703787220L;

	@Id
	@NotNull(groups=UpdateValidationGroup.class)
	@Null(groups=CreateValidationGroup.class)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="pdm_id")
	private Long id; 

	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=50, groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="pdm_name")
	private String pdmName; 
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="disabled")
	private Boolean disabled;
	
	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;

	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbreviation;

	
	@JsonSerialize(using = JsonBaseSerializer.class)
	@NotNull( groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@BaseConstraint( groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name="subcategory_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private SubCategory subCategory;
	
	@OneToMany(mappedBy = "pdm" , fetch = FetchType.LAZY)
	private Set<PdmCharacteristic> characteristics;

	@OneToMany(mappedBy = "pdm" , fetch = FetchType.LAZY)
	private Set<PdmValue> pdmValues;
	
	@OneToMany(mappedBy = "pdm" , fetch = FetchType.LAZY)
	private Set<PdmDescription> descriptions;

	@OneToMany
	private Set<PdmAttribute> attributes;
	
	public Pdm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPdmName() {
		return pdmName;
	}

	public void setPdmName(String pdmName) {
		this.pdmName = pdmName;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	public Set<PdmCharacteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(Set<PdmCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public Set<PdmValue> getPdmValues() {
		return pdmValues;
	}

	public void setPdmValues(Set<PdmValue> pdmValues) {
		this.pdmValues = pdmValues;
	}

	public Set<PdmDescription> getDescriptions() {
		return descriptions == null ? descriptions = new HashSet<>() : descriptions;
	}

	public void setDescriptions(Set<PdmDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<PdmAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<PdmAttribute> attributes) {
		this.attributes = attributes;
	}
	
	
	
	public String getLocaleDescription() {
		return getDescriptions()
				.stream()
				.filter(d ->{
					return d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage());
				})
				.findFirst()
				.map(d -> d.getPdmName())
				.orElse(getPdmName());
	}
	
	public String getLocaleShortAbbreviation() {
		return 
				getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d -> d.getShortAbbbreviation())
				.orElse(getShortAbbreviation());
	}
	
	public String getLocaleLongAbbreviation() {
		return 
				getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d -> d.getLongAbbbreviation())
				.orElse(getLongAbbreviation());
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
	
}