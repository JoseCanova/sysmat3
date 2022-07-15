package org.keycloak.models.repository;

import java.util.List;

import org.keycloak.models.jpa.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResourceEntityRepository extends JpaRepository<ResourceEntity, String> {
	
	@Override
	@Query(value = "from ResourceEntity re join fetch re.uris join fetch re.policies")
	List<ResourceEntity> findAll();
}
