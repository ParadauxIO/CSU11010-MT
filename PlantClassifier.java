import java.util.Scanner;

public class PlantClassifier {

    public static void main(String[] args) {

        Scanner input = new Scanner ( System.in );
        String response = "";
        boolean responseIsYes;

        System.out.print("Does this plant have cells and tissues which are organised into " +
                "functional structures (Yes/No)? ");
        response = input.next();
        responseIsYes = response.equalsIgnoreCase("Yes");

        if( responseIsYes ) {
            System.out.print("Does the plant have vascular tissues (Yes/No)? ");
            response = input.next();
            responseIsYes = response.equalsIgnoreCase("Yes");

            if( responseIsYes ) {
                System.out.print("Is the plant dispersed by seeds (Yes/No)? ");
                response = input.next();
                responseIsYes = response.equalsIgnoreCase("Yes");

                if( responseIsYes ) {
                    System.out.print("Are the seeds enclosed (Yes/No)? ");
                    response = input.next();
                    responseIsYes = response.equalsIgnoreCase("Yes");

                    if( responseIsYes ) {
                        System.out.print("The plant is an ANGIOSPERM.");
                    } else if ( response.equalsIgnoreCase("No") ) {
                        System.out.print("The plant is a GYMNOSPERM.");
                    }

                } else if ( response.equalsIgnoreCase("No") ) {
                    System.out.print("The plant is a PTERIDOPHYTE.");
                }

            } else if ( response.equalsIgnoreCase("No") ) {
                System.out.print("The plant is a BRYOPHYTE.");
            }

        } else if ( response.equalsIgnoreCase("No") ) {
            System.out.print("The plant is an ALGAE.");
        }

    }

}