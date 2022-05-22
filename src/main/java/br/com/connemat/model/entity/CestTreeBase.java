package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Valid
@MappedSuperclass
public abstract class CestTreeBase  implements Base<Long>{
	
	protected static final long serialVersionUID = 1171752366331602794L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cest_tree_id" , columnDefinition = "INT NOT NULL")
	protected Long id;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=6, groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(6) NOT NULL")
	protected String code; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=1200, groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(1200) NOT NULL")
	protected String description;
	
	public CestTreeBase() {
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CestTreeBase))
			return false;
		CestTreeBase other = (CestTreeBase) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CestTree [, code=" + code + ", description=" + description + "]";
	}
	
}
