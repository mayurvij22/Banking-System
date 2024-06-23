Creating a simple banking application involves both backend (Java) and frontend (HTML) components. The backend will handle the business logic and data management, while the frontend will provide the user interface for interaction. Below is a basic implementation of a banking application with the following features:

    Account creation.
    Balance check.
    Deposit.
    Withdrawal.
  
    ## Features

- **Account Creation:** Users can create a new bank account with an initial balance.
- **Balance Check:** Users can check the balance of their account.
- **Deposit:** Users can deposit funds into their account.
- **Withdrawal:** Users can withdraw funds from their account.

## Technologies Used

- **Backend:** Java
- **Frontend:** HTML
- **Servlets:** Java Servlets for handling HTTP requests and responses

1. **Access the application:**

    Open a web browser and navigate to `http://localhost:8080/simple-banking-application`.

2. **Create an Account:**

    - Fill out the form with your account details (account number, account holder name, and initial balance).
    - Submit the form to create the account.

3. **Check Balance:**

    - Enter your account number and click on the "Check Balance" button.

4. **Deposit Funds:**

    - Enter your account number and the amount to deposit.
    - Click on the "Deposit" button to add funds to your account.

5. **Withdraw Funds:**

    - Enter your account number and the amount to withdraw.
    - Click on the "Withdraw" button to remove funds from your account.

### File Structure

```plaintext
simple-banking-application/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── BankAccount.java
│   │   │   ├── BankService.java
│   │   │   └── BankServlet.java
│   │   └── webapp/
│   │       ├── index.html
│   │       └── styles.css
│
├── README.md
└── pom.xml
