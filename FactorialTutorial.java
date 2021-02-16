import java.util.*;

public class FactorialTutorial {

    // Used if the user wishes to exit the program.
    private static final Set<String> EXIT_COMMANDS;

    // Assign the values of EXIT_COMMANDS (initialisation block)
    static {
        final SortedSet<String> exitCommands = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        exitCommands.addAll(Arrays.asList("exit", "quit"));
        EXIT_COMMANDS = Collections.unmodifiableSortedSet(exitCommands);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        String rawInput;
        int[] digits;

        while (!quit) {
            long digitFactorial;
            int sumFactorial = 0;
            int digit;

            System.out.print("Please enter a number to calculate its factorial, or if not "
                    + "possible; determine if it's a factorian: ");
            // Take in the first line (separated by \n) as a String.
            rawInput = input.nextLine();

            // If the user wishes to leave the program.
            if (EXIT_COMMANDS.contains(rawInput)) {
                quit = true;
            }

            // functionality here
            if (!quit) {
                try {
                    String[] digitsString = rawInput.split("");
                    digits = parseIntegerArray(digitsString);

                    StringBuilder builderLHS = new StringBuilder();
                    StringBuilder builderRHS = new StringBuilder();

                    for (int d : Arrays.copyOf(digits, digits.length-1)) {
                        System.out.println(rawInput);
                        System.out.println(Arrays.toString(digits));
                        System.out.println(d);
                        builderLHS.append(d).append("! + ");
                        builderRHS.append(computeFactorial(d)).append(" + ");

                        digitFactorial = computeFactorial(d);
                        sumFactorial += digitFactorial;
                    }

                    digit = digits[digits.length-1];
                    System.out.println(digit);
                    builderLHS.append(digit).append("!");
                    builderRHS.append(computeFactorial(digit));
                    sumFactorial += computeFactorial(digit);

                    System.out.printf("%s = %s = %d%n", builderLHS.toString(), builderRHS.toString(),
                            sumFactorial);
                    System.out.printf("%s %s a factorian.%n", rawInput,
                            (rawInput.equals(sumFactorial + "")) ? "is" : "isn't");
                } catch (NumberFormatException ok) {
                    System.out.println("You did not enter a number.");
                } catch (ArithmeticException | StackOverflowError ok) {
                    System.out.println("You provided an integer which would overflow the "
                            + "factorial computation method.");
                }
            }
        }
        input.close();
    }

    /** 
     * Compute n! 
     * @param n The Number you wish to calculate the factorial of
     * @return n factorial.
     * @see FactorialTutorial#main(String[]) 
     * */
    private static long computeFactorial(int n) {
        if (n > 20) throw new ArithmeticException("Maximum Integer exceeded.");
        return (n == 0) ? 1 :  (n * computeFactorial(n - 1));
    }

    /**
     * Convert a String[] into an int[] via a Stream.
     *
     * @param args The String[] you wish to convert.
     * @return int[] representation of the String[] you provided.
     * @throws NumberFormatException when the program does not successfully convert the entire
     *         array.
     * @see FactorialTutorial#main(String[])
     */
    private static int[] parseIntegerArray(String[] args) throws NumberFormatException {
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }

}
