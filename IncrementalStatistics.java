import java.util.Scanner;

/**
 * Using a while or do-while loop, THis is a program
 * called IncrementalStatistics which keeps taking in whole
 * numbers from a user until the user type quit or exit
 * and calculates the average/variance of the entered numbers
 * and feeds it back to them every time.
 *
 * I have added javadocs for the purposes of checkstyle
 *
 * @author Rían Errity
 * @version 1.0
 * @since 12/11/2020
 */
public class IncrementalStatistics {

    /**
     * Main method body. This is the static reference to my program.
     * @param args Unused for the purposes of this assignment.
     */
    public static void main(String[] args) {

        // For the math, we need these variables to be declared in advance.
        double populationSum = 0;
        double populationSize = 0;
        double populationVariance = 0;
        double populationMean = 0;
        double inputValue;
        boolean quit = false;

        System.out.println("This program computes the average and variance of all numbers entered.");
        Scanner scanner = new Scanner(System.in);

        // The first iteration has a different user prompt
        System.out.print("Enter a number (or type 'exit'): ");

        do {
            String input = "0";

            // Rather than using break
            if (scanner.hasNext()) {
                input = scanner.next();
                if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit"))
                    quit = true;
            }

            if (!quit) {
                try {
                    inputValue = Double.parseDouble(input);
                    // Rather than using the complicated average formula, I just keep a copy of the sum of all of the numbers, and the number of numbers

                    // Which is needed anyway
                    populationSum += inputValue;
                    populationSize++;
                    populationVariance = ((populationSize - 1)
                            * populationVariance
                            + (inputValue - populationMean)
                            * (inputValue - (populationSum / populationSize)))
                            / populationSize;

                    populationMean = populationSum / populationSize;

                    System.out.printf("So far the average is %.1f and the variance is %.1f%n", populationMean, populationVariance);
                } catch (NumberFormatException exception) {
                    System.out.println("Error:  You must enter a real number (e.g. 12.5)");
                }

                // We don't want the first user prompt and this to be sent back-back so we have this at the bottom.
                System.out.print("Enter another number (or type 'exit'): ");
            }

        } while (!quit);

        scanner.close();
        System.out.println("Goodbye.");

    }
}
