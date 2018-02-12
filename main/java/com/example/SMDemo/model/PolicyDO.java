package com.example.SMDemo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Gaurav Saraf on 07/02/18.
 */

@Entity
@Table(name = "POLICY")
public class PolicyDO {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private String type;
	 private String policyStatus;
     private String policyStageCd;
     private String currentTaskCd;
     private Byte[] stateMachine;
     
     
    public Byte[] getStateMachine() {
		return stateMachine;
	}
	public void setStateMachine(Byte[] stateMachine) {
		this.stateMachine = stateMachine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrentTaskCd() {
		return currentTaskCd;
	}
	public void setCurrentTaskCd(String currentTaskCd) {
		this.currentTaskCd = currentTaskCd;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPolicyStageCd() {
		return policyStageCd;
	}
	public void setPolicyStageCd(String policyStageCd) {
		this.policyStageCd = policyStageCd;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"policyStatus\":" + policyStatus + ", \"policyStageCd:" + policyStageCd + ", \"policyStageCd\":" + policyStageCd +"}";
	}
}
