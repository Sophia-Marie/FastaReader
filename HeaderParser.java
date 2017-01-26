package fastareader;

import java.util.regex.*;
import java.util.HashMap;

/**
 *
 * @author Sophia Descho und Julia Meyer
 */
public class HeaderParser {

    //define the regex for various organisms of http://www.uniprot.org/help/fasta-headers
    final private static Pattern UNIPROTID = Pattern.compile("([|])((\\w)*)([|])"); //soll alles zwischen | und | finden
    final private static Pattern ENTRYNAME = Pattern.compile("([|])([\\w]*[_]([\\w]*))"); //soll alles zwischen | und dem nächste Leerzeichen finden
    final private static Pattern ORGANISM = Pattern.compile("(OS=)(([\\w\\s\\W])*)(GN=)"); //soll alles zwischen OS= und GN= finden

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
