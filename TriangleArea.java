import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class TriangleArea {

    static Logger logger;
    static Scanner scanner;
    static String argument;
    static String[] arguments;

    public static void main(String[] args) {

        logger = Logger.getLogger("Area of a Triangle");
        scanner = new Scanner(System.in);

        logger.info("Please provide 3 points, which the x,y values are comma seperated, and the points are seperated by a space.");

        // Example input: "3,5 1,3 6,3"
        String[] points = scanner.nextLine().split("\\s+");

        scanner.close();

        double[] pointA = getDoubleArray(points[0].split(","));
        double[] pointB = getDoubleArray(points[1].split(","));
        double[] pointC = getDoubleArray(points[2].split(","));

        double triangleAreaNumerator = (pointA[0] * (pointB[1] - pointC[1])) + (pointB[0] * (pointC[1] - pointA[1])) + (pointC[0] * (pointA[1] - pointB[1]));

        double triangleArea = Math.abs(triangleAreaNumerator / 2);

        logger.info("Area: " + triangleArea);

    }

    static double[] getDoubleArray(String[] args) {
        return Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
    };

}
