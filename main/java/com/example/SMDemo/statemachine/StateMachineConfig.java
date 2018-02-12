package com.example.SMDemo.statemachine;

import com.example.SMDemo.statemachine.enums.Events;
import com.example.SMDemo.statemachine.enums.States;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

/**
 * Created by Gaurav Saraf on 06/02/18.
 */

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {
	
	
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
		        .withConfiguration()
		        .autoStartup(false)
		        .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.PENDINGDATAENTRY,action())
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.PENDINGDATAENTRY).target(States.DATAENTRYCOMPLETE).event(Events.CREATEPOLICY)
                .and()
                .withExternal()
                .source(States.DATAENTRYCOMPLETE).target(States.PENDINGAUTOUW).event(Events.SUBMITPOLICY).action(action());
              
    }
   
    @Bean
    public StateMachineListener<States, Events> listener() {

        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
            	System.out.println("In state chnaged");
                if (from == null) {
                    System.out.println("State machine initialised in state " + to.getId());
                } else {
                    System.out.println("State changed from " + from.getId() + " to " + to.getId());
                }
            }
        };
    }
    
    @Bean
    public Action<States, Events> action() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
            	System.out.println("In ACTION" + context.getExtendedState().getVariables().get("policyNumber"));
            }
        };
    }
    /*@Bean
	public StateMachineRuntimePersister<States, Events, String> stateMachineRuntimePersister() {
		return new JpaPersistingStateMachineInterceptor<>(jpaStateMachineRepository);
    }*/
    
    
    
    
    
}
