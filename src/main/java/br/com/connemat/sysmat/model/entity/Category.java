package br.com.connemat.sysmat.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.util.LocaleContext;

@Entity
@Table(name="category")
@Valid
@NamedEntityGraph(name = "Category.descriptions" , attributeNodes = {@NamedAttributeNode("descriptions")})
public class Category implements  Base<Long>{
	
	private static final long serialVersionUID = -6774434042767900147L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id" , columnDefinition = "INT NOT NULL")
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 

	@Size(max=60 ,  groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@NotEmpty(groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(60) NOT NULL" , insertable = true , nullable = false , updatable = true)
	private String description;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "category")
	private Set<CategoryDescription> descriptions;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "category")
	private Set<CategoryAttribute> attributes;
	
	@OneToMany( fetch = FetchType.LAZY , mappedBy = "category")
	private Set<SubCategory> subCategories;
	
	public Category() {
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

	public Set<CategoryDescription> getDescriptions() {
		if (descriptions == null)
			descriptions = new HashSet<>();
		return descriptions;
	}

	public void setDescriptions(Set<CategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	public Set<CategoryAttribute> getAttributes() {
		if(attributes == null)
			attributes=new HashSet<>();
		return attributes;
	}

	public void setAttributes(Set<CategoryAttribute> attributes) {
		this.attributes = attributes;
	}

	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	public String getLocaleDescription() {
			return this
					.getDescriptions()
					.stream()
					.filter(d -> d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
					.findFirst()
					.map(d ->d.getDescription())
					.orElse(getDescription());
	}
}