package org.keycloak.models.repository;

import org.keycloak.models.jpa.entities.RealmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmEntityRepository extends JpaRepository<RealmEntity, String> {
}
