package conditional.statements;
import java.util.Scanner;


public class LoanEligibility {

	public static void main(String[] args) {
		
		System.out.println("Enter Your Credit Score");
		Scanner sc = new Scanner(System.in);
		
		int creditScore = sc.nextInt();
		System.out.println("Your Credit Score is :"+creditScore);
		
		System.out.println("Enter Your Annual Income :");
		int annualIncome = sc.nextInt();
		
		System.out.println("Annual Income is :"+annualIncome);
		
		checkLoan(creditScore, annualIncome);
		
	}

	
	public static void checkLoan (int creditScore,int annualIncome) {
		
		if(creditScore < 700 && annualIncome < 50000) {
			System.err.print("Sorry You are not Eligible for Loan");
			
		}
		else if (creditScore >= 700 && annualIncome < 50000) {
			System.out.println("You are not eligible for loan because of low Annual Balance - less than 50000");
		}
		else if (creditScore < 700 && annualIncome >= 50000) {
			System.out.println("You are not Eligible for loan because of Low Credit Score - less than 700");
		}
		else {
			System.out.println("You are Eligible for loan");
		}
	}
}
