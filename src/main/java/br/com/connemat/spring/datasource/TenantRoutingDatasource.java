package br.com.connemat.spring.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TenantRoutingDatasource extends AbstractRoutingDataSource {

	public TenantRoutingDatasource() {
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return TenantContext.getCurrentTenant();
	}

}
