package br.com.connemat.sysmat.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Entity
@Table(name="unit"  , 
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code"} , name = "unit_code_uk"),
        @UniqueConstraint(columnNames = {"erp_id"} , name = "unit_erpid_uk")}
)
@Valid

@JsonInclude(Include.NON_EMPTY)
public class Unit implements Base<Long>{

	private static final long serialVersionUID = -8882851219418221082L;

	@Id
	@NotNull(groups = {UpdateValidationGroup.class })
	@Null(groups=CreateValidationGroup.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="unit_id" , columnDefinition = "INT NOT NULL")
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Size(max=5 , groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(5) NOT NULL")
	private String code; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Size(max=30,groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(30) NOT NULL")
	private String description;
	
	@NotNull(groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Column(name="disabled" , columnDefinition="BOOLEAN NOT NULL")
	private Boolean disabled;
	
	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@Size(max=10 , groups = {UpdateValidationGroup.class ,CreateValidationGroup.class})
	@Column(name="erp_id" , columnDefinition = "VARCHAR(10)")
	private String erpId;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "unit")
	private List<UnitDescription> descriptions;
	
	public Unit() {
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

	public String getErpId() {
		return erpId;
	}

	public void setErpId(String erpId) {
		this.erpId = erpId;
	}

	public List<UnitDescription> getDescriptions() {
		if (descriptions == null)
			descriptions = new ArrayList<>();
		return descriptions;
	}

	public void setDescriptions(List<UnitDescription> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disabled ? 1231 : 1237);
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Unit))
			return false;
		Unit other = (Unit) obj;
		if (disabled != other.disabled)
			return false;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
