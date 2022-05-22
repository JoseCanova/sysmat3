package br.com.connemat.sysmat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.PollerSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import br.com.connemat.rest.client.AdminRestClient;

@Configuration
@EnableIntegration
@EnableConfigurationProperties
@Profile(value = "keycloak")
public class SysmatIntegrationConfiguration {

	@Autowired
	ApplicationContext applicationContext;
	
	public SysmatIntegrationConfiguration() {
	}
	
	@Bean
	@Qualifier(value="jobMessageTemplate")
	public MessagingTemplate messagingTemplate() { 
		MessagingTemplate messagingTemplate = new MessagingTemplate();
		messagingTemplate.setBeanFactory(applicationContext);
		return  messagingTemplate;
	}

	@Primary
	@Bean("httpMessageConverters")
	public List<HttpMessageConverter<?>> httpMessageConverters(){ 
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		return converters;
	}

	@Bean(name="defaultHttpHeaderMapper")
	@Qualifier(value="defaultHttpHeaderMapper")
	public DefaultHttpHeaderMapper defaultHeaderMapper() { 
		DefaultHttpHeaderMapper mapper = new DefaultHttpHeaderMapper();
		mapper.setInboundHeaderNames(new String[] {"*"});
		mapper.setOutboundHeaderNames(new String[] {"*"});
		return mapper;
	}

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerSpec poller() {
	    return Pollers.fixedRate(500)
	    		.errorChannel("loggingChannel");
	}
	
	 @Bean
	 public MessageChannel tokenChannel() {
	        return new DirectChannel();
	 }
	 
	@Bean
	@Qualifier(value="tokenPollerAdapter")
	public MessageSource<String>  tokenPollerAdapter() {
		return new MessageSource<String>() {
			@Override
			public Message<String> receive() {
				return MessageBuilder.withPayload("echo").build();
			}
		};
	}
	
	@Bean
	@Qualifier(value="tokenTaskScheduler")
	public TaskScheduler tokenTaskScheduler() {
		ThreadPoolTaskScheduler tp = new ThreadPoolTaskScheduler();
		tp.setPoolSize(100);
		return  tp;
	}
	
	@Bean
	@Qualifier("logginChannel")
	public DirectChannel loggingChannel() {
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier(value="tokenPollerChannel")
	public PollableChannel pollableChannel(@Autowired @Qualifier("tokenTaskScheduler") TaskScheduler taskScheduler) {
		QueueChannel queueChannel =  new QueueChannel();
		queueChannel.setTaskScheduler(taskScheduler);
		return queueChannel;
	}
	
	@Bean
	public IntegrationFlow loggingFlow(@Autowired 
			@Qualifier("loggingChannel") MessageChannel logChannel) {
		return  IntegrationFlows
				.from(logChannel)
				.handle(m -> logMessage(m))
				.get();
	}
	
	@Bean
	@Qualifier(value="requestTokenMessageChannel")
	public MessageChannel requestTokenMessageChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public IntegrationFlow pollingFlow(@Autowired 
			@Qualifier("tokenPollerChannel") MessageChannel channel , 	
			@Qualifier(value="requestTokenMessageChannel") MessageChannel requestTokenMessageChannel,
			@Qualifier("tokenPollerAdapter") MessageSource<String>  tokenPollerAdapter, 
			@Autowired @Qualifier("tokenOutboundChannelAdapter")  MessageHandler tokenOutboundChannelAdapter) {
		return  IntegrationFlows
				.from(tokenPollerAdapter  , c -> c.poller(Pollers.fixedRate(java.time.Duration.ofSeconds(10)).maxMessagesPerPoll(1)))
				.handle(tokenOutboundChannelAdapter)
				.get();
	}

	@Bean
	@Qualifier(value="tokenOutboundChannelAdapter") 
	public MessageHandler tokenOutboundChannelAdapter(@Autowired AdminRestClient adminRestClient) {
		return new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				adminRestClient.verifyTokenExpiration();
			}
		};
	}
	
	private Message<?> logMessage(Message<?> m) {
		System.err.println(m.getPayload());
		return m;
	}


}
