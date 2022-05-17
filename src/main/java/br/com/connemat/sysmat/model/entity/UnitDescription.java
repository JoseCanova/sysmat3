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

@Valid
@Entity
@Table(name="unit_description"  , 
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"locale", "unit_id"} , name = "locale_description_uk")})
@JsonInclude(Include.NON_EMPTY)
public class UnitDescription implements Base<Long>{

	private static final long serialVersionUID = 7107912447974880246L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="unit_description_id")
	@NotNull(groups = UpdateValidationGroup.class)
	@Null(groups = CreateValidationGroup.class)
	private Long id;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=30 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , nullable = false , 
	insertable = true  , updatable = true , columnDefinition = "VARCHAR(30) NOT NULL")
	private String description; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale" , nullable = false , 
	insertable = true  , updatable = true , columnDefinition = "VARCHAR(10) NOT NULL")
	private String locale;
	
	@Valid
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name="unit_id")
	@ManyToOne(optional = false , fetch = FetchType.LAZY)
	private Unit unit; 
	
	public UnitDescription() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
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
		if (!(obj instanceof UnitDescription))
			return false;
		UnitDescription other = (UnitDescription) obj;
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
