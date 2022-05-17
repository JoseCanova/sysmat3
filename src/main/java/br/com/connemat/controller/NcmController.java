package br.com.connemat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.Base;
import br.com.connemat.NcmBaseService;
import br.com.connemat.model.entity.Ncm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/ncms" , produces = MediaType.APPLICATION_JSON_VALUE)
public class NcmController extends EntityController<Ncm, String, NcmBaseService> {

	public NcmController(@Autowired NcmBaseService service) {
		super(service);
	}

	@Override
	public String getBaseUrl(Base<?> base) {
		return "/ncms/"+base.getId();
	}
	
	@GetMapping(path="/ncm_code/{id}")
	public ResponseEntity<  Ncm > findNcmByNcmCode(@PathVariable(name = "id" , required=true) String code) {
		return ResponseEntity.ok(service.findNcmByNcmCode(code).orElse(null));
	}
	
}