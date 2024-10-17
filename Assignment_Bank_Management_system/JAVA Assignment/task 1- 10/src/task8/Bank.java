package task8;
import java.util.Scanner;
public class Bank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////// Welcome To HMBank //////////////");
		
//		System.out.println("Enter Account Number :");
//		int accountNumber = sc.nextInt();
//		
//		System.out.println("Enter Account Balance :");
//		double acoountBalance = sc.nextDouble();
		
		System.out.println("Choose Account Type you want to create: ");
		System.out.println("1. Savings Account");
		System.out.println("2. Current Account");
		int choice = sc.nextInt();
		
		
		
		switch(choice) {
		case 1 :
			System.out.println("Enter Account Number :");
			int savingsAccountNumber = sc.nextInt();
			
			System.out.println("Enter Initial Account Balance :");
			double savingsAcoountBalance = sc.nextDouble();
			
			SavingsAccount sa = new SavingsAccount(savingsAccountNumber, savingsAcoountBalance); 
			System.out.println("Savings Account created succsfully... ");
			performOperations(sc, sa );
			break;
			
		case 2:
			System.out.println("Enter Account Number :");
			int currentAccountNumber = sc.nextInt();
			
			System.out.println("Enter Initial Account Balance :");
			double currentAccountBalance = sc.nextDouble();
			
			CurrentAccount ca = new CurrentAccount(currentAccountNumber, currentAccountBalance);
			System.out.println("Current Account Created succesfully... ");
			
			performOperations(sc, ca);
			
			break;
			
			
		}
		

}

	
	 public static void performOperations(Scanner sc, Account account) {
	
		 while(true) {
		 System.out.println("Enter operation you want to perform ");
		 System.out.println("1.  Deposite");
		 System.out.println("2. Withdraw");
		 
		 if(account instanceof SavingsAccount) {
			 System.out.println("3. Calculate Interest");
		 }
		 
		 System.out.println("4. Exit");
		 
		 
		 int option = sc.nextInt();
			
			switch(option) {
			case 1 :
				System.out.println("Enter Amount to deposite :");
				float amount = sc.nextFloat();
				account.deposite(amount);
				break;
				
			case 2 : 
				System.out.println("Enter Amount to Withdraw :");
				float amount2 = sc.nextFloat();
				account.withdraw(amount2);
				break;
				
				
			case 3 :
				 if(account instanceof SavingsAccount) {
					 ((SavingsAccount)account).calculateInterest();
				 }
				 else {
					 System.out.println("Interest cannot be calculated for Current Account");
				 }
				
				 break;
				 
				 
			case 4 :
				System.out.println("Exited3.");
				return;
				
			default :
				System.out.println("Invalid Choice");
				break;
				
			
				
			}
			
		 }
				
			
		}

}
