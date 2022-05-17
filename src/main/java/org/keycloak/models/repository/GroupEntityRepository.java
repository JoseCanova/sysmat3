package org.keycloak.models.repository;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEntityRepository extends JpaRepository<GroupEntity, String> {

	List<GroupEntity> findByAttributesName(@NotEmpty String attributeName);

	List<GroupEntity> findByRealm(@NotEmpty String realmName);
	
	List<GroupEntity> findByAttributesNameAndRealm(@NotEmpty String attributeName , @NotEmpty String realm);
	
	List<GroupEntity> findByIdIn(List<String> ids);
	
	@Query("from GroupEntity ge join fetch ge.attributes atts where ge.id in :ids and atts.name = :attributeName")
	List<GroupEntity> findByIdInAndAttributesName(@Param(value = "ids") List<String> ids , @Param (value="attributeName") String attributeName);
	
}
