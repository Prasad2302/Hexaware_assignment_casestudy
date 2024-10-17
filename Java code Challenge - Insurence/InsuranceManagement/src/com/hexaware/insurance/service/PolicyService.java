package com.hexaware.insurance.service;

import java.util.Collection;

import com.hexaware.insurance.dao.IPolicyResources;
import com.hexaware.insurance.dao.PolicyResourcesImpl;
import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.entity.User;
import com.hexaware.insurance.exception.PolicyNotFoundException;

public class PolicyService implements IPolicyService{

	private IPolicyResources dao;
	
	public PolicyService() {
        this.dao = new PolicyResourcesImpl(); 
    }
	
	
	@Override
	public boolean createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return dao.createPolicy(policy);
	}

	@Override
	public Policy getPolicy(long policyID) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return dao.getPolicy(policyID);
	}

	@Override
	public Collection<Policy> getAllPolicies() throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return dao.getAllPolicies();
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		// TODO Auto-generated method stub
		return dao.updatePolicy(policy);
	}

	@Override
	public boolean deletePolicy(long policyID) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return dao.deletePolicy(policyID);
	}


	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return dao.createUser(user);
	}

	
	
	
}
