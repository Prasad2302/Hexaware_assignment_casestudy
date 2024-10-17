package loop.structures;
import java.util.Scanner;

public class CompoundInterest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();
        
        System.out.println("Enter Annual Rate of Interest (in %): ");
        double annualInterestRate = sc.nextDouble();
        
        System.out.println("Enter Number of Years:");
        int numberOfYears = sc.nextInt();
        
       
        double totalBalance = initialBalance;
        
       
        for (int i = 1; i <= numberOfYears; i++) {
            totalBalance = totalBalance * (1 + annualInterestRate / 100); 
            System.out.println("Balance after year " + i + ": " + totalBalance); 
        }
        
        
        System.out.println("Total Balance: " + totalBalance);
    }
}



		
	


