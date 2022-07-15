package br.com.connemat.spring.data.repository;

import br.com.connemat.EntityRepository;
import br.com.connemat.model.entity.DataSourceConfig;


public interface DataSourceConfigRepository extends EntityRepository<DataSourceConfig, Long> {
    DataSourceConfig findByName(String name);
}
