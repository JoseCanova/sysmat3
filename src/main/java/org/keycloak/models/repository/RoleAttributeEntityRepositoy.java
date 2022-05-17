package org.keycloak.models.repository;

import org.keycloak.models.jpa.entities.RoleAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAttributeEntityRepositoy  extends JpaRepository<RoleAttributeEntity, String>{

}
