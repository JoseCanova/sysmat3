package br.com.connemat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connemat.spring.data.repository.DataSourceConfigRepository;

@RestController
@RequestMapping (path = "/datasource")
public class DataSourceConfigController  {

	
	@Autowired
	public DataSourceConfigRepository repository;
	
	public DataSourceConfigController() {
	}
	
	@GetMapping
	public ResponseEntity<List<?>> getDataSources(){ 
		return ResponseEntity.of(Optional.of(repository.findAll()));
	}

}
