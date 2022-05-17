package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.Company;

public interface CompanyRepository extends EntityRepository<Company, Long> {
	
	@Query(value = "from Center ce inner join ce.company co where co = :company")
	List<?> findCentersByCompany(@Param(value="company") Company company);
	
}
