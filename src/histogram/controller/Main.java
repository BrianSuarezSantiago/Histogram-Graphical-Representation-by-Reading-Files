package histogram.controller;

import histogram.model.*;
import histogram.view.*;
import java.util.List;
/**
 * Controller class that instances the necessary objects
 * for the construction of a histogram and represents it
 * by calling to execute() method implemented in the
 * HistogramDisplay class.
 *
 * @author Brian Suárez Santiago
 * @version 2.0.0
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/List.html">Interface List</a>
 */
public class Main {

    /**
     * Initializes the objects needed to the construction
     * of a histogram, and represents it making use of to
     * execute() method.
     */
    public static void main(String[] args) {
        execute();
    }

    /**
     * Represents the histogram from data from input and
     * processing of these depending on whether they are
     * email domains valid or not.
     */
    public static void execute() {
        List<Mail> mailList = input();
        Histogram histogram = process(mailList);
        output(histogram);
    }

    /**
     * Reads a list of email domains passed as parameter
     * in the text file "email.txt"
     *
     * @return List of email domains.
     */
    public static List<Mail> input() {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        return mailList;
    }

    /**
     * Process the list of email domains passed as a
     * parameter and to build the final list of domains
     * of valid emails that will be used in the
     * histogram representation.
     *
     * @param mailList List of email domains to process.
     * @return Histogram processed.
     */
    public static Histogram process(List<Mail> mailList) {
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        return histogram;
    }

    /**
     * Initializes the objects needed to the construction of
     * a histogram, and represents it making use of to execute()
     * method.
     *
     * @param histogram Histogram.
     */
    public static void output(Histogram histogram) {
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram", histogram);
        histogramDisplay.execute();
    }
}