import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class WhileMaxMin {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please type in the numbers for which you wish to calculate the maximum and minimum values, space-separated: ");
        String numbersString = scanner.nextLine();
        int[] numbers = getIntegerArray(numbersString.split(" "));

        OptionalInt minimumInteger = Arrays.stream(numbers).min();
        OptionalInt maximumInteger = Arrays.stream(numbers).max();

        if (minimumInteger.isEmpty()) throw new Exception("Minimum integer not present, are all numbers equal?");

        System.out.println("Maximum Integer: " + maximumInteger.getAsInt());
        System.out.println("Minimum Integer: " + minimumInteger.getAsInt());

    }

    // could be replaced with a for loop
    static int[] getIntegerArray(String[] args) {
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    };

}
