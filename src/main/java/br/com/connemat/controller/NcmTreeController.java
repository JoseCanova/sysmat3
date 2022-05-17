package br.com.connemat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.connemat.NcmTreeBaseService;
import br.com.connemat.model.entity.NcmTree;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/ncm-trees" , produces = MediaType.APPLICATION_JSON_VALUE)
public class NcmTreeController extends EntityController<NcmTree , Long, NcmTreeBaseService>{

	public NcmTreeController(@Autowired NcmTreeBaseService service) {
		super(service);
	}


	@GetMapping(path="/parent/{id}")
	public  ResponseEntity< List<NcmTree> > findNcmsByParentId(@PathVariable(name="id") Long parentId){
		return ResponseEntity.ok( service.findNcmsByParentId(parentId));
	}
	
	@GetMapping(path="/code/{id}")
	public  ResponseEntity<NcmTree > findNcmsByCode(@PathVariable(name="id") String code){
		return ResponseEntity.ok( service.findNcmTreeByCode(code).orElse(null));
	}
	
	@PostMapping(path="/upload-file")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		Optional
			.ofNullable(file.getOriginalFilename())
			.ifPresent(s -> {
				System.out.println(s);
			});
		return ResponseEntity.ok(true);
	}
}
