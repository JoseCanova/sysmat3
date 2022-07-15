package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;

@Entity
@Table(name="app")
@Valid
public class App implements Base<String>{

	private static final long serialVersionUID = -799991423792541279L;

	@Id
	@Size(max=4, groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@Column(name="app_id")
	private String id;
	
	@Size(max=50 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	private String description;
	
	@Size(max=10 , groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	@NotEmpty(groups= {UpdateValidationGroup.class , CreateValidationGroup.class })
	private String version;
	
	public App() {
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof App))
			return false;
		App other = (App) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", description=" + description + ", version=" + version + "]";
	}
	
}
