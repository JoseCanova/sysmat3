package br.com.connemat.sysmat.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="custom_field")
@Valid
@JsonInclude(Include.NON_EMPTY)
public class CustomField implements Base<Long>{

	private static final long serialVersionUID = -6063174167240827557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custom_field_id" , columnDefinition = "INT NOT NULL")
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id; 
	
	@AssertFalse(groups= {CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="disabled" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean disabled;
	
	@Size(max=20 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(20) NOT NULL")
	private String code;
	
	@Size(max=40 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(40) NOT NULL")
	private String description;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="menu" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean menu;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="required" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean required;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="multivalue" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean multivalue;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="editable" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean editable;
	
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="exibition_depends_values" , columnDefinition = "BOOLEAN NOT NULL")
	private Boolean exibitionDependent;
	
	@PositiveOrZero(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="max_length" , columnDefinition = "INT NOT NULL")
	private Integer maxLength;
	
	@PositiveOrZero(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="order_position" , columnDefinition = "INT NOT NULL")
	private Integer order;
	
	@Size(max=40 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="mask" , columnDefinition = "VARCHAR(40) NOT NULL")
	private String mask;

	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="type_code")
	private FieldType fieldType;
	
	/**@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="custom_section_id" , columnDefinition = "INT NOT NULL")
	private CustomSection customSection;**/
	
	@OneToMany(mappedBy = "field" , orphanRemoval = true , cascade = CascadeType.REMOVE)
	private Set<CustomValue> values; 
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "custom_config", 
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "custom_value_id" , name="custom_value_id")},
	joinColumns = {@JoinColumn(referencedColumnName = "custom_field_id" , name="custom_field_id")})
	private Set<CustomValue> customConfig;

	public CustomField() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
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

	public Boolean getMenu() {
		return menu;
	}

	public void setMenu(Boolean menu) {
		this.menu = menu;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getMultivalue() {
		return multivalue;
	}

	public void setMultivalue(Boolean multivalue) {
		this.multivalue = multivalue;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getExibitionDependent() {
		return exibitionDependent;
	}

	public void setExibitionDependent(Boolean exibitionDependent) {
		this.exibitionDependent = exibitionDependent;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

/**	public CustomSection getCustomSection() {
		return customSection;
	}

	public void setCustomSection(CustomSection customSection) {
		this.customSection = customSection;
	}**/

	public Set<CustomValue> getValues() {
		return values;
	}

	public void setValues(Set<CustomValue> values) {
		this.values = values;
	}

	public Set<CustomValue> getCustomConfig() {
		return customConfig;
	}

	public void setCustomConfig(Set<CustomValue> customConfig) {
		this.customConfig = customConfig;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + ((editable == null) ? 0 : editable.hashCode());
		result = prime * result + ((exibitionDependent == null) ? 0 : exibitionDependent.hashCode());
		result = prime * result + ((fieldType == null) ? 0 : fieldType.hashCode());
		result = prime * result + ((maxLength == null) ? 0 : maxLength.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((multivalue == null) ? 0 : multivalue.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((required == null) ? 0 : required.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CustomField))
			return false;
		CustomField other = (CustomField) obj;
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
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
		if (editable == null) {
			if (other.editable != null)
				return false;
		} else if (!editable.equals(other.editable))
			return false;
		if (exibitionDependent == null) {
			if (other.exibitionDependent != null)
				return false;
		} else if (!exibitionDependent.equals(other.exibitionDependent))
			return false;
		if (fieldType == null) {
			if (other.fieldType != null)
				return false;
		} else if (!fieldType.equals(other.fieldType))
			return false;
		if (maxLength == null) {
			if (other.maxLength != null)
				return false;
		} else if (!maxLength.equals(other.maxLength))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (multivalue == null) {
			if (other.multivalue != null)
				return false;
		} else if (!multivalue.equals(other.multivalue))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (required == null) {
			if (other.required != null)
				return false;
		} else if (!required.equals(other.required))
			return false;
		return true;
	}

}
