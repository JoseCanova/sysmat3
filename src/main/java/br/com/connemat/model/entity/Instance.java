package br.com.connemat.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocalDateTimeDeserializer;
import br.com.connemat.util.LocalDateTimeSerializer;

@Valid
@Entity
@Table(name="instance")
public class Instance  implements Base<Long>{

	private static final long serialVersionUID = 7688160195475139365L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instance_id")
	@NotNull(groups = {UpdateValidationGroup.class})
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code")
	private String code; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=50,groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description")
	private String description; 
	
	@Column(name="logo")
	@Basic(fetch=FetchType.LAZY)
	private String logo;

	@Column(name="logo_small")
	@Basic(fetch=FetchType.LAZY)
	private String logoSmall;

	@Column(name="manual")
	@Basic(fetch=FetchType.LAZY)
	private String manual;
	
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="active")
	private boolean active;
	
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="activation_time")	
	private LocalDateTime activationTime;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name="deactivation_time")	
	private LocalDateTime deactivationTime;

	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "instance" , cascade = CascadeType.REMOVE)
	private InstanceDataSourceConfig instanceConfigDataSource;
	
	@JsonSerialize(using = JsonBaseSerializer.class)
	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sector_id")
	private Sector sector;
	
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getLogoSmall() {
		return logoSmall;
	}

	public void setLogoSmall(String logoSmall) {
		this.logoSmall = logoSmall;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public InstanceDataSourceConfig getInstanceConfigDataSource() {
		return instanceConfigDataSource;
	}

	public void setInstanceConfigDataSource(InstanceDataSourceConfig instanceConfigDataSource) {
		this.instanceConfigDataSource = instanceConfigDataSource;
	} 
	
	public boolean isActive() {
		return active;
	}

	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public LocalDateTime getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(LocalDateTime activationTime) {
		this.activationTime = activationTime;
	}

	public LocalDateTime getDeactivationTime() {
		return deactivationTime;
	}

	public void setDeactivationTime(LocalDateTime deactivationTime) {
		this.deactivationTime = deactivationTime;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instance other = (Instance) obj;
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
		return true;
	}

}
