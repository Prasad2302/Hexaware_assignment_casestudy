package task10;
import java.util.Scanner;
public class BankApp {

	public static void main(String[] args) {
		
		
		Bank bank = new Bank(100);
		
		Scanner sc = new Scanner(System.in);


		while(true) {
			 System.out.println("\n/////////// Welcome to the Banking System //////////");
	            System.out.println("1. Create Account");
	            System.out.println("2. De1posit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Get Balance");
	            System.out.println("5. Transfer");
	            System.out.println("6. Get Account Details");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	            
	            case 1:
	            	System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    int phoneNumber = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
	            
	            
                    Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, address);
                    
                    System.out.print("Enter Account Type (Savings/Current): ");
                    String accType = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    long balance = sc.nextLong();

                    bank.create_account(customer, accType, balance);
                    break;
                    
                    
	            	case 2: 
	            		
	            		System.out.print("Enter Account Number: ");
	                    long depositAccountNumber = sc.nextLong();
	                    System.out.print("Enter Amount to Deposit: ");
	                    long depositAmount = sc.nextLong();
	                    float newBalanceAfterDeposit = bank.deposit(depositAccountNumber, depositAmount);
	                    if (newBalanceAfterDeposit != -1) {
	                        System.out.println("New Balance: " + newBalanceAfterDeposit);
	                    }
	                    break;
	                    
	                    case 3 :
		            		
		            		System.out.print("Enter Account Number: ");
		                    long withdrawAccountNumber = sc.nextLong();
		                    System.out.print("Enter Amount to Withdraw: ");
		                    long withdrawAmount = sc.nextLong();
		                    float newBalanceAfterWithdraw = bank.withdraw(withdrawAccountNumber, withdrawAmount);
		                    if (newBalanceAfterWithdraw != -1) {
		                        System.out.println("New Balance: " + newBalanceAfterWithdraw);
		                    }
		                    break;
		                    
	                    case 4:
		                        System.out.print("Enter Account Number: ");
		                        long balanceAccountNumber = sc.nextLong();
		                        float currentBalance = bank.get_account_balance(balanceAccountNumber);
		                        if (currentBalance != -1) {
		                            System.out.println("Current Balance: " + currentBalance);
		                        }
		                        break;
		                        
		                        
	                    case 5:
		                          	System.out.print("Enter From Account Number: ");
		                            long fromAccountNumber = sc.nextLong();
		                            System.out.print("Enter To Account Number: ");
		                            long toAccountNumber = sc.nextLong();
		                            System.out.print("Enter Amount to Transfer: ");
		                            long transferAmount = sc.nextLong();
		                            bank.transfer(fromAccountNumber, toAccountNumber, transferAmount);
		                            break;
		                            
		                            
		                            
		                            
	                    case 6:
	                        System.out.print("Enter Account Number: ");
	                        long accountDetailNumber = sc.nextLong();
	                        bank.getAccountDetails(accountDetailNumber);
	                        break;
	                        
	                        
	                    case 7:
	                        System.out.println("Exiting the banking system. Goodbye!");
	                        sc.close();
	                        return;
	                        
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                    
	            	
	            	
	            }
	            
	           
	            	
		}

	}

}
