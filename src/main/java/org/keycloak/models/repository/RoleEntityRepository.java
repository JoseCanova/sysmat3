package org.keycloak.models.repository;

import java.util.List;

import org.keycloak.models.jpa.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, String> {
	
	@Query(value = "select r from RoleEntity r inner join r.attributes ra where ra.name = 'sysmat-action'")
	List<RoleEntity> getSysmatActionRoles();
	
}
