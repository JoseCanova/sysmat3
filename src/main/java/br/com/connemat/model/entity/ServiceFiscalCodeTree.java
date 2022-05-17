package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="service_fiscal_code_tree")
public class ServiceFiscalCodeTree implements Base<Long>{

	private static final long serialVersionUID = 1208910867399417223L;

	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=3,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(3) NOT NULL")
	private String code;
	
	@Size(max=1200,groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description"  , columnDefinition = "VARCHAR(1200) NOT NULL")
	private String description;
	
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using = JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="service_fiscal_code_tree_parent_id")
	private ServiceFiscalCodeTree parent;
	
	public ServiceFiscalCodeTree() {
		super();
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

	public ServiceFiscalCodeTree getParent() {
		return parent;
	}

	public void setParent(ServiceFiscalCodeTree parent) {
		this.parent = parent;
	}
	
	
}


