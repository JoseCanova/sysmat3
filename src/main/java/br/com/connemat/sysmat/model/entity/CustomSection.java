package br.com.connemat.sysmat.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Entity
@Table(name="custom_section")
@Valid
public class CustomSection implements Base<Long> {

	private static final long serialVersionUID = 7601424911176351747L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custom_section_id" , columnDefinition = "INT NOT NULL")
	private Long id;
	
	@Size(max=20 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(20) NOT NULL")
	private String code; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=40 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(40) NOT NULL")
	private String description;
	
	@Positive(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="order_position" , columnDefinition = "INT NOT NULL")
	private Integer orderPosition;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<CustomField> customFields;
	
	public CustomSection() {
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

	public Integer getOrderPosition() {
		return orderPosition;
	}

	public void setOrderPosition(Integer orderPosition) {
		this.orderPosition = orderPosition;
	}

	public Set<CustomField> getCustomFields() {
		if (customFields==null)
			customFields=new HashSet<>();
		return customFields;
	}

	public void setCustomFields(Set<CustomField> customFields) {
		this.customFields = customFields;
	}

}
