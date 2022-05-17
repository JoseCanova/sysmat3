package br.com.connemat.sysmat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="pdm_history")
@Valid
public class PdmHistory implements Base<Long> {

	private static final long serialVersionUID = 6467935588859075548L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pdm_history_id")
	private Long id;
	
	@NotNull
	@JsonSerialize(using=JsonBaseSerializer.class)
	@JoinColumn(name="pdm_id")
	private Pdm pdm;
	
	public PdmHistory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
