package br.com.connemat.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Valid
public class UserRequiredAction {

	@NotEmpty
	private String id;

	@NotEmpty
	private String alias;

	@NotEmpty
	private String name;

	@NotNull
	private Boolean enabled;

	@NotNull
	private Boolean defaultAction;

	@NotNull
	private Integer priority;

	public UserRequiredAction() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getDefaultAction() {
		return defaultAction;
	}

	public void setDefaultAction(Boolean defaultAction) {
		this.defaultAction = defaultAction;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
