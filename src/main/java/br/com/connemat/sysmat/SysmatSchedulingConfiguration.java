package br.com.connemat.sysmat;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableConfigurationProperties
public class SysmatSchedulingConfiguration {

	public SysmatSchedulingConfiguration() {
	}

}
