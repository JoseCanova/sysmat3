package br.com.connemat.model.entity;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.NcmTreeSerializer;

@Valid
@Entity
@Table(name="ncm_tree")
public class NcmTree implements Base<Long>{
	
	private static final long serialVersionUID = -3070762376025870107L;

	@Id
	@Column(name="ncm_tree_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	private Long id; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=7 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code")
	private String code; 
	
	@Size(max=1200,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description")
	private String description;
	
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using = NcmTreeSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ncm_tree_parent_id")
	private NcmTree parent;

	public NcmTree() {
	}

	public NcmTree(String code2, String description2) {
		this.code=code2;
		this.description=description2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public NcmTree getParent() {
		return parent;
	}

	public void setParent(NcmTree parent) {
		this.parent = parent;
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
		if (!(obj instanceof NcmTree))
			return false;
		NcmTree other = (NcmTree) obj;
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
		String str = parent !=null ? parent.getCode() !=null ? parent.getCode() : "" : ""; 
		return "NcmTree [code=" + code + ", description=" + description + ", parent=" + str + "]";
	}
	
}
