package br.com.connemat.sysmat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.connemat.EntityRepository;
import br.com.connemat.sysmat.model.entity.CustomField;

public interface CustomFieldRepository extends EntityRepository<CustomField, Long> {
	
	 @Query(value="from CustomField cf  inner join cf.customConfig cc where cc.id = :id")
	 List<CustomField> findCustomFieldByCustomConfigValueId(@Param(value="id") Long id);
	
}
