package br.com.connemat.sysmat.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocaleContext;

@Entity
@Table(name="subcategory")
@NamedEntityGraphs(@NamedEntityGraph(name="SubCategory.descriptions" , attributeNodes = {@NamedAttributeNode(value = "descriptions")}))
public class SubCategory implements Base<Long>{
	
	
	private static final long serialVersionUID = -6774434042767900147L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subcategory_id")
	@NotNull(groups = { UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@Size(max=60 ,  groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@NotEmpty(groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="description")
	private String description;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany( fetch = FetchType.LAZY , mappedBy = "subCategory")
	private List<SubCategoryDescription> descriptions;

	@OneToMany( fetch = FetchType.LAZY , mappedBy = "subCategory")
	private List<SubCategoryAttribute> attributes;
	
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@NotNull(groups = {CreateValidationGroup.class , UpdateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;
	

	public SubCategory() {
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public List<SubCategoryDescription> getDescriptions() {
		if (descriptions == null)
			descriptions = new ArrayList<>();
		return descriptions;
	}

	public void setDescriptions(List<SubCategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	public List<SubCategoryAttribute> getAttributes() {
		if(attributes == null)
			attributes=new ArrayList<>();
		return attributes;
	}

	public void setAttributes(List<SubCategoryAttribute> attributes) {
		this.attributes = attributes;
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
		if (!(obj instanceof SubCategory))
			return false;
		SubCategory other = (SubCategory) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	
	
	public String getLocaleDescription() {
		return getDescriptions().stream()
				.filter(d ->d.getLocale().equals(LocaleContext.getCurrentLocale().getLanguage()))
				.findFirst()
				.map(d ->d.getDescription())
				.orElse(description);
	}

	@Override
	public String toString() {
		return "SubCategory [ id=" + id + ", description=" + description + ", descriptions=" + descriptions
				+ ", attributes=" + attributes + " ]";
	}

}
