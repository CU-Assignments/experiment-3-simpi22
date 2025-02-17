# Experiment-3

Chapter-3 (Exception Handing) (Experiment 3)	Introduction to Exceptions. Difference between error and exception. Use of try, catch and throw. Difference between throw and throws. Types of Exceptions, Exception handling in Java	Design Java programs showcasing exception handling through square root calculations, an ATM withdrawal system, and a university enrollment system with custom exceptions.


Easy Level
Problem Statement: Write a Java program to calculate the square root of a number entered by the user. Use try-catch to handle invalid inputs (e.g., negative numbers or non-numeric values).
Input Example:
Enter a number: -16
Output Example:
Error: Cannot calculate the square root of a negative number.
________________________________________
		Medium Level
Problem Statement: Write a Java program to simulate an ATM withdrawal system. The program should:

Ask the user to enter their PIN.
Allow withdrawal if the PIN is correct and the balance is sufficient.
Throw exceptions for invalid PIN or insufficient balance.
Ensure the system always shows the remaining balance, even if an exception occurs.

Input Example:
Enter PIN: 1234
Withdraw Amount: 5000
Output Example:
Error: Insufficient balance. Current Balance: 3000
		Hard Level
Problem Statement: Create a Java program for a university enrollment system with exception handling. The program should:

Allow students to enroll in courses.
Throw a CourseFullException if the maximum enrollment limit is reached.
Throw a PrerequisiteNotMetException if the student hasn’t completed prerequisite courses.

Input Example:
Enroll in Course: Advanced Java
Prerequisite: Core Java
Status: Prerequisite not completed
Output Example:
Error: PrerequisiteNotMetException - Complete Core Java before enrolling in Advanced Java.
