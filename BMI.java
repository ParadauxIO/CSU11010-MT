import java.util.InputMismatchException;
import java.util.Scanner;

public class BMI {

    /**
     * Calculate the user's BMI via information taken from STDIN using {@link Scanner}
     * @param args Unused for the purposes of this program.
     * */
    public static void main(String[] args) {
        double userWeight, userHeight, userBMI;

        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your weight in kg? ");

        try {
            userWeight = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            System.out.print("The weight retrieved does not match the pattern for the primitive int.");
            return;
        }

        System.out.print("What is your height in metres?");

        try {
            userHeight = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            System.out.print("The height retrieved does not match the pattern for double.");
            return;
        }

        scanner.close();

        try {
            // The Definition of the BMI, or Body-Mass Index is defined as the user's weight, divided by the square of their height.
            userBMI = (float) (userWeight / Math.pow(userHeight, 2));
        } catch(ClassCastException exception) {
            System.out.print("An unknown error occurred, please see the stack trace below.");
            exception.printStackTrace();
            return;
        }

        System.out.print("Your BMI is " + userBMI);
    }
}
