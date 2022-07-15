package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import br.com.connemat.controller.InstanceController;
import br.com.connemat.controller.SectorController;
import br.com.connemat.model.entity.Instance;
import br.com.connemat.model.entity.InstanceDataSourceConfig;
import br.com.connemat.model.entity.Sector;
import br.com.connemat.rest.client.model.InstanceDataSourceRepresentation;
import br.com.connemat.service.config.SectorBaseServiceImpl;
import br.com.connemat.service.impl.InstanceBaseServiceImpl;

@SpringBootTest
public class TestSectorInstance {

	public static final String DESCRIPTION = "this is a short description";

	public static final String CODE = "1234567892";
	
	public static final String INSTANCE_DESCRIPTION = "this is a short instance description";

	public static final String INSTANCE_BINARY = "instance_binary_test";
	
	public static final String INSTANCE_DB_NAME = "INSTANCE_DB_NAME";
	
	public static final String INSTANCE_DB_DIALECT= "INSTANCE_DB_NAME";
	
	public static final String INSTANCE_DB_INSTANCE = "INSTANCE_DB_INSTANCE";

	public static final String INSTANCE_DB_USER = "INSTANCE_DB_USER";

	public static final String INSTANCE_DB_PASSWORD = "INSTANCE_DB_PASSWORD";
	
	public static final Integer INSTANCE_DB_PORT = 5432;


	@Autowired
	private SectorBaseServiceImpl sectorService;
	
	@Autowired
	private InstanceBaseServiceImpl instanceService;
	
	@Autowired
	private InstanceController instanceController;
	
	@Autowired
	private SectorController sectorController;
	
	
	@Test
	void assertResourcesNotNull() {
		assertNotNull(sectorService);
	}
	
