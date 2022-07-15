package br.com.connemat.sysmat.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.util.LocaleContext;

@Valid
@Entity
@Table(name="characteristic")
@NamedEntityGraph(name = "Characteristic.descriptions" , attributeNodes = @NamedAttributeNode(value = "descriptions"))
public class Characteristic implements Base<Long> {
	
	private static final long serialVersionUID = 3171771896824793268L;

	@Id
	@Column(name="characteristic_id")
	@NotNull(groups= {UpdateValidationGroup.class})
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="characteristic")
	private String characteristic;
	
	@Size(max=30)
	@Column(name="short_abbreviation")
	private String shortAbbreviation;

	@Size(max=30)
	@Column(name="long_abbreviation")
	private String longAbbreviation;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "theCharacteristic")
	private Set<CharacteristicDescription> descriptions;

	public Characteristic() {
	}

	@Override
	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CharacteristicDescription> getDescriptions() {
		return descriptions == null ? descriptions = new HashSet<>() : descriptions;
	}

	public void setDescriptions(Set<CharacteristicDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public String getLongAbbreviation() {
		return longAbbreviation;
	}

	public void setLongAbbreviation(String longAbbreviation) {
		this.longAbbreviation = longAbbreviation;
	}
	
	public String getLocaleCharacteristic() {
		return getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d -> d.getCharacteristic())
				.orElse(getCharacteristic());
	}
	
	public String getLocaleShortAbbreviation() {
		return getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getShortAbbreviation())
				.orElse(getShortAbbreviation());
	}
	

	public String getLocaleLongAbbreviation() {
		return getDescriptions()
				.stream()
				.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getLongAbbreviation())
				.orElse(getLongAbbreviation());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((longAbbreviation == null) ? 0 : longAbbreviation.hashCode());
		result = prime * result + ((shortAbbreviation == null) ? 0 : shortAbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Characteristic))
			return false;
		Characteristic other = (Characteristic) obj;
		if (characteristic == null) {
			if (other.characteristic != null)
				return false;
		} else if (!characteristic.equals(other.characteristic))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Characteristic [id=" + id + ", characteristic=" + characteristic + ", shortAbbreviation="
				+ shortAbbreviation + ", longAbbreviation=" + longAbbreviation + "]";
	}

}
