package fastareader;

import java.util.regex.*;
import java.util.HashMap;

/**
 *
 * @author Sophia Descho und Julia Meyer
 */
public class HeaderParser {

    //define the regex for various organisms of http://www.uniprot.org/help/fasta-headers
    final private static Pattern UNIPROTID = Pattern.compile("([|])((\\w)*)([|])"); //soll alles zwischen | und | finden (ist immer die ID)
    final private static Pattern ENTRYNAME = Pattern.compile("([|])([\\w]*[_]([\\w]*))"); //soll alles zwischen | und dem nächste Leerzeichen finden (immer Entryname)
    final private static Pattern ORGANISM = Pattern.compile("(OS=)(([\\w\\s])*([(][\\w\\s]*[)])*([\\w\\s])*)(GN=)"); //soll alles zwischen OS= und GN= finden

    public static HashMap<String, String> parseHeader(String fastHeader) {
        //ExampleHeader
        //fastHeader = ">sp|P0A7Y4|RNH_ECOLI Ribonuclease HI OS=Escherichia coli (strain K12) GN=rnhA PE=1 SV=1";
        /*
        allg in uniprot: >db|UniqueIdentifier|EntryName ProteinName OS=OrganismName[ GN=GeneName]PE=ProteinExistence SV=SequenceVersion
         */
        HashMap<String, String> mappings = new HashMap<String, String>();

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
