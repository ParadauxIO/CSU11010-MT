import java.util.*;

public class GradeComputation {

    // Used if the user wishes to exit the program.
    private static final Set<String> EXIT_COMMANDS;
    private static final String OUTPUT_TEMPLATE = "Result = %s with an overall mark of %.0f%%.%n";
    private static final String FAILURE_MESSAGE = "   %s credits were failed.%n";
    public static final String[] MODULE_CODES = { "CSU11001", "CSU11010", "CSU11013", "CSU11021", "CSU11022", "CSU11026", "CSU11031",
            "CSU11081", "CSU12002", "STU11002" };
    public static final int[] MODULE_CREDITS = { 5, 10, 5, 5, 5, 10, 5, 5, 5, 5 };

    // Assign the values of EXIT_COMMANDS (initialisation block)
    static {
        final SortedSet<String> exitCommands = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        exitCommands.addAll(Arrays.asList("exit", "quit"));
        EXIT_COMMANDS = Collections.unmodifiableSortedSet(exitCommands);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the first year grade assessor.");

        // New array which is equal in size to that of the amount of modules.
        double[] marks = new double[MODULE_CODES.length];

        // Used to parse input from the user.
        Scanner scanner = new Scanner(System.in);

        // Take it as empty string to avoid initialisation errors/
        String rawInput = "";

        // We haven't quit yet!
        boolean quit = false;

        while (!quit) {

            for (int i = 0; i < MODULE_CODES.length; i++) {
                if (!quit) {
                    System.out.printf("Enter the student mark for %s (or enter quit): ", MODULE_CODES[i]);
                    rawInput = scanner.next();

                    if (EXIT_COMMANDS.contains(rawInput)) {
                        quit = true;
                    }

                    if (!quit) {
                        try {
                            marks[i] = Double.parseDouble(rawInput);
                        } catch (NumberFormatException exception) {
                            System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
                            // Try and get the mark for that module again
                            i--;
                        }
                    }
                }
            }

            if (!quit) {
                String grade = determineOverallGrade(marks);
                System.out.printf(OUTPUT_TEMPLATE, grade, weightedAverageMark(marks));
                if (grade.equals("FAIL")) {
                    System.out.printf(FAILURE_MESSAGE, creditsBelowSpecifiedMark(marks, 40));
                }
            }
        }

    }

    public static int creditsBelowSpecifiedMark(double[] marks, int specifiedMinimumMark) {
        int countBelowMinimum = 0;
        for (int i = 0; i < marks.length; i++) {
            if (Math.round(marks[i]) < specifiedMinimumMark) {
                countBelowMinimum += MODULE_CREDITS[i];
            }
        }

        return countBelowMinimum;
    }

    public static double weightedAverageMark(double[] marks) {
        double[] marksCopy = marks.clone();
        int totalAchievedMark = 0;

        for (int i=0; i < marks.length; i++) {
            if (MODULE_CREDITS[i] == 10) {
                marksCopy[i] *= 2;
            }
            totalAchievedMark += marksCopy[i];
        }

        return (double) totalAchievedMark / get5CreditValue(MODULE_CREDITS);
    }

    public static String determineOverallGrade( double[] marks ) {
        String determinedGrade = "";
        double averageGrade = Math.round(weightedAverageMark(marks));

        if (averageGrade >= 70) {
            determinedGrade = "I";
        } else if (averageGrade >= 60) {
            determinedGrade = "II.1";
        } else if (averageGrade >= 50) {
            determinedGrade = "II.2";
        } else if (averageGrade >= 40) {
            determinedGrade = "III";
        }

        if (hasFailed(marks) || creditsBelowSpecifiedMark(marks, 40) >= 10) {
            determinedGrade = "FAIL";
        }

        return determinedGrade;
    }

    private static int get5CreditValue(int[] credits) {
        int value = 0;

        for (double credit : credits) {
            value += credit == 10 ? 2 : 1;
        }

        return value;
    }

    private static boolean hasFailed(double[] marks) {
        boolean hasFailed = false;
        for (double mark : marks) {
            if (mark < 35) {
                hasFailed = true;
            }
        }

        return hasFailed;
    }

}
