package com.hexaware.insurance.dao;

import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.entity.User;
import com.hexaware.insurance.exception.PolicyNotFoundException;

import java.util.Collection;


public interface IPolicyResources {

	 boolean createPolicy(Policy policy);
	 
	 Policy getPolicy(long policy) throws PolicyNotFoundException;
	 
	 Collection<Policy> getAllPolicies() throws PolicyNotFoundException;
	 
	 boolean updatePolicy(Policy policy) ;
	 
	 boolean deletePolicy(long policyID) throws PolicyNotFoundException;
	 
	 boolean createUser(User user);
	
	
}
