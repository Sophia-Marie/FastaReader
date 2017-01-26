package fastareader;

import java.util.regex.*;
import java.util.HashMap;

/**
 *
 * @author Sophia Descho und Julia Meyer
 */
public class HeaderParser {

    //regex for various organisms of http://www.uniprot.org/help/fasta-headers
    final private static Pattern UNIPROTID = Pattern.compile("([|])(\\w*)([|])");
    final private static Pattern ENTRYNAME = Pattern.compile("([|])(\\w*[_]\\w*)");
    final private static Pattern ORGANISM = Pattern.compile("(OS=)([\\w\\s\\W]*)(\\sGN=)");

    public static HashMap<String, String> parseHeader(String fastHeader) {
        HashMap<String, String> mappings = new HashMap<>();

        Matcher uniprotIdMatch = UNIPROTID.matcher(fastHeader);
        Matcher entryNameMatch = ENTRYNAME.matcher(fastHeader);
        Matcher organismMatch = ORGANISM.matcher(fastHeader);

        while (uniprotIdMatch.find()) {
            String id = uniprotIdMatch.group(2);
            mappings.put("ID ", " " + id);
        }
        while (entryNameMatch.find()) {
            String eName = entryNameMatch.group(2);
            mappings.put("EntryName ", " " + eName);
        }
        while (organismMatch.find()) {
            String organism = organismMatch.group(2);
            mappings.put("Organismus ", " " + organism);
        }

        return mappings;
    }
}
