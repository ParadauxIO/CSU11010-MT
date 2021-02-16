import java.util.Scanner;

public class TotalAverageCalculator {

    public static void main(String[] args) {
        System.out.print("How many integers do you want to enter? ");
        Scanner input = new Scanner( System.in );
        int limit = input.nextInt();
        double limit1= limit;

        double total = 0;
        if (limit > 2 && limit  < 10)
        {
            for(int i = 1; i <=limit; i++) {
                System.out.print("Enter integer " + i + ":" );
                Scanner input1 = new Scanner( System.in );
                int integer = input.nextInt();
                total += integer;
            }
            System.out.print( "The sum of your integers is " + total + " and the average is " + (total/limit));
        }
        else
            System.out.print("Error:  This program is constrained to only compute the total & average of between 2 & 10 integers.");
    }

}