package org.keycloak.models.repository;

import java.util.List;
import java.util.Optional;

import org.keycloak.models.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

	Optional<UserEntity> findByEmailAndRealmId(String Email , String realmId);
	
	Optional<UserEntity> findByUsernameAndRealmId(String username , String realmId);

	@Query(value = "from UserEntity ue where (ue.username = :id or ue.email = :id) and realmId = :realmId")
	Optional<UserEntity> findByUsernameOrEmailAndRealmId(@Param("id") String id , @Param("realmId") String realmId );

	@Query(value = "from UserEntity ue where realmId = :realmId")
	List<UserEntity> findAllByRealmId(@Param("realmId") String reamlId);
	
}
