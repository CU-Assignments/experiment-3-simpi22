import java.util.Scanner;
class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class ATMSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = scanner.nextInt();

            if (enteredPIN != CORRECT_PIN) {
                throw new InvalidPINException("Error: Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();

            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }

            balance -= withdrawAmount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}