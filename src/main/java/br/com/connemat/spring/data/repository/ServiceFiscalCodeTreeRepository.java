package br.com.connemat.spring.data.repository;

import java.util.Optional;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.ServiceFiscalCodeTree;

public interface ServiceFiscalCodeTreeRepository extends EntityRepository<ServiceFiscalCodeTree, Long> {

	Optional<ServiceFiscalCodeTree> findServiceFiscalTreeByCode(String code);
	
}
