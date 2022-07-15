package br.com.connemat;

import br.com.connemat.model.entity.DataSourceConfig;

public interface DataSourceConfigBaseService extends BaseService<DataSourceConfig,Long> {
	DataSourceConfig findByName(String name);
}
