package br.com.connemat.model.entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Validated
@Valid
@Entity
@Table(name="sector")
public class Sector implements Base<Long>{

	private static final long serialVersionUID = 538965623525687249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sector_id")
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class,CreateValidationGroup.class})
	@Size(max = 50 , groups = {UpdateValidationGroup.class,CreateValidationGroup.class})
	@Column(name="description")
	private String description; 
	
	@OneToMany(fetch = FetchType.LAZY , cascade = {CascadeType.REMOVE} , mappedBy = "sector")
	private Set<Instance> instances;

	public Sector() {
		super();
	}

	public Sector(Long sectorId,  String description) {
		super();
		this.id = sectorId;
		this.description = description;
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

	public Set<Instance> getInstances() {
		return Optional.ofNullable(instances).orElse(new HashSet<>());
	}

	public void setInstances(Set<Instance> instances) {
		this.instances = instances;
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
		if (!(obj instanceof Sector))
			return false;
		Sector other = (Sector) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	} 

}
