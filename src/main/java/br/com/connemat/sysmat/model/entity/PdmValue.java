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
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.sysmat.model.entity.annotations.Locale;
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocaleContext;

@Entity
@Table(name="pdm_value")
@Valid
@NamedEntityGraphs(  @NamedEntityGraph(name = "PdmValue.descriptions", attributeNodes = @NamedAttributeNode( value = "descriptions")))
public class PdmValue 
implements Base<Long>{

	private static final long serialVersionUID = 1504695481817958348L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pdm_value_id")
	@NotNull(groups = {UpdateValidationGroup.class})
	private Long id;
	
	@Locale(propertyPath="descriptions.description")
	@NotEmpty(groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@Size(max=255 , groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@Column(name="pdm_value")
	private String pdmValue; 
	
	@Locale(propertyPath="descriptions.shortAbbreviation")
	@Size(max=90 , groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@Column(name="short_abbreviation" )
	private String shortAbbreviation;
	
	@Locale(propertyPath="descriptions.longAbbreviation")
	@Size(max=90 , groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@NotEmpty(groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbreviation;
	
	@Size(max=255 , groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@Column(name="comments" , columnDefinition = "VARCHAR(255) NOT NULL")
	private String comments; 
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "pdmValue")
	private Set<PdmValueDescription> descriptions;
	
	@NotNull(groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@BaseConstraint(groups = {UpdateValidationGroup.class, CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_id")
	private Pdm pdm;
	
	public PdmValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPdmValue() {
		return pdmValue;
	}

	public void setPdmValue(String pdmValue) {
		this.pdmValue = pdmValue;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<PdmValueDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<PdmValueDescription> descriptions) {
		this.descriptions = descriptions;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((longAbbreviation == null) ? 0 : longAbbreviation.hashCode());
		result = prime * result + ((pdmValue == null) ? 0 : pdmValue.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmValue))
			return false;
		PdmValue other = (PdmValue) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (longAbbreviation == null) {
			if (other.longAbbreviation != null)
				return false;
		} else if (!longAbbreviation.equals(other.longAbbreviation))
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
		return "PdmValue [id=" + id + ", pdmValue=" + pdmValue + ", shortAbbreviation=" + shortAbbreviation
				+ ", longAbbreviation=" + longAbbreviation + ", comments=" + comments + "]";
	}
	
	public String getLocaleShortAbbreviation() {
		return this
				.getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getShortAbbreviation())
				.orElse(getShortAbbreviation());
	}

	public String getLocaleLongAbbreviation() {
		return this
				.getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getLongAbbreviation())
				.orElse(getLongAbbreviation());
	}
	
	public String getLocaleDescription() {
		return this
				.getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getDescription())
				.orElse(getPdmValue());
	}
}