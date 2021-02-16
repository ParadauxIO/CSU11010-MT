import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanRepaymentCalculator {

    // Just in case earth's orbit changes drastically
    final static int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {

        // User's inputs

        int loanTermYears;
        double principalAmount, annualPercentageRate, monthlyPercentageRate;

        // Calculated fields
        double commonArgument, monthlyRepayment;

        // Used to parse the user's input via the console (i.e System.in)
        Scanner scanner = new Scanner(System.in);

        try {
            // Let's get the input from the user, using STDIN via a Scanner.
            System.out.print("Enter loan amount? ");
            principalAmount = scanner.nextDouble();

            System.out.print("Enter annual interest rate (e.g. 0.04)? ");
            annualPercentageRate = scanner.nextDouble();

            System.out.print("Enter the term of the loan in years? ");
            loanTermYears = scanner.nextInt();

            scanner.close();
        } catch (InputMismatchException exception) {
            // Let's make sure the user didn't mess us up! Never trust those damn users!
            System.out.println("Invalid input captured. Please ensure you are entering a decimal value matching the pattern: float");
            return;
        }

        // Convert Annual to monthly percentage rate
        monthlyPercentageRate = annualPercentageRate / MONTHS_IN_YEAR;

        // May as well take out this common argument, as this operation is common between both the numerator and the denominator
        commonArgument = Math.pow(1 + monthlyPercentageRate, loanTermYears * MONTHS_IN_YEAR);

        // Implementing the Amortisation formula in Java.
        monthlyRepayment = principalAmount * ((monthlyPercentageRate * commonArgument) / (commonArgument - 1));

        // Web-CAT is very strict as to how you format the message, annoyingly. I'd normally use #.## but 0.00 is necessary.
        DecimalFormat twoDecimalPlaceFormat = new DecimalFormat("0.00");

        // Output this very specifically formatted message.
        System.out.println("The monthly repayment for a " + loanTermYears + " year loan of " + twoDecimalPlaceFormat.format(principalAmount)
                + " at an annual interest rate of " + twoDecimalPlaceFormat.format(annualPercentageRate) + " would be "
                + twoDecimalPlaceFormat.format(monthlyRepayment));

        // Could use printf as well, I prefer DecimalFormat as it's much more readable and serves a greater purpose.
        // If I was using a proper logger, I'd use the injection method, i.e SLF4J Logger.log("%s", str);
        // Here's the printf method, which is the exact same.
        // System.out.printf("The monthly repayment for a %d year loan of %.2f at an annual "
        //           + "interest rate of %.2f would be %.2f", loanTermYears, principalAmount, annualPercentageRate, monthlyRepayment);

    }
}