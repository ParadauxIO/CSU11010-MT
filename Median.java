import java.util.*;

/**
 * Using a while or do-while loop, THis is a program
 * called Median which keeps taking in whole
 * numbers from a user until the user type quit or exit
 * and calculates the median of the entered numbers up to that point
 * as well as the average of the last three values entered.
 * <p>
 * @author Rían Errity
 * @since 12/12/2020
 * @implNote I would have personally used an ArrayList here, rather than extending an array, but
 * apparently that's bad practice in this course.
 */
public class Median {

    // Used if the user wishes to exit the program.
    private static final Set<String> EXIT_COMMANDS;
    private static final String OUTPUT_TEMPLATE = "The median of %s is %.1f and the rolling "
            + "average of the last 3 values is %.1f.%n";

    // Assign the values of EXIT_COMMANDS (initialisation block)
    static {
        final SortedSet<String> exitCommands = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        exitCommands.addAll(Arrays.asList("exit", "quit"));
        EXIT_COMMANDS = Collections.unmodifiableSortedSet(exitCommands);
    }

    /**
     * Main method body. This is the static reference to my program.
     * @param args Unused for the purposes of this assignment.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        double[] numbers = {};
        String rawInput;

        System.out.println("Welcome to the median & rolling average system.");

        while (!quit) {
            System.out.print("Enter a number (or enter quit): ");

            // Take in the first line (separated by \n) as a String.
            rawInput = scanner.nextLine();

            // If the user wishes to leave the program.
            if (EXIT_COMMANDS.contains(rawInput)) {
                quit = true;
            }

            if (!quit) {
                try {

                    // Rather than using a list, extend the numbers array to include the next
                    // input from the user.
                    numbers = extendDoubleArray(numbers, Double.parseDouble(rawInput));

                    numbers.clone();

                    // Print out a formatted message containing all of the numbers they have
                    // entered thus far and compute the median / rolling average.
                    System.out.printf(OUTPUT_TEMPLATE, convertToString(numbers),
                            computeMedian(numbers), computeRollingAverage(numbers, 3));
                } catch (NumberFormatException exception) {
                    System.out.println("Error - Enter any real number or quit.");
                }
            }

        }

    }

    /**
     * Calculates the median of all the elements within the provided Array. If provided an empty
     * array or null, 0 will be returned.
     * @param values The Array you wish to use to calculate the median.
     * @return The Median of all the elements in the "values" array.
     * */
    public static double computeMedian(double[] values) {
        if (values == null || values.length == 0) {
            return 0d;
        }

        double[] sortedArray = createSortedArray(values);
        return (values.length % 2 == 0) ?
                (sortedArray[values.length / 2] + sortedArray[values.length/ 2 - 1]) / 2 :
                sortedArray[values.length / 2];
    }

    /**
     * Sorts an array into ascending numerical value using Arrays#sort, returning a cloned array.
     * Returns null if values is null.
     * @param values The array you wish to sort
     * @return A new array which has been sorted.
     * */
    public static double[] createSortedArray(double[] values) {
        if (values == null) {
            return null;
        }

        double[] sortedArray = values.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    /**
     * Calculates the average of the last x elements in an unsorted array.
     * <p>
     * Provided {1.0, 2.0, 3.0, 4.0, 5.0} the method will return (3.0+4.0+5.0) / 3.
     * If the lastValues provided is greater than or equal to the size of the provided array,
     * the program will simply return the average of the entire array.
     * @param values The Array you wish to calculate the last x element's average.
     * @param lastValues How many elements you wish to consider for the last x element's average.
     * @return The average of the x last elements.
     * @implNote Returns 0 if lastValues is also 0.
     * */
    public static double computeRollingAverage(double[] values, int lastValues) {
        if (lastValues == 0) {
            return 0;
        }

        double lastValuesSum = 0;
        int length = 0;
        int i = (values.length > lastValues) ? values.length - lastValues : 0;
        for (; i < values.length ; i++, length++) {
            lastValuesSum += values[i];
        }
        return lastValuesSum / length;
    }

    /**
     * This is a play on Arrays#toString(double[]) which uses "{}" rather than "[]" and rounds
     * each individual element to the nearest decimal place.
     * @param values The values you wish to convert to a string.
     * @return A "Stringified" version of the provided array's values, rounded to one decimal place.
     * */
    public static String convertToString(double[] values) {
        StringBuilder builder = new StringBuilder();

        if (values == null || values.length == 0) {
            return "{ }";
        }

        int lastElement = values.length - 1;

        builder.append("{ ");
        for (int i = 0; ; i++) {
            builder.append(String.format("%.1f", values[i]));

            if (i == lastElement) {
                return builder.append(" }").toString();
            }

            builder.append(", ");
        }
    }

    /**
     * Clones the provided array and extends it by one element, filling newElement in that place.
     * @param values The Provided Array
     * @param newElement The Element you wish you add to the extended array.
     * @return An array which has had newElement added to it.
     * */
    private static double[] extendDoubleArray(double[] values, double newElement) {
        double[] valuesExtendCopy = new double[values.length + 1];
        System.arraycopy(values, 0, valuesExtendCopy, 0, values.length);
        valuesExtendCopy[valuesExtendCopy.length - 1] = newElement;
        return valuesExtendCopy;
    }

}
