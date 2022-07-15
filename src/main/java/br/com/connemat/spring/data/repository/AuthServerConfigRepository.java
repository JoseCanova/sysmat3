package br.com.connemat.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connemat.model.entity.AuthServerConfig;

@Deprecated
public interface AuthServerConfigRepository extends JpaRepository<AuthServerConfig,Long>{
}
