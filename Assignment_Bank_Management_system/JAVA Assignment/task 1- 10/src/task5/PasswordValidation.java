package task5;
import java.util.Scanner;
public class PasswordValidation {

	public static void main(String[] args) {
		


		        Scanner scanner = new Scanner(System.in);
		        
		        System.out.print("Create a password for your bank account: ");
		        String password = scanner.nextLine();
		        
		        // Validate the password
		        if (isValidPassword(password)) {
		            System.out.println("Password is valid.");
		        } else {
		            System.out.println("Password is invalid. Please ensure it meets the following criteria:");
		            System.out.println("- At least 8 characters long.");
		            System.out.println("- Contains at least one uppercase letter.");
		            System.out.println("- Contains at least one digit.");
		        }
		        
		        scanner.close();
		    }
		    
		    public static boolean isValidPassword(String password) {
		        // Check length
		        if (password.length() < 8) {
		            return false;
		        }
		        
		        // Check for uppercase letter and digit
		        boolean hasUppercase = false;
		        boolean hasDigit = false;
		        
		        for (char ch : password.toCharArray()) {
		            if (Character.isUpperCase(ch)) {
		                hasUppercase = true;
		            }
		            if (Character.isDigit(ch)) {
		                hasDigit = true;
		            }
		        }
		        
		        return hasUppercase && hasDigit;
		    }
		

	}


