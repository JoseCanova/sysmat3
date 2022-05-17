package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.Center;

public interface CenterRepository extends EntityRepository<Center, Long> {
	
	@Query(value="from Center ce where ce.company.id=:id")
	List<Center> findCenterByCompanyId(@Param(value="id") Long id);


}
