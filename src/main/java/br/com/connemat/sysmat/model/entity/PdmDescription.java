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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="pdm_description")
@Valid
public class PdmDescription implements Base<Long> {


	private static final long serialVersionUID = -4099895267773559919L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pdm_description_id")
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id;
	
	@Size(max=10 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="locale")
	private String locale;
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="pdm_name")
	private String pdmName; 
	
	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="short_abbreviation")
	private String shortAbbbreviation;

	@Size(max=30 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="long_abbreviation")
	private String longAbbbreviation;
	
	@JoinColumn(name="pdm_id")
	@NotNull(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@JsonSerialize(using = JsonBaseSerializer.class)
	@ManyToOne(fetch = FetchType.EAGER)
	private Pdm pdm;
	
	public PdmDescription() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getPdmName() {
		return pdmName;
	}

	public void setPdmName(String pdmName) {
		this.pdmName = pdmName;
	}

	public Pdm getPdm() {
		return pdm;
	}

	public void setPdm(Pdm pdm) {
		this.pdm = pdm;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortAbbbreviation() {
		return shortAbbbreviation;
	}

	public void setShortAbbbreviation(String shortAbbbreviation) {
		this.shortAbbbreviation = shortAbbbreviation;
	}

	public String getLongAbbbreviation() {
		return longAbbbreviation;
	}

	public void setLongAbbbreviation(String longAbbbreviation) {
		this.longAbbbreviation = longAbbbreviation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((longAbbbreviation == null) ? 0 : longAbbbreviation.hashCode());
		result = prime * result + ((pdm == null) ? 0 : pdm.hashCode());
		result = prime * result + ((pdmName == null) ? 0 : pdmName.hashCode());
		result = prime * result + ((shortAbbbreviation == null) ? 0 : shortAbbbreviation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PdmDescription))
			return false;
		PdmDescription other = (PdmDescription) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (longAbbbreviation == null) {
			if (other.longAbbbreviation != null)
				return false;
		} else if (!longAbbbreviation.equals(other.longAbbbreviation))
			return false;
		if (pdm == null) {
			if (other.pdm != null)
				return false;
		} else if (!pdm.equals(other.pdm))
			return false;
		if (pdmName == null) {
			if (other.pdmName != null)
				return false;
		} else if (!pdmName.equals(other.pdmName))
			return false;
		if (shortAbbbreviation == null) {
			if (other.shortAbbbreviation != null)
				return false;
		} else if (!shortAbbbreviation.equals(other.shortAbbbreviation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PdmDescription [id=" + id + ", locale=" + locale + ", pdmName=" + pdmName + ", shortAbbbreviation="
				+ shortAbbbreviation + ", longAbbbreviation=" + longAbbbreviation + "]";
	}

	
	
}
