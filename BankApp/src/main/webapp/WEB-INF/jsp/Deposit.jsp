<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
            .navi a{color:tomato;padding-left: 15px}
       .navi{background-color:black;padding:20px}
        </style>
</head>
    <title>Deposit</title>
</head>
<body>
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
              <center><h3>Deposit</h3></center>

    <div class="container p-2 bg-dark text-success w-50" >
    <div class="form-group">
        <form action="/Spring-MVC-BankApp/app/bankapp/deposit" method="post">
        <label for="account id">Account ID:</label>
        <input type="text" class="form-control" id="accountid" name="accountId" placeholder="Please enter your account id here" required><br>

    </div>
    <div class="form-group">
        
        <label for="amount">Amount:</label>
        <input type="text" class="form-control" id="amount" name="amount" placeholder="Enter the amount" required><br><br>
        <button type="submit" class="btn btn-primary btn-block">Deposit</button>
    </form>
    </div>
</div>
</body>
</html>