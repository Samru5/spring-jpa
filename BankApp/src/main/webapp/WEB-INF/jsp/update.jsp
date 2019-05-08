<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>Update Account</h3>
	</center>
	<div class="container p-2 bg-dark text-success w-50">

		<form method="post" action="/Spring-MVC-BankApp/app/bankapp/updatedetails">
			<label for="account id">Account ID:</label> <input type="text"
				class="form-control" id="accountid" name="accountId"
				placeholder="Please enter your account id here" value="${accounts.accountId}" required readonly><br>
				
				
			<label for="customer name">Customer Name:</label> <input type="text"
				class="form-control" id="name" name="customerName"
				placeholder="Please enter your name here"  value="${accounts.accountHolderName}" required><br>

			<label for="account type">Account Type:</label> <select name="type"  value="${accounts.accountType}" >
				<option value="">Select</option>

				<option value="Saving">Saving Account</option>
				<option value="Current">Current Account</option>
			</select> <br> <br> 
			
			<label for="account balance">Account
				Balance:</label> <input type="text" class="form-control" id="balance"
				name="balance" placeholder="Please enter your balance here"   value="${accounts.accountBalance}" required
				readonly><br>


			<button type="submit" class="btn btn-primary btn-block">Update</button>

		</form>
</body>
</html>