To run the program Compile both file and execute the Driver file
for example : 
javac AtmMachine.java
javac AtmMachineDriver.java
java AtmMachineDriver

Mini Project: ATM Simulation in Core Java
Before we delve into the logic, we need to perform some initialization steps:

1. Initialize the amount present in the ATM machine.
2. Initialize the PIN number for Citibank users.
3. Initialize the amount present in the Citibank user's account.
4. Initialize the PIN number for other bank users.
5. Initialize the amount present in other bank user's account.
Once these five steps are completed, the main logic will begin.

We initialize this in the console to perform various scenarios like "insufficient balance", "transaction limit exceeded", "withdrawal limit exceeded", "ATM has no money", etc.

In this program, we have two types of bank users: Citibank users and other bank users.

We need to specify whether the user is a Citibank user or another user. In real-time scenarios, if we insert the card, it will automatically determine the user, but in our case, it's not like that.

The logic of the program for Citibank users is as follows: they can withdraw only $20,000 per day and only 3 transactions per day. If the user tries to withdraw more than $20,000 or perform a 4th transaction, they will receive proper information.

For example:

If they try to withdraw $21,000, they will receive "Your transaction exceeds the limit."
To check the transaction limit, first withdraw three times. If we attempt a 4th withdrawal, we'll receive "Your transaction limit is exceeded." To test this without terminating the command prompt, change the date on our system. Then, attempt transactions, and it will allow us to perform three transactions on the "next day".

This logic is applicable to Citibank users. For other bank users, there is no withdrawal or transaction limit.
