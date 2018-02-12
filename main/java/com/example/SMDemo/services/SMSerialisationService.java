package com.example.SMDemo.services;

import org.springframework.statemachine.kryo.KryoStateMachineSerialisationService;
import com.example.SMDemo.statemachine.enums.Events;
import com.example.SMDemo.statemachine.enums.States;

public class SMSerialisationService extends KryoStateMachineSerialisationService<States,Events> {

	

}
