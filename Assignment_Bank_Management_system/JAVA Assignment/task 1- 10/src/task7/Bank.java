package task7;
import java.util.Scanner;
public class Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account Number :");
		int accountNumber = sc.nextInt();
		
		
		System.out.println("Enter Account Type");
		String accountType = sc.next();
		
		
		System.out.println("Enter Account Balance");
		double accountBalance = sc.nextDouble();
 		
		
		
		
		Account ac = new Account(accountNumber,accountType,accountBalance);
		
		
		
		
		System.out.println("Enter Money to deposte :");
		float deposite = sc.nextFloat();
		
		
		ac.deposite(deposite);
		
		System.out.println("Enter Money to withdraw :");
		float withdraw = sc.nextFloat();
		
		ac.withdraw(withdraw);
		
		System.out.println("Enter Balance to check Interest : ");
		double interest = ac.calculateInterest(accountBalance);
		
		accountBalance = interest + accountBalance;
		
		System.out.println("Account Balance after Interest is :"+ accountBalance);
		
		

	}

}
