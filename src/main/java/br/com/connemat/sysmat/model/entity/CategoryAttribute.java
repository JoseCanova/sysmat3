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
@Table(name="category_attribute")
@Valid
public class CategoryAttribute implements Base<Long>{

	private static final long serialVersionUID = -3303963040197413428L;

	@Id
	@Column(name="category_attribute_id" , columnDefinition = "INT NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_attribute" , columnDefinition = "VARCHAR(50) NOT NULL")
	private String keyAttribute; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="value_attribute" , columnDefinition = "TEXT NOT NULL")
	private String attributeValue;

	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id" , columnDefinition = "INT NOT NULL")
	private Category category;

	public CategoryAttribute() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyAttribute() {
		return keyAttribute;
	}

	public void setKeyAttribute(String keyAttribute) {
		this.keyAttribute = keyAttribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeValue == null) ? 0 : attributeValue.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((keyAttribute == null) ? 0 : keyAttribute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CategoryAttribute))
			return false;
		CategoryAttribute other = (CategoryAttribute) obj;
		if (attributeValue == null) {
			if (other.attributeValue != null)
				return false;
		} else if (!attributeValue.equals(other.attributeValue))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (keyAttribute == null) {
			if (other.keyAttribute != null)
				return false;
		} else if (!keyAttribute.equals(other.keyAttribute))
			return false;
		return true;
	}
	

	

}
