import java.util.Scanner;

public class VertebrateClassifier {

    public enum BLOOD_TYPE {
        COLD, WARM
    }

    public enum INTEGUMENT {
        MOIST_SKIN, SCALES, HAIR, FEATHERS
    }

    static boolean hasFins;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Animal Vertebrate Classifier v1.0 \n\n © Rían Errity\n\n");

        try {
            System.out.print("Does this animal have warm or cold blood: ");
            String bloodTypeString = scanner.nextLine();

            BLOOD_TYPE bloodType;

            if (bloodTypeString.toLowerCase().contains("warm")) {
                bloodType = BLOOD_TYPE.WARM;
            } else if (bloodTypeString.toLowerCase().contains("cold")) {
                bloodType = BLOOD_TYPE.COLD;
            } else {
                throw new IllegalStateException("Unexpected value: " + bloodTypeString.toLowerCase());
            }

            System.out.print("Which integument state (outer coating) describes your animal: (skin, scales, hair, feathers): ");
            String integumentString = scanner.next();

            INTEGUMENT integument;

            switch (integumentString.toLowerCase()) {
                case "skin": {
                    integument = INTEGUMENT.MOIST_SKIN;
                }

                case "scales": {
                    integument = INTEGUMENT.SCALES;
                }

                case "hair": {
                    integument = INTEGUMENT.HAIR;
                }

                case "feathers": {
                    integument = INTEGUMENT.FEATHERS;
                }

                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + integumentString.toLowerCase());
            }

            System.out.print("Does your animal have fins: ");
            String hasFinsString = scanner.nextLine();

            if (hasFinsString.toLowerCase().contains("warm")) {
                bloodType = BLOOD_TYPE.WARM;
            } else if (hasFinsString.toLowerCase().contains("cold")) {
                bloodType = BLOOD_TYPE.COLD;
            } else {
                throw new IllegalStateException("Unexpected value: " + integumentString.toLowerCase());
            }

        } catch (IllegalArgumentException exception) {
            System.out.println("You have inputted a malformed answer.");
            return;
        }

        scanner.close();

    }
}
