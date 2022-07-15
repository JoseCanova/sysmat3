package br.com.connemat.sysmat.controller.config.representation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.Sector;

@Valid
public class SectorInstanceRepresentation {

	@NotNull
	private Sector sector; 
	
	@NotNull
	private Instance instance;

	public SectorInstanceRepresentation() {
		super();
	}
	
	public SectorInstanceRepresentation(Sector sector, Instance instance) {
		super();
		this.sector = sector;
		this.instance = instance;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	} 
	
}
