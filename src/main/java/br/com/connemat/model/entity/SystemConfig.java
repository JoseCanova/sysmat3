package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Valid
@Entity
@Table(name="system_config")
public class SystemConfig implements Base<Long> {

	private static final long serialVersionUID = -6251501373669595620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="system_config_id")
	@NotNull(groups = {UpdateValidationGroup.class})
	@Null(groups=CreateValidationGroup.class)
	private Long id; 
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=20 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_config")
	private String keyConfig;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_value")
	private String keyValue;
	
	@NotEmpty(groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Size(max=50 , groups = {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="key_description")
	private String keyDescription;
	
	@ManyToOne
	@JoinColumn(name="app_id")
	private App app;

	public SystemConfig() {
		super();
	}

	public SystemConfig(@NotNull Long id) {
		this.id = id;
	}

	public SystemConfig(String keyConfig, String keyValue, String keyDescription) {
		super();
		this.keyConfig = keyConfig;
		this.keyValue = keyValue;
		this.keyDescription = keyDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getKeyConfig() {
		return keyConfig;
	}


	public void setKeyConfig(String keyConfig) {
		this.keyConfig = keyConfig;
	}


	public String getKeyValue() {
		return keyValue;
	}


	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}


	public String getKeyDescription() {
		return keyDescription;
	}


	public void setKeyDescription(String keyDescription) {
		this.keyDescription = keyDescription;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
	@Override
	public String toString() {
		return "SystemConfig [id=" + id + ", keyConfig=" + keyConfig + ", keyValue=" + keyValue + ", keyDescription="
				+ keyDescription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyConfig == null) ? 0 : keyConfig.hashCode());
		result = prime * result + ((keyDescription == null) ? 0 : keyDescription.hashCode());
		result = prime * result + ((keyValue == null) ? 0 : keyValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SystemConfig))
			return false;
		SystemConfig other = (SystemConfig) obj;
		if (keyConfig == null) {
			if (other.keyConfig != null)
				return false;
		} else if (!keyConfig.equals(other.keyConfig))
			return false;
		if (keyDescription == null) {
			if (other.keyDescription != null)
				return false;
		} else if (!keyDescription.equals(other.keyDescription))
			return false;
		if (keyValue == null) {
			if (other.keyValue != null)
				return false;
		} else if (!keyValue.equals(other.keyValue))
			return false;
		return true;
	}
	
}
