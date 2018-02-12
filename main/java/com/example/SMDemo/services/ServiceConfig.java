package com.example.SMDemo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

import com.example.SMDemo.statemachine.enums.Events;
import com.example.SMDemo.statemachine.enums.States;


public class ServiceConfig {


		@Bean
		public StateMachineService<States, Events> stateMachineService(StateMachineFactory<States, Events> stateMachineFactory,
				StateMachineRuntimePersister<States, Events, String> stateMachineRuntimePersister) {
			return new DefaultStateMachineService<States, Events>(stateMachineFactory, stateMachineRuntimePersister);
		}
}
