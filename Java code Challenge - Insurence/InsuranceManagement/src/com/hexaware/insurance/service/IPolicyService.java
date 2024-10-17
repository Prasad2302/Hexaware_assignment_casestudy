package com.hexaware.insurance.service;

import java.util.Collection;

import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.entity.User;
import com.hexaware.insurance.exception.PolicyNotFoundException;

public interface IPolicyService {

	boolean createPolicy(Policy policy);
	 
	 Policy getPolicy(long policyID) throws PolicyNotFoundException;
	 
	 Collection<Policy> getAllPolicies() throws PolicyNotFoundException;
	 
	 boolean updatePolicy(Policy policy) ;
	 
	 boolean deletePolicy(long policyDeleteID) throws PolicyNotFoundException;
	 
	 boolean createUser(User user);
	
}
