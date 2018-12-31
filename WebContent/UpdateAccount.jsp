<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Update form</title>
    <link rel="stylesheet" href="C:\HTML_Assingments\Banking_application\footer.css">
<title>UpdateAccount</title>
</head>
<body>
<header>       <nav class="navbar navbar-inverse" style="background-color: orange;border-block-end-color: red">
                        <div class="container-fluid">
                          <div class="navbar-header">
                                <h1 style="color: red"><i>ICICI Bank</i></h1>
                          </div>
                          <ul class="nav navbar-nav" style="float: right;" >
                            <li class="active" style="color: red"><a href="C:\HTML_Assingments\Banking_application\home.html">Home</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\AddNewAccount.html" style="color: red">Add Account</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\searchaccount.html" style="color: red">Search Account</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\ViewAllCustomers.html" style="color: red">View All Customers</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\UpdateCustomerForm.html" style="color: red">Update Customer form</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\WithdrawForm.html" style="color: red">Withdraw Form</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\DepositForm.html" style="color: red">Deposit Form</a></li>
                            <li><a href="C:\HTML_Assingments\Banking_application\FundTransfer.html" style="color: red">Fund Transfer</a></li>
                          </ul>
                        </div>
                      </nav>
               </header>
                <div class="container">
                <h2>Update Details</h2>
             <form action="updatedAccount.mm">
              <div class="form-group">
                <label for="cust_id">Account Number:</label>
                <input type="text" class="form-control" placeholder="${requestScope.account.bankAccount.accountNumber}" readonly="readonly" >
              </div>
              <div class="form-group">
                <label for="name">Holder Name:</label>
                <input type="text" class="form-control" name="accountHolderName" placeholder="${requestScope.account.bankAccount.accountHolderName}">
              </div>
              <div class="form-group">
                <label for="AccountBalance">Account Balance:</label>
                <input type="number" name="accountBalance" class="form-control" placeholder="${requestScope.account.bankAccount.accountBalance}">
              </div>
              <div class="form-group">
                  <label for="Salary">Salary:</label>
                  <input type="text" class="form-control" name="SalaryState"  placeholder="${requestScope.account.salary==true?"Yes":"No"}">
              
              </div>
              <div class="form-group">
                  <label for="Odlimit">Over Draft Limit:</label>
                  <input type="text" class="form-control" name="odlimit" placeholder="N/A">
              </div>
              <div class="form-group">
                  <label for="type">Type</label>
                  <input type="text" class="form-control" palceHolder="SAVINGS" >
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
             </form>
             </div>
             <div class="footer">
                    <p style="color: red;text-align: center">copyright@2018. ICICI pvt ltd.</p>
                  </div>

</body>
</html>