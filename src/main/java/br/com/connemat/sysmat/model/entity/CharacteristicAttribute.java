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
@Table(name="characteristic_attribute")
@Valid
public class CharacteristicAttribute implements Base<Long>{

	private static final long serialVersionUID = -3303963040197413428L;

	@Id
	@Column(name="characteristic_attribute_id" , columnDefinition = "INT NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_attribute_id" , columnDefinition = "VARCHAR(50) NOT NULL")
	private String attributeId; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="attribute_value" , columnDefinition = "TEXT NOT NULL")
	private String attributeValue;

	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="characteristic_id" , columnDefinition = "INT NOT NULL")
	private Characteristic characteristic;

	public CharacteristicAttribute() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result + ((attributeValue == null) ? 0 : attributeValue.hashCode());
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CharacteristicAttribute))
			return false;
		CharacteristicAttribute other = (CharacteristicAttribute) obj;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
		if (attributeValue == null) {
			if (other.attributeValue != null)
				return false;
		} else if (!attributeValue.equals(other.attributeValue))
			return false;
		if (characteristic == null) {
			if (other.characteristic != null)
				return false;
		} else if (!characteristic.equals(other.characteristic))
			return false;
		return true;
	}

}
