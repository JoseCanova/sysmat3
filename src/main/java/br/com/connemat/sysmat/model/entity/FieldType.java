package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.sysmat.model.entity.util.FieldTypeEnum;

@Table
@Entity(name="field_type")
@Valid
public class FieldType implements Base<FieldTypeEnum>{

	private static final long serialVersionUID = -3819242997937255944L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="type_code")
    @Enumerated(EnumType.STRING)
	private FieldTypeEnum id; 
	
	@Size(max=30 , groups= {UpdateValidationGroup.class, CreateValidationGroup.class})
	@NotEmpty(groups=UpdateValidationGroup.class)
	@Column(name="description")
	private String description;
	
	public FieldType() {
	}

	public FieldTypeEnum getId() {
		return id;
	}

	public void setId(FieldTypeEnum id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FieldType))
			return false;
		FieldType other = (FieldType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FieldType [id=" + id + ", description=" + description + "]";
	}
	
	
	
}
