package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Entity
@Table(name="manufacturer")
@Valid
public class Manufacturer implements Base<Long>{


	private static final long serialVersionUID = -2593912348509220831L;

	@Id
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manufacturer_id" )
	private Long id;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=20 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_name" )
	private String shortName; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=50,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="full_name" )
	private String fullName;

	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=1,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="type" )
	private String type;
	
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="disabled")
	private Boolean disabled;
	
	@Size(max=20,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code")
	private String code;
	
	@Size(max=20,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="erp_id")
	private String erpId;
	
	
	public Manufacturer() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getErpId() {
		return erpId;
	}


	public void setErpId(String erpId) {
		this.erpId = erpId;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Manufacturer))
			return false;
		Manufacturer other = (Manufacturer) obj;
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", shortName=" + shortName + ", fullName=" + fullName + ", type=" + type
				+ ", disabled=" + disabled + ", code=" + code + ", erpId=" + erpId + "]";
	}

}
