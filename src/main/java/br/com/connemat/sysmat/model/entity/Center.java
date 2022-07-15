package br.com.connemat.sysmat.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.sysmat.model.entity.validation.CenterDateValidationGroup;
import br.com.connemat.sysmat.model.entity.validation.DeactivationValidationGroup;
import br.com.connemat.util.JsonBaseSerializer;
import br.com.connemat.util.LocalDateTimeDeserializer;
import br.com.connemat.util.LocalDateTimeSerializer;

@Entity
@Table(name="center",
uniqueConstraints = {@UniqueConstraint(columnNames = {"code"} , name = "center_code_uk")})
@Valid

@JsonInclude(Include.NON_EMPTY)
public class Center implements Base<Long> {

	private static final long serialVersionUID = -1604347210949112511L;

	@Id
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="center_id" , columnDefinition = "INT NOT NULL")
	private Long id;

	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=10 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="code" , columnDefinition = "VARCHAR(10) NOT NULL" , unique = true)
	private String code;

	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=40 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="description" , columnDefinition = "VARCHAR(40) NOT NULL")
	private String description;

	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class , DeactivationValidationGroup.class})
	@Column(name="disabled" , columnDefinition = "BOOLEAN NOT NULL")
	@AssertFalse(groups = {DeactivationValidationGroup.class})
	private Boolean disabled;

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@PastOrPresent(groups = {CenterDateValidationGroup.class})
	@Column(name="created_date" , columnDefinition = "TIMESTAMP NOT NULL" ,
	nullable = false , insertable = true , updatable = false)
	private LocalDateTime createdDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@PastOrPresent(groups = {DeactivationValidationGroup.class})
	@Column(name="last_updated_date" , columnDefinition = "TIMESTAMP NOT NULL",
	nullable = false , insertable = true , updatable = true)
	private LocalDateTime lastUpdatedDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
	@PastOrPresent(groups = {DeactivationValidationGroup.class})
	@Column(name="inactivation_date" , columnDefinition = "TIMESTAMP",
	nullable = false , insertable = true , updatable = true)
	private LocalDateTime inactivationDate;

	@Size(max=250, groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="comments")
	private String comments;

	@BaseConstraint(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using=JsonBaseSerializer.class)
	@NotNull(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JoinColumn(name = "company_id" , columnDefinition = "INT NOT NULL")
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	private Company company;

	public Center() {
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	public LocalDateTime getInactivationDate() {
		return inactivationDate;
	}

	public void setInactivationDate(LocalDateTime inactivationDate) {
		this.inactivationDate = inactivationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdatedDate == null) ? 0 : lastUpdatedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Center))
			return false;
		Center other = (Center) obj;
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
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
		if (lastUpdatedDate == null) {
			if (other.lastUpdatedDate != null)
				return false;
		} else if (!lastUpdatedDate.equals(other.lastUpdatedDate))
			return false;
		return true;
	}

}
