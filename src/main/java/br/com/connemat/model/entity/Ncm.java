package br.com.connemat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.LocalDateDeserializer;
import br.com.connemat.util.LocalDateSerializer;
import br.com.connemat.util.NcmTreeSerializer;


@Valid
@Entity
@Table(name="ncm")
public class Ncm implements Base<String>{

	private static final long serialVersionUID = -6808212665971892191L;

	@Id
	@Column(name="ncm_code")
	@NotEmpty(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Size(min=8 , max=8 , groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	private String ncmCode; 
	
	@NotEmpty(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Size(max=1200 , groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="description")
	private String description;
	
	@NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@PastOrPresent(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="start_date")
	private LocalDate startDate; 
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@PastOrPresent(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@Column(name="end_date")
	private LocalDate endDate;

	@BaseConstraint(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@JsonSerialize(using = NcmTreeSerializer.class)
	@NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	@ManyToOne
	private NcmTree ncmTree;
	
	public Ncm() {
	}

	@Override
	public String getId() {
		return ncmCode;
	}

	public String getNcmCode() {
		return ncmCode;
	}

	public void setNcmCode(String ncmCode) {
		this.ncmCode = ncmCode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ncmCode == null) ? 0 : ncmCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ncm))
			return false;
		Ncm other = (Ncm) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ncmCode == null) {
			if (other.ncmCode != null)
				return false;
		} else if (!ncmCode.equals(other.ncmCode))
			return false;
		return true;
	}

	public NcmTree getNcmTree() {
		return ncmTree;
	}

	public void setNcmTree(NcmTree ncmTree) {
		this.ncmTree = ncmTree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ncm [ncmCode=" + ncmCode + ", description=" + description + ", startDate=" + startDate + ", endDate="
				+ endDate + ", ncmTree=" + ncmTree + "]";
	}
}
