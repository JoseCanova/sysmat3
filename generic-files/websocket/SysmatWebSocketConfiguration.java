package br.com.connemat.sysmat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.socket.server.upgrade.TomcatRequestUpgradeStrategy;

import br.com.connemat.ws.HelloWs;

@Configuration
public class SysmatWebSocketConfiguration  {

	@Configuration
	class WebConfig {

	    @Bean
	    public HandlerMapping handlerMapping() {
	        Map<String, WebSocketHandler> map = new HashMap<>();
	        map.put("/helloWs", new HelloWs());
	        int order = -1; // before annotated controllers

	        return new SimpleUrlHandlerMapping(map, order);
	    }
	}
	
    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public WebSocketService webSocketService() {
        TomcatRequestUpgradeStrategy strategy = new TomcatRequestUpgradeStrategy();
        strategy.setMaxSessionIdleTimeout(0L);
        return new HandshakeWebSocketService(strategy);
    }

}