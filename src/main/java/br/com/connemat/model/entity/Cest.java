package br.com.connemat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@MappedSuperclass
public class Cest  {

	protected static final long serialVersionUID = -2270676434436349360L;

	@Column(name="description"  , columnDefinition = "VARCHAR(1200) NOT NULL")
	@NotEmpty(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Size(max=1200 , groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	protected String description;
	
	@NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="start_date"  , columnDefinition = "DATE NOT NULL")
	@PastOrPresent(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	protected LocalDate startDate; 
	
	@Column(name="end_date"  , columnDefinition = "DATE")
	@PastOrPresent(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	protected LocalDate endDate;
	
	@NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@BaseConstraint(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@JsonSerialize(using = JsonBaseSerializer.class)
	@ManyToOne
	@JoinColumn(name="cest_tree_id")
	protected CestTree cestTree;

	@BaseConstraint(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@JsonSerialize(using = JsonBaseSerializer.class)
	@ManyToOne
	@JoinTable(name="cest_has_ncm",
	joinColumns = @JoinColumn(name="cest_code" , referencedColumnName = "cest_code"),
	inverseJoinColumns = @JoinColumn(name="ncm_code" , referencedColumnName = "ncm_code"))
	protected Ncm ncm;
	
	public Cest() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public CestTree getCestTree() {
		return cestTree;
	}

	public void setCestTree(CestTree cestTree) {
		this.cestTree = cestTree;
	}

	public Ncm getNcm() {
		return ncm;
	}

	public void setNcm(Ncm ncm) {
		this.ncm = ncm;
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
		if (!(obj instanceof Cest))
			return false;
		Cest other = (Cest) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cest [ description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
