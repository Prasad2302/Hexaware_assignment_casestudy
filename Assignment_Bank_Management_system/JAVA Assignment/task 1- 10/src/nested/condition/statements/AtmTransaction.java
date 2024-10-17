package nested.condition.statements;
import java.util.Scanner;
public class AtmTransaction {

	public static void main(String[] args) {
		System.out.println("Welcome to HM Bank ATM, Please Enter Your Card");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Account Balance : ");
		float balance = sc.nextFloat();
		
		System.out.println("Choose the Following options :");
		
		
		
		System.out.println("1. Check balance ");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposite Money");
		
		int choice = sc.nextInt();
		transaction(choice, balance, sc);
	}

	
	public static void transaction (int choice, float balance, Scanner sc) {
		switch (choice) {
		case 1 :
			System.out.println("Your Account Balance is :"+ balance);
			break;
			
		case 2 : 
			System.out.println("Enter Amount to be withdrawn :");
			double withdrawAmount = sc.nextDouble();
			
			if (withdrawAmount <= balance) {
                if (withdrawAmount % 100 == 0 || withdrawAmount % 500 == 0) {
                    balance -= withdrawAmount;
                    System.out.println("Withdrawal successful! Your new balance is: $" + balance);
                } else {
                    System.out.println("Withdrawal failed. Amount must be in multiples of 100 or 500.");
                }
            } else {
                System.out.println("Withdrawal failed. Insufficient balance.");
            }
            break;

        case 3: // Deposit Money
            System.out.println("Enter Amount to be Depositd :");
            double depositAmount = sc.nextDouble();
            balance += depositAmount;
            System.out.println("Deposit successful! Your new balance is:" + balance);
            break;

        default: // Invalid Option
            System.err.println("Invalid option. Please try again.");
			
		}
		
		
	}
}
