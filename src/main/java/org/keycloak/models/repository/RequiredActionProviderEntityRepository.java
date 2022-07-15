package org.keycloak.models.repository;

import java.util.List;

import org.keycloak.models.jpa.entities.RequiredActionProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequiredActionProviderEntityRepository 
extends JpaRepository<RequiredActionProviderEntity, String> {
	
	
	@Query(value = "from RequiredActionProviderEntity e inner join e.realm re where re.id = :realmId")
	List<RequiredActionProviderEntity> getRealmRequiredActions(@Param(value = "realmId") String realmId);
}