package br.com.connemat.rest.client;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties
public class AdminRestClientConfiguration {

	public AdminRestClientConfiguration() {
	}
	
	@Bean
	@Qualifier(value="restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) { 
		return builder.build();
	}
	
	@Bean
	@Qualifier(value="adminRestTemplate")
	public RestTemplate adminRestTemplate(RestTemplateBuilder builder 
				, @Autowired  @Qualifier("httpTokenInterceptor") ClientHttpRequestInterceptor clientHttpInterceptor) { 
		return builder.additionalInterceptors(clientHttpInterceptor).build();
	}
	
	
	//TODO: verificar no erro 401 do admin token um atributo para revalidar o adminToken.
	@Bean
	@Qualifier(value="httpTokenInterceptor")
	public ClientHttpRequestInterceptor baseTokenInterceptor(@Autowired AdminRestClient adminRestClient) { 
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				HttpHeaders headers = request.getHeaders();
				if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
					if (!Optional.ofNullable(adminRestClient.getAccessToken()).isPresent())
						adminRestClient.exchangeAdminToken();
					headers.setBearerAuth(adminRestClient.getAccessToken());
				}
				return execution.execute(request, body);
			}
		};
	}
	
	@Bean
	@ConfigurationProperties(prefix = "sysmat-realm-admin")
	public AdminRestClient adminRestClient() { 
		return new AdminRestClient();
	}

}
