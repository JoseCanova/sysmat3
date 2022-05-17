package org.keycloak.models.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.keycloak.models.jpa.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, String> {

	List<ClientEntity> findByRealmId(@NotEmpty String realmId);

	Optional<ClientEntity> findByClientIdAndRealmId(@NotEmpty  String id, @NotEmpty  String realm);
	
}
