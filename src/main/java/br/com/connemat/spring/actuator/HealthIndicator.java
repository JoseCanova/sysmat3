package br.com.connemat.spring.actuator;

import org.springframework.boot.actuate.health.Health;

//TODO:implementar heath indicator para aplicacao. definir critérios de estado da aplicação.
public interface HealthIndicator {

	Health health(); 
	
}
