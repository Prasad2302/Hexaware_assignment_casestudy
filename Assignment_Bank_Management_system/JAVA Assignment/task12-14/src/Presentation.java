	import java.util.Scanner;

import entity.Customer;
import exceptions.InsufficientFundException;
import exceptions.InvalidAccountException;
import exceptions.OverDraftLimitExceededException;
import services.BankServiceProviderImpl;
import services.CustomerServiceProviderImpl;
import services.IBankServiceProvider;
import services.ICustomerServiceProvider;

public class Presentation {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		ICustomerServiceProvider customerService = new CustomerServiceProviderImpl();
		
		IBankServiceProvider bankService = new BankServiceProviderImpl();
		try {
		 while (true) {  // Infinite loop to continuously show the menu
	            // Display the menu
	            System.out.println("Please choose the Operation You Want to Perform:");
	            System.out.println("1. Create Account");
	            System.out.println("2. Check Balance");
	            System.out.println("3. Deposit Money");
	            System.out.println("4. Withdraw Money");
	            System.out.println("5. Account Details");
	            System.out.println("6. Transfer Money");
	            System.out.println("7. Calculate Interest on Savings Account");
	            System.out.println("8. Show All Accounts");
	            System.out.println("9. Exit");

	            // Ask for the user's choice
	            int choice = sc.nextInt();
	            
	            switch (choice) {
	            case 1:
                    // Create an account
                    System.out.println("You chose to create an account.");
                    System.out.println("Enter customer details: ");
                    System.out.println("Enter Customer ID:");
                    long customerId = sc.nextLong();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter First Name:");
                    String firstName = sc.nextLine();
                    System.out.println("Enter Last Name:");
                    String lastName = sc.nextLine();
                    System.out.println("Enter Email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Phone Number:");
                    String phone = sc.nextLine();
                    System.out.println("Enter Address:");
                    String address = sc.nextLine();
                    System.out.println("Enter Account Type (Savings/Current):");
                    String accountType = sc.nextLine();
                    System.out.println("Enter Initial Balance:");
                    float balance = sc.nextFloat();
                    
                    Customer customer = new Customer(customerId, firstName, lastName, email, phone, address);
                    long accNo = System.currentTimeMillis(); // Simulate account number generation
                    
                    try {
						bankService.createAccount(customer, accNo, accountType, balance);
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println("Account created successfully with account number: " + accNo);
                    break;
                
                case 2:
                    // Check balance
                    System.out.println("Enter Account Number:");
                    long accNumForBalance = sc.nextLong();
                    double balanceResult = customerService.getAccountBalance(accNumForBalance);
                    System.out.println("Your account balance is: " + balanceResult);
                    break;
                    
                case 3:
                    // Deposit money
                    System.out.println("Enter Account Number:");
                    long accNumForDeposit = sc.nextLong();
                    System.out.println("Enter Amount to Deposit:");
                    float depositAmount = sc.nextFloat();
                    double newBalanceAfterDeposit = customerService.deposite(accNumForDeposit, depositAmount);
                    System.out.println("New Balance after deposit: " + newBalanceAfterDeposit);
                    break;
                    
                case 4:
                	try {
                    // Withdraw money with validations
                    System.out.println("Enter Account Number:");
                    long accNumForWithdraw = sc.nextLong();
                    System.out.println("Enter Amount to Withdraw:");
                    float withdrawAmount = sc.nextFloat();
                    double newBalanceAfterWithdraw;
					
						newBalanceAfterWithdraw = customerService.withdraw(accNumForWithdraw, withdrawAmount);
						System.out.println("New Balance after withdrawal: " + newBalanceAfterWithdraw);
					} catch (InsufficientFundException | OverDraftLimitExceededException | InvalidAccountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                    break;
                    
                case 5:
                	try {
                    // Account details
                    System.out.println("Enter Account Number:");
                    long accNumForDetails = sc.nextLong();
                    
						System.out.println("Account Details: " + customerService.getAccountDetails(accNumForDetails));
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;

                case 6:
                	 try {
                    // Transfer money
                    System.out.println("Enter From Account Number:");
                    long fromAccount = sc.nextLong();
                    System.out.println("Enter To Account Number:");
                    int toAccount = sc.nextInt();
                    System.out.println("Enter Amount to Transfer:");
                    float transferAmount = sc.nextFloat();
                   
						customerService.transfer(fromAccount, toAccount, transferAmount);
					} catch (InsufficientFundException | InvalidAccountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println("Money transferred successfully.");
                    break;
                    
                case 7:
                    // Calculate interest for savings account
                	System.out.println("Calculating interest on savings accounts...");
                    bankService.calculateInterest();
                    
                case 8:
                    // Show all accounts
                    System.out.println("Listing all accounts:");
                    bankService.listAllAccounts().forEach(System.out::println);
                    break;
                    
                case 9:
                    System.out.println("Exiting the program. Goodbye!");
                    sc.close();  // Close the scanner
                    return;  // Exit the program
                
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
	            }
	            
	        }
		 
	    }
		catch (NullPointerException e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
	}
}


