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

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;

@Valid
@Entity
@Table(name="pdm_characteristic_attribute")
public class PdmCharacteristicAttribute implements Base<Long>{

	private static final long serialVersionUID = 859667191364481586L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pdm_characteristic_attribute_id")
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_attribute_id" , columnDefinition = "VARCHAR(50) NOT NULL")
	private String attributeId; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="attribute_value" , columnDefinition = "TEXT NOT NULL")
	private String attributeValue;

	@JsonBackReference
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pdm_characteristic_id" )
	private PdmCharacteristic pdmCharacteristic;
	
	public PdmCharacteristicAttribute() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public PdmCharacteristic getPdmCharacteristic() {
		return pdmCharacteristic;
	}

	public void setPdmCharacteristic(PdmCharacteristic pdmCharacteristic) {
		this.pdmCharacteristic = pdmCharacteristic;
	}

}
