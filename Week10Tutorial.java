import java.util.Scanner;

public class Week10Tutorial {

    static String input;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    private static double determineAverageMark(double[] marks) {
        int markSum = 0;
        for (double mark : marks) {
            markSum += mark;
        }
        return (double) markSum / marks.length;
    }

    private static int countAboveAverageStudents(double[] marks) {
        double averageMark = determineAverageMark(marks);
        int sumAboveAverage = 0;

        for (double mark : marks) {
            if (mark > averageMark) {
                sumAboveAverage++;
            }
        }

        return sumAboveAverage;
    }

}
