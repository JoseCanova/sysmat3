package br.com.connemat.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HelloWs implements WebSocketHandler {

	
	public String handle() {
		return "hello";
	}
	
    @Override
    public Mono<Void> handle(WebSocketSession session) {

        Flux<WebSocketMessage> output = session.receive()               
                .doOnNext(message -> {
                    // ...
                })
                .concat(message -> {
                    // ...
                })
                .map(value -> session.textMessage("Echo " + value));    

        return session.send(output);                                    
    }
}