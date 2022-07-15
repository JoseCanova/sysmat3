package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Entity
@Table(name="company",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code"} , name = "company_code_uk")}
)
@Valid
@JsonInclude(Include.NON_EMPTY)
public class Company implements Base<Long>{

	private static final long serialVersionUID = 2058176614140860033L;

	@Id
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id" , columnDefinition = "INT NOT NULL")
	private Long id; 
	
	@NotEmpty(message="{company.code}" , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(10) NOT NULL")
	private String code; 
	
	@NotEmpty(message="{company.description}" , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=40 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(40) NOT NULL")
	private String description;
	
	@NotNull(message="{company.active}" , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="disabled" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean disabled; 
	
	@Size(max=250 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="comments" , columnDefinition = "VARCHAR(250)")
	private String comments;
	
	public Company() {
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


	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Company))
			return false;
		Company other = (Company) obj;
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Company [code=" + code + ", description=" + description + ", disabled=" + disabled + ", comments="
				+ comments + "]";
	}

}
