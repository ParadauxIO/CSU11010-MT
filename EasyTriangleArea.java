import java.util.Scanner;

public class EasyTriangleArea {

    public static void main(String[] args) {

        double Ax, Ay;
        double Bx, By;
        double Cx, Cy;

        Scanner scanner = new Scanner(System.in);

        // Example input: "3,5 1,3 6,3"

        System.out.print("Enter the co-ordinates for point A");
        String inputA = scanner.nextLine();
        String[] inputsA = inputA.split(" ");
        Ax = Double.parseDouble(inputsA[0]);
        Ay = Double.parseDouble(inputsA[1]);

        System.out.println("Enter the co-ordinates for point B");
        String inputB = scanner.nextLine();
        String[] inputsB = inputB.split(" ");
        Bx = Double.parseDouble(inputsB[0]);
        By = Double.parseDouble(inputsB[1]);

        System.out.println("Enter the co-ordinates for point C");
        String inputC = scanner.nextLine();
        String[] inputsC = inputC.split(" ");
        Cx = Double.parseDouble(inputsC[0]);
        Cy = Double.parseDouble(inputsC[1]);

        double triangleArea = Math.abs((Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By )) / 2);
        System.out.println("The Area of the triangle is: " + triangleArea);

    }

}
