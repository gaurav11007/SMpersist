/*package com.example.SMDemo.statemachine;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;

public class StateMachineController<S,E,T> {
	
	 StateMachineFactory<S, E > stateMachineFactory;

	 StateMachinePersister<S, E, T> persister;

	    
	    public StateMachine<S, E> restore(T contextObject) {
	        StateMachine<S, E> stateMachine = stateMachineFactory.getStateMachine();
	        try {
				return persister.restore(stateMachine, contextObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return  stateMachineFactory.getStateMachine();
			}
	    }
	    
	    
}
*/