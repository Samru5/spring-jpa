<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.addr {
	display: inline-block;
}

.navi a {
	color: tomato;
	padding-left: 15px
}

.navi {
	background-color: black;
	padding: 20px
}
</style>
<title>Account Details</title>
<style>
.navi a {
	color: tomato;
	padding-left: 15px
}

.navi {
	background-color: black;
	padding: 20px
}
</style>
</head>
<div>
	<nav class="navi">
		<a href="/Spring-MVC-BankApp/app/bankapp/">Home</a> 

                <a href="/Spring-MVC-BankApp/app/bankapp/fornew">New Account</a> 
               
                <a href="/Spring-MVC-BankApp/app/bankapp/forwithdraw">Withdraw</a> 
               
                <a href="/Spring-MVC-BankApp/app/bankapp/fordeposit">Deposit</a> 
              
                <a href="/Spring-MVC-BankApp/app/bankapp/forfundtransfer">Fund Transfer</a>
                   
                    <a href="/Spring-MVC-BankApp/app/bankapp/forsearch">Search Account</a>
                
                <a href="/Spring-MVC-BankApp/app/bankapp/forcheck">Check Balance</a>
               
                <a href="/Spring-MVC-BankApp/app/bankapp/findall">Display All BankAccount Details</a>
               
                <a href="/Spring-MVC-BankApp/app/bankapp/fordelete">Delete Account</a>
        
                <a href="/Spring-MVC-BankApp/app/bankapp/forupdate">Update BankAccount Details</a>
        
	</nav>
</div>
<br>
<body>

	<center>
		<h3>Account Details</h3>
	</center>

	<div class="container">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>BankAccount ID</th>
					<th>Customer Name</th>
					<th>Account Type</th>
					<th>Account balance</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${accounts}">
					<tr>

						<td>${account.accountId}</td>
						<td>${account.accountHolderName}</td>
						<td>${account.accountType}</td>
						<td>${account.accountBalance}</td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

