package br.com.connemat.model.entity;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.CestTreeBase;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;
//TODO: refatorar pacote... sem necessidade desse pacote id
@Entity
@Table(name="cest_tree")
@Valid
public class CestTree extends CestTreeBase {

	private static final long serialVersionUID = -7588698553564557388L;
	
	@BaseConstraint(groups= {UpdateValidationGroup.class , CreateValidationGroup.class})
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using = JsonBaseSerializer.class)
	@JoinColumn(name = "cest_tree_parent_id")
	protected CestTree parent;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public CestTreeBase getParent() {
		return parent;
	}

	public void setParent(CestTree parent) {
		this.parent = parent;
	}
	
}
