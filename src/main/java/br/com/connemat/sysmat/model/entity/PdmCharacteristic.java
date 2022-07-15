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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocaleContext;

@Valid
@Entity
@Table(name="pdm_characteristic")
@NamedEntityGraph(name = "PdmCharacteristic.descriptions" , attributeNodes = {@NamedAttributeNode(value = "descriptions")})
public class PdmCharacteristic implements Base<Long>{

	private static final long serialVersionUID = -8158351564541658754L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups=UpdateValidationGroup.class)
	@Null(groups=CreateValidationGroup.class)
	@Column(name="pdm_characteristic_id")
	private Long id; 

	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="required")
	private Boolean required;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="order_position")
	private Integer order;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="priority_description")
	private Integer priority;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="show_in_description")
	private Integer showIn;
	
	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbreviation;

	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbbreviation;

	
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_id")
	private Pdm pdm;

	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups=CreateValidationGroup.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="characteristic_id")
	private Characteristic characteristic;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pdmCharacteristic" , fetch = FetchType.LAZY)
	private Set<PdmCharacteristicDescription> descriptions;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pdmCharacteristic" , fetch = FetchType.EAGER)
	private Set<PdmCharacteristicAttribute> attributes;
	
	public PdmCharacteristic() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getShowIn() {
		return showIn;
	}

	public void setShowIn(Integer showIn) {
		this.showIn = showIn;
	}

	public Pdm getPdm() {
		return pdm;
	}

	public void setPdm(Pdm pdm) {
		this.pdm = pdm;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
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

	public Set<PdmCharacteristicDescription> getDescriptions() {
		return descriptions == null ? descriptions = new HashSet<>() : descriptions;
	}

	public void setDescriptions(Set<PdmCharacteristicDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<PdmCharacteristicAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<PdmCharacteristicAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getLocaleCharacteristic() {
		return getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d -> d.getCharacteristic())
				.orElse(getCharacteristic().getCharacteristic());
	}
	
	public String getLocaleShortAbbreviation() {
		return getDescriptions().stream()
					.filter(d->d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
					.findFirst()
					.map(d -> d.getShortAbbreviation()).orElse(getCharacteristic().getShortAbbreviation());
	}
	
	public String getLongAbbreviation() {
		return getDescriptions().stream()
					.filter(d ->d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
					.findFirst()
					.map(d ->d.getLongAbbreviation())
					.orElse(getCharacteristic().getLongAbbreviation());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((pdm == null) ? 0 : pdm.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((required == null) ? 0 : required.hashCode());
		result = prime * result + ((showIn == null) ? 0 : showIn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmCharacteristic))
			return false;
		PdmCharacteristic other = (PdmCharacteristic) obj;
		if (characteristic == null) {
			if (other.characteristic != null)
				return false;
		} else if (!characteristic.equals(other.characteristic))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (pdm == null) {
			if (other.pdm != null)
				return false;
		} else if (!pdm.equals(other.pdm))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (required == null) {
			if (other.required != null)
				return false;
		} else if (!required.equals(other.required))
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
		return "PdmCharacteristic [id=" + id + ", required=" + required + ", order=" + order + ", priority=" + priority
				+ ", showIn=" + showIn + ", shortAbbreviation=" + shortAbbreviation + ", longAbbbreviation="
				+ longAbbbreviation + ", pdm=" + pdm + "]";
	}
	
	

}
