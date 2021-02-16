import java.util.Scanner;

public class Multiples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Multiples of: ");
        int multipleBase = scanner.nextInt();

        System.out.print("Up to a limit of: ");
        int multipleLimit = scanner.nextInt();

        scanner.close();

        StringBuilder template = new StringBuilder(String.format("The multiples of %d (up to %d) are ", multipleBase, multipleLimit));

        int count = 0;
        for (; count <= multipleLimit-multipleBase; count += multipleBase) {
            template.append(count).append(", ");
        }

        System.out.println(template.toString() + count + ".");
    }
}
