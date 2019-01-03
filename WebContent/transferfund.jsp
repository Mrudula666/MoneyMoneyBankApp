<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Fund transfer</title>
<link rel="stylesheet"
	href="C:\HTML_Assingments\Banking_application\footer.css">
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
					<li style="color: red"><a href="AddNewAccount.mm"
						style="color: red">Create New Saving Account</a></li>
					<li><a href="Account.mm" style="color: red">Update Account</a></li>
					<li><a href="closeaccount.mm" style="color: red">Close
							Account</a></li>
					<li><a href="searchaccount.mm" style="color: red">Search
							Account</a></li>
					<li><a href="withdraw.mm" style="color: red">Withdraw</a></li>
					<li><a href="deposit.mm" style="color: red">Deposit</a></li>
					<li><a href="transferfund.mm" style="color: red">Fund
							Transfer</a></li>
					<li><a href="getcurrentbalance.mm" style="color: red">Check
							Current Balance</a></li>
					<li><a href="getAllTheAccounts.mm" style="color: red">Get
							All The Accounts</a></li>

				</ul>
			</div>
		</nav>
	</header>
	<div class="container">
		<h2>Transfer Fund</h2>
		<form action="transferFund.mm">
			<div class="form-group">
				<label for="from_acc_no">Enter Sender's Account Number:</label> <input
					type="number" class="form-control" name="senderAccountNo">
			</div>
			<div class="form-group">
				<label for="to_acc_no">Enter Receiver's Account Number:</label> <input
					type="number" class="form-control" name="receiverAccountNo">
			</div>
			<div class="form-group">
				<label for="amt">Amount to transfer:</label> <input type="number"
					class="form-control" name="amount">
			</div>
			<button type="submit" class="btn btn-primary" onclick="boolean">Transfer</button>
		</form>
	</div>
	<div class="footer">
		<p style="color: red; text-align: center">copyright@2018. ICICI
			pvt ltd.</p>
	</div>


</body>
</html>