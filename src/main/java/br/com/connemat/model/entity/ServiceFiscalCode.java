package br.com.connemat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocalDateDeserializer;
import br.com.connemat.util.LocalDateSerializer;

@Entity
@Table(name = "service_fiscal_code")
public class ServiceFiscalCode implements Base<String> {

	private static final long serialVersionUID = -2239374711881358545L;

	@Id
	@Size(min = 4, max = 4, groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@NotEmpty(groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@Column(name = "service_fiscal_code", columnDefinition = "VARCHAR(4) NOT NULL")
	private String id;

	@Size(max = 1200, groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@NotEmpty(groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@Column(name = "description", columnDefinition = "VARCHAR(1200) NOT NULL")
	private String description;

	@NotNull(groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@PastOrPresent(groups = { UpdateValidationGroup.class, CreateValidationGroup.class })
	@Column(name = "start_date", columnDefinition = "DATE NOT NULL", nullable = false, insertable = true, updatable = true)
	private LocalDate startDate;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@PastOrPresent(groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@Column(name = "end_date", columnDefinition = "DATE", nullable = true, insertable = true, updatable = true)
	private LocalDate endDate;

	@BaseConstraint(groups = { CreateValidationGroup.class, UpdateValidationGroup.class })
	@JsonSerialize(using = JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_fiscal_code_tree_parent_id")
	private ServiceFiscalCodeTree serviceFiscalCodeTree;

	public ServiceFiscalCode() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ServiceFiscalCodeTree getServiceFiscalCodeTree() {
		return serviceFiscalCodeTree;
	}

	public void setServiceFiscalCodeTree(ServiceFiscalCodeTree serviceFiscalCodeTree) {
		this.serviceFiscalCodeTree = serviceFiscalCodeTree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ServiceFiscalCode))
			return false;
		ServiceFiscalCode other = (ServiceFiscalCode) obj;
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

	@Override
	public String toString() {
		return "ServiceFiscalCode [id=" + id + ", description=" + description + "]";
	}
	
	

}
