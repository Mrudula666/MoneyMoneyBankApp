package com.moneymoneybank.accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.SortByAccountBalance;
import com.moneymoney.account.SortByAccountBalanceInDescending;
import com.moneymoney.account.SortByAccountHolderName;
import com.moneymoney.account.SortByAccountHolderNameInDescending;
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.account.service.SavingsAccountServiceImpl;
import com.moneymoney.exception.AccountNotFoundException;



@WebServlet("*.mm")
public class MoneyMoneyBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	RequestDispatcher dispatcher;
	boolean flag = true;

    
	   @Override
	public void init() throws ServletException {
		super.init();
		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection connection = DriverManager.getConnection
    					("jdbc:mysql://localhost:3306/moneymoneybank_db", "root", "root");
    			
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
		
		int accountNumber = 0;
		
		
		switch(path){
		case "/AddNewAccount.mm":
			response.sendRedirect("AddNewAccount.jsp");
			break;
		case "/OpenAccount.mm":
			String accouontHolderName = request.getParameter("accountHolderName");
			double balance = Double.parseDouble(request.getParameter("accountBal"));
			boolean isSalary = ((request.getParameter("rdSalary").equalsIgnoreCase("no")?false:true));
			try {
				savingsAccountService.createNewAccount(accouontHolderName, balance, isSalary);
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			break;
		case "/closeaccount.mm":
			response.sendRedirect("CloseAccount.jsp");
			break;
		case "/closeAccount.mm":
			accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			
			try {
				savingsAccountService.deleteAccount(accountNumber);
				response.sendRedirect("index.jsp");
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e1) {
				e1.printStackTrace();
			}		
			break;
			
		case "/getcurrentbalance.mm":
			response.sendRedirect("GetCurrentBalance.jsp");
			break;
		case "/getCurrentBalance.mm":
			int accountNumbertoCheckCurrentBalance = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getCurrentBalance(accountNumbertoCheckCurrentBalance);
				request.setAttribute("account", savingAccount);
				dispatcher = request.getRequestDispatcher("CurrentBalance.jsp");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				
				e.printStackTrace();
			}
			break;
		case "/withdraw.mm":
			response.sendRedirect("withdraw.jsp");
			break;
		case "/WithdrawForm.mm":
			accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				double amount = Double.parseDouble(request.getParameter("amount"));
				 savingsAccountService.withdraw(savingAccount, amount);
				 request.setAttribute("account", savingAccount);
					dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
					dispatcher.forward(request, response);
				 break;
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				e.printStackTrace();
			}
			
		case "/deposit.mm":
			response.sendRedirect("deposit.jsp");
			break;
		case "/Deposit.mm":
			accountNumber = Integer.parseInt(request.getParameter("accountNo"));
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				double amount = Double.parseDouble(request.getParameter("amount"));
				savingsAccountService.deposit(savingAccount, amount);
				 request.setAttribute("account", savingAccount);
					dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
					dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "/transferfund.mm":
			response.sendRedirect("transferfund.jsp");
			break;
		case "/transferFund.mm":
			int sendersAccountNumber = Integer.parseInt(request.getParameter("senderAccountNo"));
			int receiverAccountNumber = Integer.parseInt(request.getParameter("receiverAccountNo"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				SavingsAccount sendersSavingsAccount = savingsAccountService.getAccountById(sendersAccountNumber);
				SavingsAccount receiverSavingAccount = savingsAccountService.getAccountById(receiverAccountNumber);
				savingsAccountService.fundTransfer(sendersSavingsAccount, receiverSavingAccount, amount);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "/searchaccount.mm":
			response.sendRedirect("SearchAccount.jsp");
			break;
		case "/search.mm":
			 accountNumber = Integer.parseInt(request.getParameter("searchAccountNo"));
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				request.setAttribute("account", savingAccount);
				dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException
					| AccountNotFoundException e) {
				
				e.printStackTrace();
			}
			break;
		case "/getAllTheAccounts.mm":
			
			try {
				List<SavingsAccount> savingAccountList = savingsAccountService.getAllSavingsAccount();
				request.setAttribute("accounts", savingAccountList);
				dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/sortByName.mm":
			flag = !flag;
			try {
				List<SavingsAccount> accountsInOrder = savingsAccountService.getAllSavingsAccount();
				if(flag){
				Collections.sort(accountsInOrder,new SortByAccountHolderName());
				}else{
					Collections.sort(accountsInOrder,new SortByAccountHolderNameInDescending());
				}
				request.setAttribute("accounts", accountsInOrder);
				dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case "/sortByAccountBalance.mm":
			flag = !flag;
			try {
				List<SavingsAccount> accountsInOrder = savingsAccountService.getAllSavingsAccount();
				if(flag){
				Collections.sort(accountsInOrder,new SortByAccountBalance());
				}else{
					Collections.sort(accountsInOrder,new SortByAccountBalanceInDescending());
				}
				request.setAttribute("accounts", accountsInOrder);
				dispatcher = request.getRequestDispatcher("GetAccounts.jsp");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/Account.mm":
			response.sendRedirect("UpdateForm.jsp");
			break;
		
		case "/updatedAccount.mm":
			accountNumber =  Integer.parseInt(request.getParameter("accountNumber"));
			
			try {
				savingAccount = savingsAccountService.getAccountById(accountNumber);
				
				request.setAttribute("account", savingAccount);
				dispatcher = request.getRequestDispatcher("UpdateAccount.jsp");
				dispatcher.forward(request, response);
				savingsAccountService.updateAccount(savingAccount);
				out.println("Update successful");
				break;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 			
		}
		
	}

}
