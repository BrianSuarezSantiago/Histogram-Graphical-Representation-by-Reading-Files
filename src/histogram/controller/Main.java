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
 * @version 1.0.0
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/List.html">Interface List</a>
 */
public class Main {

    public static void main(String[] args) {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histogramDisplay = new HistogramDisplay("EMAIL DOMAINS HISTOGRAM", histogram);
        histogramDisplay.execute();
    }
}