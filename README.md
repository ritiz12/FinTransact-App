Project Name: Fin Transact 

Overview:
Fin Transact is an innovative online payment application designed to simplify financial transactions and empower users with secure, convenient, and efficient money management capabilities. With a user-centric approach and cutting-edge technology stack, Fin Transact offers a comprehensive suite of features to meet the diverse needs of modern consumers and businesses alike.

Key Features:
Seamless User Experience
Secure Authentication
Comprehensive Account Management
Fast and Reliable Transactions
Budgeting and Planning Tools
Real-time Notifications
Multi-platform Accessibility


Technologies Used:
Spring Boot
Spring Security
JSON Web Tokens (JWT)
RESTful APIs
Database Integration

## Project Description

### AmountController
- Handles account balance operations like adding money, subtracting money, and checking balance.
- Manages transactions, including transferring money and retrieving transaction history.

### AuthenticationController
- Responsible for user authentication.
- Generates JWT tokens upon successful login.

### InformationController
- Manages user information.
- Handles registration, updating user details, and deactivating accounts.

## Technologies Used
- Spring Boot
- JWT (JSON Web Tokens)
- Spring Security

## How to Run
- Clone the repository.
- Configure database properties in `application.properties`.
- Build and run the application using Maven or your preferred IDE.

## Endpoints
- **AmountController**
  - PUT /account/{accountNumber}/creditMoney
  - PUT /account/{accountNumber}/debitMoney
  - GET /account/{accountNumber}/checkBalance
  - POST /account/{accountNumber}/transferMoney
  - GET /account/transactionHistory/{accountNumber}
  - GET /account/recentTransactionHistory/{accountNumber}
  - GET /account/dateWiseTransaction/{accountNumber}
    
- **AuthenticationController**
  - POST /auth/login
  - POST /auth/createUser
 
- **InformationController**
  - POST /userDetail/registerUser
  - GET /userDetail/userInformation/{accountNumber}
  - PUT /userDetail/updateUserInformation/{accountNumber}
  - PUT /userDetail/deactivateAccount/{accountNumber}
  - DELETE /userDetail/deleteAccount/{accountNumber}
