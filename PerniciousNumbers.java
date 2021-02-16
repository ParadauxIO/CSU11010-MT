import java.util.Scanner;

public class PerniciousNumbers {

    /**
     * Application Entry Point.
     * @param args Unused.
     * */
    public static void main(String[] args) {
        int upperLimit;

        // Used to parse the STDIN stream.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum number you want to consider: ");

        if (input.hasNextInt()) {
            upperLimit = input.nextInt();
        } else {
            // Bare bones error message.
            System.out.println("You did not enter a valid integer.");
            return;
        }

        for (int count = 3; count <= upperLimit; count++) {
            if (isPernicious(count) && isPrime(countBinaryOnes(count))) {
                // Print formatted output string.
                System.out.printf("%s is a pernicious number as it contains %s ones in it's "
                                + "binary "
                                + "representation (%s)%n", count, countBinaryOnes(count),
                        getBinaryString(count));
            }
        }

        // close the scanner.
        input.close();
    }

    /**
     * Converts a given integer value to its binary number representation, in String form.
     * @implNote Returns a binary number, not a two's compliment.
     * @param value The value you wish to receive the binary representation for.
     * @return String which contains the binary representation of the passed value.
     * */
    public static String getBinaryString(int value) {
        return ((value < 0) ? "-" : "") + Integer.toBinaryString(Math.abs(value));
    }

    /**
     * Determines if a given value is Pernicious, i.e If the amount of 1s is prime.
     * @param value The value you wish to determine if it is pernicious
     * @return boolean value as to whether it is pernicious or not.
     * */
    public static boolean isPernicious(int value) {
        return isPrime(countBinaryOnes(value));
    }

    /**
     * Using Integer#bitCount which uses Bitwise math to calculate the amount of '1's
     * @param value The Integer you wish to get the amount of ones in its binary representation.
     * @return The amount of ones in the binary representation of a given number.
     * @see PerniciousNumbers#getBinaryString(int)
     * */
    public static int countBinaryOnes(int value) {
        return Integer.bitCount(Math.abs(value));
    }

    /**
     * Simplified isPrime check by checking if every integer up to the square root + 1 is divisible.
     * @param value The Integer you wish to determine if it is prime.
     * @return boolean value as to whether it is prime or not.
     * */
    public static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(value) + 1; // Truncated Integer is fine here
        for (int i = 2; i < sqrt; i++) {
            if (value % i == 0) {
                return false; // Found a divisor
            }
        }
        return true; // If no divisors are found.
    }

    /**
     * Determines if the provided number is positive.
     * @param value The number to check
     * @return If the value is positive.
     * */
    public static boolean isPositive(int value) {
        return value >= 0;
    }

}
