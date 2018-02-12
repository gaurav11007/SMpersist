package com.example.SMDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SMDemo.model.PolicyDO;
import com.example.SMDemo.repository.SMRepository;

import com.example.SMDemo.statemachine.enums.Events;
import com.example.SMDemo.statemachine.enums.States;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by Gaurav Saraf on 07/02/18.
 */


@RestController
@RequestMapping("/api")
public class PolicyController {
	
	   @Autowired
	   SMRepository smRepository;
	   

	    @Autowired
	    StateMachineFactory<States, Events> factory;
	   

		@Autowired
		private StateMachinePersist<States, Events, String> stateMachinePersist;

	   
	   private ObjectMapper mapper = new ObjectMapper();
	   
	    @PostMapping("/createPolicy")
	    public String createPolicy(@RequestBody String policyType) {
	    	try{
		       PolicyDO policyDO = new PolicyDO();
			   System.out.println("+++++++++++++++++++++++++++ Creating Policy");
			   policyDO.setType(policyType);
			   StateMachine<States,Events> stateMachine = factory.getStateMachine();
			   stateMachine.start();
			   // WORKFLOW INITIATE
			   System.out.println("stateMachine1:" + stateMachine.getState() + "=>"+ stateMachine.getId());
			   StateMachineContext<States, Events> stateMachineContext = stateMachinePersist.read(stateMachine.getId());
			   System.out.println("stateMachine1Context:" + stateMachineContext.toString());
			  if(policyType.equals("AUTO")) {
				  stateMachine.sendEvent(Events.CREATEPOLICY);
			  }else {
				  stateMachine.sendEvent(Events.SUBMITPOLICY);
			  }
			  
			  System.out.println("stateMachineContext:" + stateMachineContext.toString());
			   System.out.println("stateMachine:" + stateMachine.getState());
			 //  StateMachineContext<States, Events> stateMachineContext = stateMachinePersist.read(stateMachine.getId());
		   	   smRepository.save(policyDO);
		   	   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(policyDO);
	    	}
	    	catch(Exception e) {
	    		return e.getMessage();
	    	}
	    }
	    
	     
	    @PostMapping("/Submit")
	    public String submitPolicy(@PathVariable(value = "id") Long policyId) {
	    	try{
	    	   PolicyDO policyDO = smRepository.findOne(policyId);
	    	  // stateMachine.sendEvent(Events.SUBMITPOLICY); 
		   	   smRepository.save(policyDO);
		   	   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(policyDO);
	    	}
	    	catch(Exception e) {
	    		return e.getMessage();
	    	}
	    }
	    
	  
}
