<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Update form</title>
<link rel="stylesheet"
	href="C:\HTML_Assingments\Banking_application\footer.css">
<title>UpdateAccount</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse"
			style="background-color: orange; border-block-end-color: red">
			<div class="container-fluid">
				<div class="navbar-header">
					<h1 style="color: red">
						<i>Money Money Bank</i>
					</h1>
				</div>
				<ul class="nav navbar-nav" style="float: right;">
					<li  style="color: red"><a href="AddNewAccount.mm" style="color: red">Create New Saving Account</a></li>
					<li><a href="Account.mm" style="color: red">Update Account</a></li>
					<li><a href="closeaccount.mm" style="color: red">Close Account</a></li>
					<li><a href="searchaccount.mm" style="color: red">Search Account</a></li>
					<li><a href="withdraw.mm" style="color: red">Withdraw</a></li>
					<li><a href="deposit.mm" style="color: red">Deposit</a></li>
					<li><a href="transferfund.mm" style="color: red">Fund Transfer</a></li>
					<li><a href="getcurrentbalance.mm" style="color: red">Check Current Balance</a></li>
					<li><a href="getAllTheAccounts.mm" style="color: red">Get All The Accounts</a></li>

				</ul>
			</div>
		</nav>
	</header>
	<div class="container">
		<h2>Update Details</h2>
		<form action="updateAccount.mm">
			<div class="form-group">
				<label for="cust_id">Account Number:</label> <input type="text"
					class="form-control"
					name="accountNumber"
					placeholder="${requestScope.account.bankAccount.accountNumber}" 
					readonly="readonly" >
			</div>
			<div class="form-group">
				<label for="name">Holder Name:</label> <input type="text"
					class="form-control" name="accountHolderName"
					placeholder="${requestScope.account.bankAccount.accountHolderName}" name="accountHolderName">
			</div>
			<div class="form-group">
				<label for="AccountBalance">Account Balance:</label> <input
					type="number" name="accountBalance" class="form-control"
					placeholder="${requestScope.account.bankAccount.accountBalance}" name="accountBal" readonly="readonly">
			</div>
			<div>
				<label for="name">Salary:</label> <label class="form-check-label">
					<input class="form-check-input radio-inline" type="radio" name="rdSalary"  value="YES"> 
					  YES
				</label> <label class="form-check-label"> 
				<input class="form-check-input radio-inline" type="radio" name="rdSalary"  value="NO"  checked> 
				NO 
				</label>
			</div>
			<div class="form-group">
				<label for="Odlimit">Over Draft Limit:</label> <input type="text"
					class="form-control" name="odlimit" placeholder="N/A">
			</div>
			<div class="form-group">
				<label for="type">Type</label> <input type="text"
					class="form-control" placeholder="SAVINGS">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<div class="footer">
		<p style="color: red; text-align: center">copyright@2018. ICICI
			pvt ltd.</p>
	</div>

</body>
</html>