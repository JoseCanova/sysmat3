package br.com.connemat.service.datasource;

import br.com.connemat.model.entity.InstanceDataSourceConfig;

public abstract class DataSourceConfigConverter {
	
	public DataSourceConfigConverter() {
	}

	public static BaseDataSourceConfiguration processConfig(InstanceDataSourceConfig config) {
		String prefix = "jdbc:postgresql://";
		StringBuffer sb = new StringBuffer();
		sb.append(prefix).append(config.getHost()).append(":").append(config.getDbPort()).append("/").append(config.getDbName()).append("?schema=").append(config.getDbInstance());
		return  new BaseDataSourceConfiguration(sb.toString() , config.getDbUser() , config.getDbPassword());
	}

}
