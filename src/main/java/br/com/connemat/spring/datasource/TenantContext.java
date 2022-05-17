package br.com.connemat.spring.datasource;

import java.util.Optional;

public class TenantContext {
	
    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();
    
    public static final String DEFAULT_TENANT_ID = "sysmat-default";
    
    public static String getCurrentTenant() {
        return Optional.ofNullable(currentTenant.get()).orElse(DEFAULT_TENANT_ID);
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
    
}