	@Test
	void assertSectorSave() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		assertNotNull(sector);
		Sector theSector = sectorService.addEntity(sector);
		assertNotNull(theSector.getId());
		sectorService.delete(theSector);
	}
	
	@Test
	void assertFindSector() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		assertNotNull(sector);
		Sector theSector = sectorService.addEntity(sector);
		assertNotNull(theSector.getId());
		Optional<Sector> theSector2Opt = sectorService.findOne(Example.of(sector));
		assertTrue(theSector2Opt.isPresent());
		sectorService.delete(theSector);
	}
	
	@Test
	void assertCreateSectorInstance() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		assertNotNull(sector);
		Instance instance = new Instance();
		instance.setCode(CODE);
		instance.setDescription(INSTANCE_DESCRIPTION);
		instance.setLogo(INSTANCE_BINARY);
		instance.setLogoSmall(INSTANCE_BINARY);
		instance.setManual(INSTANCE_BINARY);
		sector.getInstances().add(instance);
		Sector theSector = sectorService.addEntity(sector);
		Optional<Sector> theSector2Opt = sectorService.findOne(Example.of(sector));
		assertTrue(theSector2Opt.isPresent());
		sectorService.delete(theSector);
	}
	
	@Test
	void assertCreateUpdateInstance() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		Sector theSector = sectorService.addEntity(sector);
		Instance instance = new Instance();
		instance.setCode(CODE);
		instance.setDescription(INSTANCE_DESCRIPTION);
		instance.setLogo(INSTANCE_BINARY);
		instance.setLogoSmall(INSTANCE_BINARY);
		instance.setManual(INSTANCE_BINARY);
		instance.setSector(theSector);
		Instance theInstance = instanceService.save(instance);
		assertNotNull (theInstance);
		assertNotNull (theInstance.getId());
		LocalDateTime ldt = LocalDateTime.now();
		theInstance.setDeactivationTime(ldt);
		theInstance.setActivationTime(ldt);
		Instance theInstanceUpdate = instanceService.updateInstance(theInstance.getId() , theInstance);
		assertNotNull (theInstanceUpdate);
		assertNotNull (theInstanceUpdate.getId());
		assertNotNull (theInstanceUpdate.getDeactivationTime());
		assertNotNull (theInstanceUpdate.getActivationTime());
		instanceService.delete(theInstance);
		sectorService.delete(theSector);
	}
	
	@Test
	void assertCreateUpdateInstanceDataSourceConfig() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		Sector theSector = sectorService.addEntity(sector);
		Instance instance = new Instance();
		instance.setCode(CODE);
		instance.setDescription(INSTANCE_DESCRIPTION);
		instance.setLogo(INSTANCE_BINARY);
		instance.setLogoSmall(INSTANCE_BINARY);
		instance.setManual(INSTANCE_BINARY);
		instance.setSector(theSector);
		Instance theInstance = instanceService.addInstance(instance);
		assertNotNull (theInstance);
		assertNotNull (theInstance.getId());
		LocalDateTime ldt = LocalDateTime.now();
		theInstance.setDeactivationTime(ldt);
		theInstance.setActivationTime(ldt);
		theInstance.setSector(theSector);
		Instance theInstanceUpdate = instanceService.updateInstance(theInstance.getId() , theInstance);
		
		InstanceDataSourceConfig ids = new InstanceDataSourceConfig();
		
		ids.setHost(INSTANCE_DB_NAME);
		ids.setDbName(INSTANCE_DB_NAME);
		ids.setDbDialect(INSTANCE_DB_DIALECT);
		ids.setDbUser(INSTANCE_DB_USER);
		ids.setDbPassword(INSTANCE_DB_PASSWORD);
		ids.setDbPort(INSTANCE_DB_PORT);
		ids.setDbInstance(INSTANCE_DB_INSTANCE);
		ids.setInstance(theInstanceUpdate);
		
		theInstanceUpdate.setInstanceConfigDataSource(ids);
		
		theInstanceUpdate.setSector(theSector);
		Instance theInstanceUpdateIds =  instanceService.updateInstance(theInstanceUpdate.getId() , theInstanceUpdate);
		
		assertNotNull (theInstanceUpdateIds);
		assertNotNull (theInstanceUpdateIds.getId());
		assertNotNull (theInstanceUpdateIds.getDeactivationTime());
		assertNotNull (theInstanceUpdateIds.getActivationTime());
		assertNotNull (theInstanceUpdateIds.getInstanceConfigDataSource());
		
		instanceService.delete(theInstanceUpdateIds);
		sectorService.delete(theSector);
	}
	
	@Test
	void assertSectorControllerNotNull() {
		assertNotNull(sectorController);
	}
	
	@Test
	void assertControllerAddInstanceDataSourceConfig() {
		addInstanceSector();
		Instance instanceToUpdate = new Instance();
		instanceToUpdate.setCode(CODE);
		Example<Instance> ex = Example.of(instanceToUpdate);
		Optional<Instance> instanceOpt = instanceService.findOne(ex);
		assertTrue(instanceOpt.isPresent());
		
		InstanceDataSourceConfig ids = new InstanceDataSourceConfig();
		ids.setHost(INSTANCE_DB_NAME);
		ids.setDbName(INSTANCE_DB_NAME);
		ids.setDbDialect(INSTANCE_DB_DIALECT);
		ids.setDbUser(INSTANCE_DB_USER);
		ids.setDbPassword(INSTANCE_DB_PASSWORD);
		ids.setDbPort(INSTANCE_DB_PORT);
		ids.setDbInstance(INSTANCE_DB_INSTANCE);
		
		InstanceDataSourceRepresentation  idsr = new InstanceDataSourceRepresentation();
		
		idsr.setInstance(instanceOpt.get());
		idsr.setInstanceDataSourceConfig(ids);
		//TODO:Refatorar o metodo de criação de datasource config.
//		instanceController.addInstanceDataSourceConfig(idsr);
		
		deleteSector();
	}
	
	//do not use as a unity test
	void addInstanceSector() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		Sector theSector = sectorService.addEntity(sector);
		Instance instance = new Instance();
		instance.setCode(CODE);
		instance.setDescription(INSTANCE_DESCRIPTION);
		instance.setLogo(INSTANCE_BINARY);
		instance.setLogoSmall(INSTANCE_BINARY);
		instance.setManual(INSTANCE_BINARY);
		instance.setSector(theSector);
		Instance theInstance = instanceService.addInstance(instance);
		assertNotNull (theInstance);
		assertNotNull (theInstance.getId());
		LocalDateTime ldt = LocalDateTime.now();
		theInstance.setDeactivationTime(ldt);
		theInstance.setActivationTime(ldt);
		instanceService.updateInstance(theInstance.getId() , theInstance);
	}
	
	void deleteSector() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		Example<Sector> ex = Example.of(sector);
		Optional<Sector> sectorOpt = sectorService.findOne(ex);
		sectorOpt.ifPresent(s -> sectorService.delete(s));
	}
	
	@Test
	void testSectorInValid() {
		Sector sector = new Sector();
		assertThrows(ConstraintViolationException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
					sectorController.addEntity(sector);
			}});
	}
	
	@Test
	void testUpdateSectorInValid() {
		Sector sector = new Sector();
		sector.setDescription(DESCRIPTION);
		assertThrows(ConstraintViolationException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
					sectorController.updateEntity(sector.getId(),sector);
			}}
		);
	}
	
	@Test
	void testAddInstanceInvalid() {
		Instance instance = new Instance();
		assertThrows(ConstraintViolationException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
					instanceService.addInstance(instance);
			}}
		);
	}
}
