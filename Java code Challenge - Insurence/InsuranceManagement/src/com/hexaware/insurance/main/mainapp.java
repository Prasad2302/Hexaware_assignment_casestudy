package com.hexaware.insurance.main;

import java.util.Collection;
import java.util.Scanner;

import com.hexaware.insurance.entity.Policy;
import com.hexaware.insurance.entity.User;
import com.hexaware.insurance.exception.PolicyNotFoundException;
import com.hexaware.insurance.service.IPolicyService;
import com.hexaware.insurance.service.PolicyService;

public class mainapp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		IPolicyService policyservice = new PolicyService();
		
		
		
		while(true) {
			
			//////// Menue ///////////////
			System.out.println("Welcome to Insurance Management System ");
			
			
			
			
			System.out.println("Please select the option displayed below");
			System.out.println("1. Create Policy ");
			System.out.println("2.  Show Policy ");
			System.out.println("3. Show All Policies ");
			System.out.println("4. Update existing Policy ");
			System.out.println("5. Delete your Policy ");
			System.out.println("6. Create User ");
			System.out.println("0. Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 :
	
				System.out.println("Enter Policy ID ");
				long policyID = sc.nextLong();
				sc.nextLine(); // Consume the newline character left by nextLong()

				System.out.println("Enter Policy Name");
				String policyName = sc.nextLine().trim(); 
				if (policyName.isEmpty()) {
			        System.out.println("Policy Name cannot be empty. Please try again.");
			        continue; // Go back to the start of the while loop
			    }
				
				System.out.println(" ");
				
				System.out.println("Enter Policy Type");
				String policyType = sc.nextLine();
				
				Policy policy = new Policy(policyID, policyName, policyType);
				
				if (policyservice.createPolicy(policy)) {
		            System.out.println("Policy created successfully!");
		        } else {
		            System.out.println("Policy creation failed!");
		        }
				
				
				break;
				
			case 2:
				
				System.out.println(" Enter Policy ID to show policy details ");
				long policyId = sc.nextInt();
				
				try {
					Policy retrieve = policyservice.getPolicy(policyId);
				} catch (PolicyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
				
			case 3 : 
				try {
					Collection<Policy> allPolicies = policyservice.getAllPolicies();
					System.out.println("All the policies are.. ");
					
					for (Policy policies : allPolicies) {
		                System.out.println(policies);
		            }
					
				} catch (PolicyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
				
			case 4: 
				System.out.println("Enter policy ID:");
				long updatePolicyId = sc.nextLong();
				sc.nextLine(); // Consume newline character

				try {
				    Policy policyUpdate = policyservice.getPolicy(updatePolicyId);
				    
				    if (policyUpdate != null) {
				        System.out.println("Enter the updated policy Name:");
				        String updatedName = sc.nextLine();
				        policyUpdate.setPolicyName(updatedName);
				        
				        System.out.println("Enter updated policy Type:");
				        String updateType = sc.nextLine();
				        policyUpdate.setPolicyType(updateType);
				        
				        // Now update the policy with the updated Policy object
				        if (policyservice.updatePolicy(policyUpdate)) {
				            System.out.println("Policy updated successfully!");
				        } else {
				            System.out.println("Policy update failed!");
				        }
				    } else {
				        System.out.println("Policy not found.");
				    }
				} catch (PolicyNotFoundException e) {
				    System.out.println("Policy not found: " + e.getMessage());
				}
				
				break;
				
			case 5 : 
				System.out.println("Enter Policy ID you want to delete :");
				long policyDeleteID = sc.nextLong();
				
				try {
					if(policyservice.deletePolicy(policyDeleteID)) {
						System.out.println("Policy Deleted Successfully ");
					}
				} catch (PolicyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
				
			case 6 : 
				System.out.println("Create User : ");
				
				System.out.println("Enter User ID");
				long userID = sc.nextLong();
				sc.nextLine(); 
				
				System.out.println("Enter Username");
				String userName = sc.nextLine();
				
				System.out.println("Enter password");
				String password = sc.nextLine();
				
				System.out.println("Enter User Role :");
				String role = sc.nextLine();
				
				User user = new User(userID, userName, password, role);
				
				if(policyservice.createUser(user)) {
					System.out.println("User Created Successfully...");
				}
				else {
					System.out.println("User Not Created");
				}
				
				
				break; 
				
				
			case 0 : 
				 System.out.println("Exiting the application...");
                 sc.close();
                 return; 
				
				
				
			default : 
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}
		
		
		

	}

}
