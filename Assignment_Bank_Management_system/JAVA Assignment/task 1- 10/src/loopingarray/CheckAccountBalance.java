package loopingarray;
import java.util.Scanner;
/*
 * Author Name : Prasad Kulkarni
 * Assignment Name : Bank Management System
 * Task Description : Program to check the bank account of User and provide Output
 * Date : 10-10-2023
 */


public class CheckAccountBalance {

	public static void main(String[] args) {
		
		
		// Sample Data 
		String accountNumber[] = new String[6];
		
		accountNumber[0] = "1001";
		accountNumber[1] = "1002";
		accountNumber[2] = "1003";
		accountNumber[3] = "1004";
		accountNumber[4] = "1005";
		accountNumber[5] = "1006";
		
		int accountBalances[] = new int[10];
		accountBalances[0] = 5000;
		accountBalances[1] = 4000;
		accountBalances[2] = 45000;
		accountBalances[3] = 35000;
		accountBalances[4] = 1000;
		accountBalances[5]= 25000;
		
		
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		
		while(true ) {
			System.out.println("Please Enter Your Account Number or type '0' to Exit");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("0")) {
				System.out.println("Thank You for using HMBank");
				break;
			}
			

			
			for(int i = 0; i< accountNumber.length; i++) {
				
				
				
				if(accountNumber[i] != null && accountNumber[i].equals(input)) {
					
					valid = true;
					double balance = accountBalances[i];
					
					System.out.println("Account Balance is :"+balance);
					break;
				}
				
			}
			
			if(!valid) {
				System.out.println("Invalid Accout Number, Please Enter a Valid Account Number");
			}
			
			
			
		}
		
		
		
		
 	}

}
