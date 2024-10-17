package com.hexaware.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.entity.User;
import com.hexaware.insurance.exception.PolicyNotFoundException;

public class PolicyResourcesImpl implements IPolicyResources{
	
	private Connection conn;
	
	 public PolicyResourcesImpl()  {
		 conn = DBConnection.getDBConnection();

	    }

	@Override
	public boolean createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Policy (policyId, policyname, policyType) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setLong(1,policy.getPolicyID());
            preparedStatement.setString(2, policy.getPolicyName());
            preparedStatement.setString(3, policy.getPolicyType());
           

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
            return false;
        }

	}

	@Override
	public Policy getPolicy(long policyID)throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Policy WHERE policyId = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setLong(1, policyID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int policy_id = resultSet.getInt("policyId");
                String policyName = resultSet.getString("policyName");
                String policyType = resultSet.getString("policyType");
                
                Policy policy = new Policy(policy_id,policyName,policyType);
                return policy;
            }
            else{
                throw new PolicyNotFoundException("Policy with ID " + policyID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while retrieving policy with ID " + policyID);
        }
            
		}
            



	@Override
	public Collection<Policy> getAllPolicies() throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM Policy";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                int policy_id = resultSet.getInt("policyId");
                String policyName = resultSet.getString("policyName");
                String policyType = resultSet.getString("policyType");
                
                Policy policy = new Policy(policy_id,policyName,policyType);
                policies.add(policy);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while retrieving all policies");
        }
        return policies;
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		String query = "UPDATE Policy SET policyName = ?, policyType = ? WHERE policyId = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1, policy.getPolicyName());
            preparedStatement.setString(2, policy.getPolicyType());

            preparedStatement.setLong(3, policy.getPolicyID());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}

	@Override
	public boolean deletePolicy(long policyID) throws PolicyNotFoundException{
		String query = "DELETE FROM Policy WHERE policyId = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setLong(1,policyID);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                throw new PolicyNotFoundException("Policy with ID " + policyID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while deleting policy with ID " + policyID);
        }
    }

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO User (userId, username, password, role) VALUES (?, ?, ?,?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setLong(1,user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
           

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
            return false;
        }

	}
	}

	
	

