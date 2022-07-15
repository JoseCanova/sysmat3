package br.com.connemat.spring.data.repository;

import java.util.Optional;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.Ncm;

public interface NcmRepository extends EntityRepository<Ncm, String> {
	Optional<Ncm> findNcmByNcmCode(String code);
}
