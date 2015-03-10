package nl.bioinf.mkslofstra.DiseaseFinder.synonyms;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Displays word forms and definitions for synsets containing the word form
 * specified on the command line. To use this application, specify the word form
 * that you wish to view synsets for, as in the following example which displays
 * all synsets containing the word form "airplane":
 */
public class TestJAWS {

    /**
     * Main entry point. The command-line arguments are concatenated together
     * (separated by spaces) and used as the word form to look up.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestJAWS tj = new TestJAWS();
        tj.Start("");
    }

        public void Start(String word) {
        System.setProperty("wordnet.database.dir", "/commons/student/2014-2015/"
                + "Thema11/Mkslofstra/WordNet-3.0/dict");
        ArrayList synonyms = new ArrayList<String>();
        if (word != null) {
            //  Concatenate the command-line arguments
            StringBuilder buffer = new StringBuilder();
            buffer.append(word);
            String wordForm = buffer.toString();
            //  Get the synsets containing the wrod form
            WordNetDatabase database = WordNetDatabase.getFileInstance();
            Synset[] synsets = database.getSynsets(wordForm);
            //  Display the word forms and definitions for synsets retrieved
            if (synsets.length > 0) {
                for (Synset synset : synsets) {
                    String[] wordForms = synset.getWordForms();
                    if (synset.getTagCount(wordForm) > 3) {
                        synonyms.addAll(Arrays.asList(wordForms));
                    }
                }
            } else {
                System.err.println("No synsets exist that contain "
                        + "the word form '" + wordForm + "'");
            }
        } else {
            System.err.println("You must specify "
                    + "a word form for which to retrieve synsets.");
        }
    }
}
