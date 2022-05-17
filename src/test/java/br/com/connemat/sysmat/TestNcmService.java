package br.com.connemat.sysmat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.connemat.NcmBaseService;
import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.Ncm;
import br.com.connemat.model.entity.NcmTree;
import br.com.connemat.sysmat.exception.SysmatEntityException;

@SpringBootTest
public class TestNcmService {

	@Autowired
	private NcmBaseService ncmService; 
	
	@Autowired
	private NcmTreeBaseService ncmTreeService;
	
	public TestNcmService() {
	}

	void testInjection() {
		assertNotNull(ncmService);
		assertNotNull(ncmTreeService);
	}
	
	@Disabled
	@Test
	void testCreateNcmTreeParent() {
		NcmTree parent = parentNcmTree();
		NcmTree t = ncmTreeService.addEntity(parent);
		assertNotNull(t.getId());
		ncmTreeService.deleteEntity(t.getId());
		assertThrows(SysmatEntityException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
				ncmTreeService.findByEntityId(t.getId());
			}
		});
	}
	
	@Disabled
	@Test
	void testCreateNcmTreeHierarchy() {
		NcmTree parent = parentNcmTree();
		NcmTree t = ncmTreeService.addEntity(parent);
		assertNotNull(t.getId());
		NcmTree child = childNcmTree(t);
		NcmTree child1 = ncmTreeService.addEntity(child);
		assertNotNull(child1.getId());
		ncmTreeService.deleteEntity(child1.getId());
		ncmTreeService.deleteEntity(t.getId());

		assertThrows(SysmatEntityException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
				ncmTreeService.findByEntityId(child1.getId());
			}
		});

		assertThrows(SysmatEntityException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
				ncmTreeService.findByEntityId(t.getId());
			}
		});
	}
	
	
	
	@Disabled
	@Test
	void testCreateNcmInvalidTreeHierarchy() {
		NcmTree parent = parentNcmTree();
		NcmTree t = ncmTreeService.addEntity(parent);
		assertNotNull(t.getId());
		NcmTree child = childInvalidNcmTree(t);
		assertThrows(ConstraintViolationException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
				NcmTree child1 = ncmTreeService.addEntity(child);
			}
		});
		
		ncmTreeService.deleteEntity(t.getId());

		assertThrows(SysmatEntityException.class , new Executable() {
			@Override
			public void execute() throws Throwable {
				ncmTreeService.findByEntityId(t.getId());
			}
		});
	}
	
	@Test
	void testCreateNcmEntity() {
		//create phase
		NcmTree ncmTree = parentNcmTree();
		NcmTree parent = ncmTreeService.addEntity(ncmTree);
		assertNotNull(parent.getId());
		NcmTree child = childNcmTree(parent);
		NcmTree child1 = ncmTreeService.addEntity(child);
		assertNotNull(child1.getId());

		Ncm ncm = createNcm(child1);
		
		Ncm theNcm = ncmService.addNcm(ncm);
		assertNotNull(theNcm.getId());
		
		//removal phase.
		ncmService.deleteNcm(theNcm.getId());
		ncmTreeService.deleteEntity(child1.getId());
		ncmTreeService.deleteEntity(parent.getId());

		assertThrows(SysmatEntityException.class , () -> ncmService.findByNcmId(ncm.getId()));
		
		assertThrows(SysmatEntityException.class , () -> ncmTreeService.findByEntityId(child1.getId()));

		assertThrows(SysmatEntityException.class , () -> ncmTreeService.findByEntityId(parent.getId()));
		
	}

	private Ncm createNcm(NcmTree child1) {
		Ncm ncm = new Ncm();
		ncm.setDescription("ncm description");
		ncm.setStartDate(LocalDate.now());
		ncm.setNcmCode("01010501");
		ncm.setNcmTree(child1);
		return ncm;
	}

	private NcmTree childInvalidNcmTree(NcmTree t) {
		NcmTree n = new NcmTree();
		n.setCode("0201");
		n.setDescription(" parent description ");
		n.setParent(t);
		return n;
	}

	private NcmTree parentNcmTree() {
		NcmTree n = new NcmTree();
		n.setCode("01");
		n.setDescription(" parent description ");
		return n;
	}
	
	private NcmTree childNcmTree(NcmTree parent) {
		NcmTree n = new NcmTree();
		n.setCode("0101");
		n.setDescription(" parent description ");
		n.setParent(parent);
		return n;
	}
}
