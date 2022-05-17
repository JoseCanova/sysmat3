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
@Table(name="category_description")
@Valid
public class CategoryDescription implements Base<Long>{

	private static final long serialVersionUID = 6355056536410116031L;

	@Id
	@Column(name="category_description_id" , columnDefinition = "INT NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 

	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10  , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=60 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description")
	private String description;
	
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id" , columnDefinition = "INT NOT NULL")
	private Category category;
	
	public CategoryDescription() {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		if (!(obj instanceof CategoryDescription))
			return false;
		CategoryDescription other = (CategoryDescription) obj;
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
