package task6;
import java.util.Scanner;
public class Transactions {

	    // Transaction class to represent each transaction
	    static class Transaction {
	        private String type; // "Deposit" or "Withdrawal"
	        private double amount;

	        public Transaction(String type, double amount) {
	            this.type = type;
	            this.amount = amount;
	        }

	        public String getType() {
	            return type;
	        }

	        public double getAmount() {
	            return amount;
	        }

	        @Override
	        public String toString() {
	            return type + ": $" + amount;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        final int MAX_TRANSACTIONS = 100; // Maximum number of transactions
	        Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];
	        int transactionCount = 0;
	        String choice;

	        // Loop to add transactions
	        do {
	            if (transactionCount >= MAX_TRANSACTIONS) {
	                System.out.println("Transaction limit reached. Cannot add more transactions.");
	                break;
	            }

	            System.out.println("Please enter a transaction:");
	            System.out.print("Type (Deposit/Withdrawal): ");
	            String type = scanner.nextLine();

	            System.out.print("Amount: ");
	            double amount = scanner.nextDouble();
	            scanner.nextLine(); // Consume the newline character

	            // Add transaction to the array
	            transactions[transactionCount] = new Transaction(type, amount);
	            transactionCount++; // Increment the transaction count

	            System.out.print("Do you want to add another transaction? (yes/no): ");
	            choice = scanner.nextLine().toLowerCase();
	        } while (choice.equals("yes"));

	        // Display transaction history
	        System.out.println("\nTransaction History:");
	        for (int i = 0; i < transactionCount; i++) {
	            System.out.println(transactions[i]);
	        }

	        scanner.close();
	    }
	}

