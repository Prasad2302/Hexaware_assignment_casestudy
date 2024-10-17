package dao;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Customer;
import entity.Transaction;
public class BankRepositoryImpl implements IBankRepository{
	
	private Connection conn; 
	public BankRepositoryImpl() {
		conn = DBUtil.getDBConnection();
	}

	
	
	@Override
	public void createAccount(Customer customer, long accNo, String accType, float balance) {
		 int count = 0;
		    String insertCustomer = "INSERT INTO customers (customer_id, first_name, last_name, email, phone_no, city) " +
		                            "VALUES (?, ?, ?, ?, ?, ?)";
		    String insertAccount = "INSERT INTO accounts (account_id, customer_id, account_type, balance, doj) " +
		                           "VALUES (?, ?, ?, ?, NOW())";

		    PreparedStatement pstmt = null; // Declaring pstmt outside try block for cleanup in finally block

		    try {
		        // Insert customer data into customers table (excluding DOB)
		        pstmt = conn.prepareStatement(insertCustomer);
		        pstmt.setLong(1, customer.getCustomerId());
		        pstmt.setString(2, customer.getFirstName());
		        pstmt.setString(3, customer.getLastName());
		        pstmt.setString(4, customer.getEmailAddress());
		        pstmt.setString(5, customer.getPhoneNumber());
		        pstmt.setString(6, customer.getAddress());

		        count = pstmt.executeUpdate(); // Insert customer into the database
		        if (count == 0) {
		            throw new SQLException("Customer insertion failed.");
		        }

		        // Insert account data into accounts table
		        pstmt = conn.prepareStatement(insertAccount);
		        pstmt.setLong(1, accNo); // Account number
		        pstmt.setLong(2, customer.getCustomerId()); // Foreign key (customer_id)
		        pstmt.setString(3, accType); // Account type (savings, current, etc.)
		        pstmt.setFloat(4, balance); // Initial balance

		        count = pstmt.executeUpdate(); // Insert account into the database
		        if (count == 0) {
		            throw new SQLException("Account insertion failed.");
		        }

		        System.out.println("Account created successfully.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (pstmt != null) pstmt.close(); // Close pstmt safely
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
	
		
	}

	@Override
	public List<Account> listAllAccounts() {
		List<Account> list = new ArrayList<Account>();
		
		String selectAll = "select account_id, account_Type,balance from accounts";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				long accountNumber = rs.getLong("account_id");
//				long customerId = rs.getLong("customer_ID");
				String accountType = rs.getString("account_Type");
				double accountBalance = rs.getDouble("balance");
				
				Account account = new Account(accountNumber, accountType, accountBalance);
				list.add(account);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void calculateInterest() {
		String selectAccount = "select * from accounts where account_type = savings and balance > 1000";
		PreparedStatement ps = null;
	    ResultSet rs = null;

		
	    try {
	        

	        // Prepare and execute the SQL query
	        ps = conn.prepareStatement(selectAccount);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            long accountId = rs.getLong("account_id");
	            double balance = rs.getDouble("balance");
	            int interestRate = 5; // Assume a 5% interest rate, adjust as needed

	            // Calculate interest for the account
	            double interest = (balance * interestRate) / 100;
	            double newBalance = balance + interest;

	            // Update the balance in the database
	            String updateBalance = "UPDATE accounts SET balance = ? WHERE account_id = ?";
	            try (PreparedStatement updatePs = conn.prepareStatement(updateBalance)) {
	                updatePs.setDouble(1, newBalance);
	                updatePs.setLong(2, accountId);
	                updatePs.executeUpdate();
	            }

	            // Log the updated balance
	            System.out.println("Interest calculated for Account ID: " + accountId + 
	                               " | Previous Balance: " + balance + 
	                               " | New Balance: " + newBalance);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
		
	

	@Override
	public double getAccountBalance(long account_number) {
		double accountBalance = 0.0;  // Initialize accountBalance to store the result
	    String selectAccountId = "SELECT balance FROM accounts WHERE account_id = ?";  // SQL query
	    
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectAccountId);
	        pstmt.setLong(1, account_number);  // Set the account_number parameter
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {  // Check if there's a result
	            accountBalance = rs.getDouble("balance");  // Get the balance from the result set
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();  // Print the exception stack trace
	    }
	    
	    return accountBalance;  // Return the retrieved balance
	}

	@Override
	public double deposite(long account_number, float amount) {
		double newBalance = 0.0;
	    String selectAccountBalance = "SELECT balance FROM accounts WHERE account_id = ?";
	    String updateAccountBalance = "UPDATE accounts SET balance = ? WHERE account_id = ?";
	    String insertTransaction = "INSERT INTO transactions (transaction_id, account_id, transaction_type, amount, transaction_date) VALUES (1001,?, ?, ?, ?)";

	    try {
	        // Step 1: Retrieve current balance
	        PreparedStatement selectPstmt = conn.prepareStatement(selectAccountBalance);
	        selectPstmt.setLong(1, account_number);
	        ResultSet rs = selectPstmt.executeQuery();

	        if (rs.next()) {
	            double currentBalance = rs.getDouble("balance");
	            
	            // Step 2: Calculate new balance
	            newBalance = currentBalance + amount;

	            // Step 3: Update the new balance in the accounts table
	            PreparedStatement updatePstmt = conn.prepareStatement(updateAccountBalance);
	            updatePstmt.setDouble(1, newBalance);
	            updatePstmt.setLong(2, account_number);
	            updatePstmt.executeUpdate();  // Update the balance

	            // Step 4: Insert transaction record
	            PreparedStatement insertPstmt = conn.prepareStatement(insertTransaction);
	            insertPstmt.setLong(1, account_number);
	            insertPstmt.setString(2, "Deposit");  // Transaction type
	            insertPstmt.setFloat(3, amount);
	            insertPstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));  // Transaction date as current date
	            insertPstmt.executeUpdate();  // Insert the transaction

	        } else {
	            System.out.println("Account not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return newBalance; 
	}

	@Override
	public double withdraw(long account_number, float amount) {
		double newBalance = 0.0;
	    double overdraftLimit = 5000; // Example overdraft limit for current accounts (adjust based on your requirements)
	    double minBalanceSavings = 1000;
	    String selectAccountDetails = "SELECT balance, account_type FROM accounts WHERE account_id = ?";
	    String updateAccountBalance = "UPDATE accounts SET balance = ? WHERE account_id = ?";
	    String insertTransaction = "INSERT INTO transactions (account_id, transaction_type, amount, transaction_date) VALUES (?, ?, ?, ?)";

	    PreparedStatement selectPstmt = null;
	    PreparedStatement updatePstmt = null;
	    PreparedStatement insertPstmt = null;
	    ResultSet rs = null;

	    
	    try {
	        // Step 1: Retrieve current balance and account type
	    	selectPstmt = conn.prepareStatement(selectAccountDetails);
	        selectPstmt.setLong(1, account_number);
	        rs = selectPstmt.executeQuery();

	        if (rs.next()) {
	            double currentBalance = rs.getDouble("balance");
	            String accountType = rs.getString("account_type");

	            // Step 2: Check if withdrawal is allowed based on account type
	            if ("Savings".equalsIgnoreCase(accountType)) {
	                // For savings accounts, ensure the minimum balance requirement is not violated
	                if (currentBalance - amount < minBalanceSavings) {
	                    System.out.println("Withdrawal violates the minimum balance requirement for savings account.");
	                    return currentBalance; // Return the current balance without changes
	                }
	            } else if ("Current".equalsIgnoreCase(accountType)) {
	                // For current accounts, check if withdrawal exceeds the overdraft limit
	                if (currentBalance - amount < -overdraftLimit) {
	                    System.out.println("Withdrawal exceeds the overdraft limit for the current account.");
	                    return currentBalance; // Return the current balance without changes
	                }
	            }

	            // Step 3: Calculate the new balance after withdrawal
	            newBalance = currentBalance - amount;

	            // Step 4: Update the new balance in the accounts table
	            updatePstmt = conn.prepareStatement(updateAccountBalance);
	            updatePstmt.setDouble(1, newBalance);
	            updatePstmt.setLong(2, account_number);
	            updatePstmt.executeUpdate();  // Update the balance

	            // Step 5: Insert the transaction record for the withdrawal
	            insertPstmt = conn.prepareStatement(insertTransaction);
	            insertPstmt.setLong(1, account_number);
	            insertPstmt.setString(2, "Withdraw");  // Transaction type
	            insertPstmt.setFloat(3, amount);
	            insertPstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));  // Current date for transaction
	            insertPstmt.executeUpdate();  // Insert the transaction

	        } else {
	            System.out.println("Account not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the resources to avoid leaks
	        try {
	            if (rs != null) rs.close();
	            if (selectPstmt != null) selectPstmt.close();
	            if (updatePstmt != null) updatePstmt.close();
	            if (insertPstmt != null) insertPstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return newBalance;
	}

	@Override
	public void transfer(long from_account_number, long to_account_number, float amount) {
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conn.setAutoCommit(false); // Start transaction

	        // 1. Check balance of from_account_number
	        String checkBalanceQuery = "SELECT balance FROM accounts WHERE account_id = ?";
	        pstmt = conn.prepareStatement(checkBalanceQuery);
	        pstmt.setLong(1, from_account_number);
	        rs = pstmt.executeQuery();
	        
	        float fromBalance = 0;
	        if (rs.next()) {
	            fromBalance = rs.getFloat("balance");
	            if (fromBalance < amount) {
	                System.out.println("Insufficient balance for transfer.");
	                return; // Exit if balance is insufficient
	            }
	        } else {
	            System.out.println("Source account not found.");
	            return;
	        }
	        
	        // 2. Withdraw from from_account_number
	        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
	        pstmt = conn.prepareStatement(withdrawQuery);
	        pstmt.setFloat(1, amount);
	        pstmt.setLong(2, from_account_number);
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new SQLException("Failed to withdraw from source account.");
	        }

	        // 3. Deposit to to_account_number
	        String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
	        pstmt = conn.prepareStatement(depositQuery);
	        pstmt.setFloat(1, amount);
	        pstmt.setLong(2, to_account_number);
	        rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new SQLException("Failed to deposit into target account.");
	        }

	        // 4. Insert transaction for the withdrawal
	        String insertWithdrawalQuery = "INSERT INTO transactions (account_id, transaction_type, amount, transaction_date) " +
	                                       "VALUES (?, 'withdraw', ?, NOW())";
	        pstmt = conn.prepareStatement(insertWithdrawalQuery);
	        pstmt.setLong(1, from_account_number);
	        pstmt.setFloat(2, amount);
	        pstmt.executeUpdate();

	        // 5. Insert transaction for the deposit
	        String insertDepositQuery = "INSERT INTO transactions (account_id, transaction_type, amount, transaction_date) " +
	                                    "VALUES (?, 'deposit', ?, NOW())";
	        pstmt = conn.prepareStatement(insertDepositQuery);
	        pstmt.setLong(1, to_account_number);
	        pstmt.setFloat(2, amount);
	        pstmt.executeUpdate();

	        // 6. Commit transaction
	        conn.commit();
	        System.out.println("Transfer successful.");

	    } catch (SQLException e) {
	        // Handle any SQL errors
	        try {
	            if (conn != null) {
	                conn.rollback(); // Rollback transaction if any issue occurs
	            }
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

	@Override
	public Account getAccountDetails(long accountNumber) {
		Account account = null;
	    String selectAccountQuery = "SELECT a.account_id, a.account_type, a.balance, c.customer_id, c.first_name, c.last_name, c.email, c.phone_no, c.city " +
	                                "FROM accounts a " +
	                                "JOIN customers c ON a.customer_id = c.customer_id " +
	                                "WHERE a.account_id = ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectAccountQuery);
	        pstmt.setLong(1, accountNumber);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // Account details
	            long accountId = rs.getLong("account_id");
	            String accountType = rs.getString("account_type");
	            double balance = rs.getDouble("balance");

	            // Customer details
	            long customerId = rs.getLong("customer_id");
	            String firstName = rs.getString("first_name");
	            String lastName = rs.getString("last_name");
	            String email = rs.getString("email");
	            String phoneNo = rs.getString("phone_no");
	            String city = rs.getString("city");

	            // Create Customer object
	            Customer customer = new Customer(customerId, firstName, lastName, email, phoneNo, city);

	            // Create Account object with associated Customer
	            account = new Account(accountId, accountType, balance, customer, accountId);
	        } else {
	            System.out.println("Account not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return account; 
	}

	@Override
	public List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate) {
		List<Transaction> transactionList = new ArrayList<>();

	    String selectTransactionsQuery = "SELECT t.transaction_type, t.amount, t.transaction_date, a.account_id, a.account_type, a.balance " +
	                                     "FROM transactions t " +
	                                     "JOIN accounts a ON t.account_id = a.account_id " +
	                                     "WHERE a.account_id = ? AND t.transaction_date BETWEEN ? AND ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectTransactionsQuery);
	        pstmt.setLong(1, accountNumber);
	        pstmt.setDate(2, new java.sql.Date(fromDate.getTime()));  // Convert java.util.Date to java.sql.Date
	        pstmt.setDate(3, new java.sql.Date(toDate.getTime()));    // Convert java.util.Date to java.sql.Date

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            // Retrieve account details
	            long accNumber = rs.getLong("account_id");
	            String accountType = rs.getString("account_type");
	            double balance = rs.getDouble("balance");
	            Account account = new Account(accNumber, accountType, balance, null, accNumber); // Assuming no customer here for simplicity

	            // Retrieve transaction details
	            String transactionType = rs.getString("transaction_type");
	            float amount = rs.getFloat("amount");
	            LocalDateTime dateTime = rs.getTimestamp("transaction_date").toLocalDateTime();
	            String description = "Transaction for account " + accountNumber; // You can modify this as needed

	            // Create a Transaction object
	            Transaction transaction = new Transaction(account, description, dateTime, transactionType, amount);

	            // Add the Transaction object to the list
	            transactionList.add(transaction);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return transactionList;
	}
	
	
	
	
}
