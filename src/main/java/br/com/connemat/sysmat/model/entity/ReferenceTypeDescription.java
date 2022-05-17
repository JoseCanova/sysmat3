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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;

@Valid
@Entity
@Table(name="reference_type_description")

@JsonInclude(Include.NON_EMPTY)
public class ReferenceTypeDescription implements Base<Long>{

	private static final long serialVersionUID = 2032032813240769587L;

	@Id
	@Column(name="reference_type_description_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id;
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale" , columnDefinition = "VARCHAR(10) NOT NULL")
	private String locale; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=20 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(20) NOT NULL")
	private String description; 
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reference_type_id" , columnDefinition = "VARCHAR(1) NOT NULL")
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	private ReferenceType referenceType;
	
	public ReferenceTypeDescription() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReferenceType getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ReferenceTypeDescription))
			return false;
		ReferenceTypeDescription other = (ReferenceTypeDescription) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	
}
