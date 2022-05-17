package br.com.connemat.sysmat.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Valid
@Entity
@Table(name="reference_type")
@JsonInclude(Include.NON_EMPTY)
public class ReferenceType implements Base<String>{

	private static final long serialVersionUID = -1726277921545785778L;

	@Id
	@Size(max=1 , groups={CreateValidationGroup.class , UpdateValidationGroup.class})
	@NotEmpty(groups={CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="reference_type_id" , columnDefinition = "VARCHAR(1) NOT NULL")
	private String id;
	
	@Size(max=20 , groups={CreateValidationGroup.class , UpdateValidationGroup.class})
	@NotEmpty(groups={CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(20) NOT NULL")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY , 
			   mappedBy = "referenceType")
	private List<ReferenceTypeDescription> descriptions;
	
	public ReferenceType() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ReferenceTypeDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<ReferenceTypeDescription> descriptions) {
		this.descriptions = descriptions;
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
		if (!(obj instanceof ReferenceType))
			return false;
		ReferenceType other = (ReferenceType) obj;
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

}
