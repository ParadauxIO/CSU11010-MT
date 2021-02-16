import java.util.logging.Logger;

public class StandardDeviation {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("Standard Deviation");

        double populationMean = 0;
        double stdDeviationNumerator = 0;
        double populationStdDeviation;

        // No point calculating if there's only one value, and it's impossible to if no input is provided
        if (args.length <= 1) {
            logger.severe("Not enough values supplied.");
            return;
        }

        populationMean = populationMean / args.length;


        for (String arg : args) {
            stdDeviationNumerator += Math.pow( Double.parseDouble(arg) - populationMean, 2 );
        }

        populationStdDeviation = Math.sqrt(stdDeviationNumerator / args.length);

        logger.info("Supplied values: [ " + String.join(", ", args) + " ]");
        logger.info("Population Mean: " + populationMean);
        logger.info("Standard Deviation: " + populationStdDeviation);

    }

}
