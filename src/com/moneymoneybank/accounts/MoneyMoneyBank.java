package com.moneymoneybank.accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.account.service.SavingsAccountServiceImpl;
import com.moneymoney.exception.AccountNotFoundException;



@WebServlet("*.mm")
public class MoneyMoneyBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

    
	   @Override
	public void init() throws ServletException {
		super.init();
		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection connection = DriverManager.getConnection
    					("jdbc:mysql://localhost:3306/moneymoneybank_db", "root", "root");
    			PreparedStatement preparedStatement = 
    					connection.prepareStatement("DELETE FROM account_details");
    			preparedStatement.execute();
    		} catch (ClassNotFoundException e) {
 
    			e.printStackTrace();
    		} catch (SQLException e) {
 
    			e.printStackTrace();
    		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SavingsAccount savingAccount = null;
		SavingsAccountService savingsAccountService = new SavingsAccountServiceImpl();
		String path = request.getServletPath();
		out = response.getWriter();
		System.out.println(path);
		switch(path){
		case "/AddNewAccount.mm":
			response.sendRedirect("AddNewAccount.html");
			break;
		case "/OpenAccount.mm":
			String accouontHolderName = request.getParameter("accountHolderName");
			double balance = Double.parseDouble(request.getParameter("accountBal"));
			boolean isSalary = ((request.getParameter("rdSalary").equalsIgnoreCase("no")?false:true));
			try {
				savingsAccountService.createNewAccount(accouontHolderName, balance, isSalary);
				out.println("Account created");
				response.sendRedirect("index.html");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			break;
		case "/closeaccount.mm":
			response.sendRedirect("CloseAccount.html");
			break;
		case "/closeAccount.mm":
			int accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			
			try {
				savingsAccountService.deleteAccount(accountNumber);
				out.println("Account deleted");
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			
			break;
		case "/getcurrentbalance.mm":
			response.sendRedirect("GetCurrentBalance.html");
			break;
		case "/getCurrentBalance.mm":
			int accountNumbertoCheckCurrentBalance = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getCurrentBalance(accountNumbertoCheckCurrentBalance);
				String accountHolderName = savingAccount.getBankAccount().getAccountHolderName();
				double currentBalance = savingAccount.getBankAccount().getAccountBalance();
				out.println("Current Balance of "+accountHolderName+" is "+currentBalance);
				/*response.sendRedirect("index.html");*/
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/withdraw.mm":
			response.sendRedirect("withdraw.html");
			break;
		case "/Withdraw.mm":
			accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				double amount = Double.parseDouble(request.getParameter("amount"));
				 savingsAccountService.withdraw(savingAccount, amount);
				 response.sendRedirect("index.html");
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deposit.mm":
			response.sendRedirect("deposit.html");
			break;
		case "/Deposit.mm":
			accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				double amount = Double.parseDouble(request.getParameter("amount"));
				savingsAccountService.deposit(savingAccount, amount);
				response.sendRedirect("index.html");
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/transferfund.mm":
			response.sendRedirect("transferfund.html");
			break;
		case "/transferFund.mm":
			int sendersAccountNumber = Integer.parseInt(request.getParameter("senderAccountNo"));
			int receiverAccountNumber = Integer.parseInt(request.getParameter("receiverAccountNo"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				SavingsAccount sendersSavingsAccount = savingsAccountService.getAccountById(sendersAccountNumber);
				SavingsAccount receiverSavingAccount = savingsAccountService.getAccountById(receiverAccountNumber);
				savingsAccountService.fundTransfer(sendersSavingsAccount, receiverSavingAccount, amount);
				response.sendRedirect("index.html");
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
				 			
		}
		
	}

}
