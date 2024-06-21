Banking System Application

This Java application simulates a basic banking system, allowing users to perform various banking operations such as creating accounts, depositing funds, withdrawing funds, and checking balances. The application uses JDBC (Java Database Connectivity) to interact with a MySQL database.
Features

    Account Management:
        Create new bank accounts.
        View account details.
        Delete bank accounts.
    Transactions:
        Deposit funds into an account.
        Withdraw funds from an account.
        Check account balance.
    Database Connectivity: Connects to a MySQL database using JDBC.

Prerequisites

    Java Development Kit (JDK): Ensure JDK is installed.
    Database: MySQL server running and accessible.
    JDBC Driver: MySQL Connector/J (JDBC driver for MySQL).

Setup

    Clone the repository:

    bash

git clone https://github.com/your-username/banking-system.git
cd banking-system

Database Setup:

    Create a MySQL database and table using the provided schema:

sql

CREATE DATABASE banking_system;
USE banking_system;
CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    account_holder VARCHAR(100),
    account_balance DOUBLE
);

Configure Database Credentials:

    Update the BankingSystemApp.java file with your MySQL database credentials:

java

private static final String URL = "jdbc:mysql://localhost:3306/banking_system";
private static final String USER = "your-username";
private static final String PASSWORD = "your-password";

Compile and Run the Application:

bash

    javac -cp ".;mysql-connector-java-8.0.29.jar" BankingSystemApp.java
    java -cp ".;mysql-connector-java-8.0.29.jar" BankingSystemApp

Usage

    Create Account: Add a new account to the database.
    View Accounts: Retrieve and display all accounts from the database.
    Deposit Funds: Add funds to an existing account.
    Withdraw Funds: Withdraw funds from an existing account.
    Check Balance: Display the balance of an account.
    Delete Account: Remove an account from the database.

Contributing

Contributions are welcome! Please fork the repository and submit a pull request.
