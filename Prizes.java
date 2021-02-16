import java.util.Scanner;

/**
 * A program which repeatedly takes the place number of a participant in a competition and
 * indicates what prize they should receive
 * <p>
 * This might slightly be over-engineered for the purpose of the assignment, but I had fun unit
 * testing it on my own
 *
 * @author Rían Errity [20333410]
 * @version Submission 1
 * @since 20/11/2020
 */
public class Prizes {

    /**
     * This is the entry point for the program.
     *
     * @param args Command line arguments are not used for the purposes of this program.
     */
    public static void main(String[] args) {

        System.out.println("This program tells competition participants what prize they have won.");
        Scanner inputStream = new Scanner(System.in);

        // Stores whether the user has requested to leave the program.
        boolean quit = false;

        // Taken from the user and parsed into an integer.
        String input = "0";
        int userPlacement;


        while (!quit) {
            System.out.print("Enter your place number (or type 'exit'): ");

            // Parses whether the user wishes to exit the program.
            if (inputStream.hasNext()) {
                input = inputStream.next();
                if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) quit = true;
            }

            // Assuming they did not exit the program.
            if (!quit) {

                // Parse the input as an int.
                try {
                    userPlacement = Integer.parseInt(input);
                } catch (NumberFormatException exception) {
                    System.out.println("That's not a valid integer.");
                    return;
                }

                // Parse the placement and spit out their placement and allocated prize.
                try {
                    System.out.printf("You came in %d%s place and hence won %s.%n", userPlacement
                            , getPlacementSuffix(userPlacement),
                            getUserAllocatedPrize(userPlacement));
                } catch (InvalidPlacementException | NoPrizeException exception) {
                    System.out.println("Sorry.  You did not win a prize.");
                }
            }
        }
    }

    /**
     * A method which determines the appropriate string suffix for a given integer.
     * If that integer is 0 or negative, the program will return empty string, due to the
     * lack of access to a @Nullable annotation.
     *
     * @param userPlacement The (integer) placement you wish to convert i.e 1, 2, 3
     * @return String which contains the suffix associated with the particular integer
     * @throws InvalidPlacementException When an invalid userPlacement is provided.
     */
    public static String getPlacementSuffix(int userPlacement) throws InvalidPlacementException {
        if (userPlacement <= 0)
            throw new InvalidPlacementException("Invalid user placement provided.");

        // Get's the least significant digit
        switch (userPlacement % 10) {
            case 1: {
                return "st";
            }

            case 2: {
                return "nd";
            }

            case 3: {
                return "rd";
            }

            default: {
                return "th";
            }
        }
    }

    /**
     * A method which determines the appropriate prize allocated to the supplied placement
     * in the competition. If they did not win a prize the method will return empty string, due
     * to the lack of access to a @Nullable annotation
     *
     * @param userPlacement The user's placement in the competition, which determines their prize.
     * @return String which contains the allocated prize as per the program spec.
     * @throws InvalidPlacementException When an invalid userPlacement is provided.
     * @throws NoPrizeException          When the provided userPlacement does not map to a valid
     *                                   prize.
     */
    public static String getUserAllocatedPrize(int userPlacement) throws InvalidPlacementException, NoPrizeException {
        if (userPlacement <= 0)
            throw new InvalidPlacementException("Invalid user placement provided.");

        switch (userPlacement) {
            case 1: {
                return "two theatre tickets + drinks during the interval + dinner before the show";
            }

            case 2: {
                return "two theatre tickets + drinks during the interval";
            }

            case 3: {
                return "two theatre tickets";
            }

            default: {
                if (userPlacement == 4 || userPlacement == 5) {
                    return "a 10 Euro book token";
                } else if (userPlacement <= 10) {
                    return "a 5 Euro book token";
                }

                throw new NoPrizeException("User did not win a prize.");

            }
        }
    }

    /**
     * This exception is thrown when an invalid integer userPlacement is provided to a method
     * which demands it.
     */
    static class InvalidPlacementException extends Exception {
        InvalidPlacementException(String message) {
            super(message);
        }
    }

    /**
     * This exception is thrown when no appropriate prize was found for the particular
     * userPlacement.
     */
    static class NoPrizeException extends Exception {
        NoPrizeException(String message) {
            super(message);
        }
    }
}
