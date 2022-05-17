package br.com.connemat.sysmat;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

@Configuration
@EnableStateMachine
public class SysmatStateMachineConiguration 
				extends StateMachineConfigurerAdapter<SysmatStates, Events> {

	@Override
	public void configure(StateMachineStateConfigurer<SysmatStates, Events> states)
			throws Exception {
		states
			.withStates()
				.initial(SysmatStates.S1)
				.end(SysmatStates.SF)
				.states(EnumSet.allOf(SysmatStates.class));
	}
	
}

enum SysmatStates{
	S1,
	SF;
}

enum Events{
}