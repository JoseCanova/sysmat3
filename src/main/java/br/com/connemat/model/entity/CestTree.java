package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.CestTreeBase;
//TODO: refatorar pacote... sem necessidade desse pacote id
@Entity
@Table(name="cest_tree")
@Valid
public class CestTree extends CestTreeBase {

	private static final long serialVersionUID = -7588698553564557388L;
	
	@Id
	@NotNull(groups= {UpdateValidationGroup.class})
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cest_tree_id" , columnDefinition = "INT NOT NULL")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	
	
}
