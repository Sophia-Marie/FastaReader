package fastareader;

import java.util.regex.*;
import java.util.HashMap;

/**
 *
 * @author Sophia Descho und Julia Meyer
 */
public class HeaderParser {

    //define the regex
    final private static Pattern UNIPROTID = Pattern.compile("|[\\w\\d]*|"); //soll alles zwischen | und | finden (ist immer die ID)
    
    final private static Pattern ENTRYNAME = Pattern.compile("|(\\w)* bis "); //soll alles zwischen | und dem nächste Leerzeichen finden (immer Entryname)
    
    final private static Pattern ORGANISM = Pattern.compile("OS=([\\w\\s])* bis GN"); //soll alles zwischen OS= und GN finden aber (strain K12) muss auch gehen

    public static HashMap<String, String> parseHeader(String fastHeader) {
        //Beispielheader
        fastHeader = ">sp|P0A7Y4|RNH_ECOLI Ribonuclease HI OS=Escherichia coli (strain K12) GN=rnhA PE=1 SV=1";
        /*
        allg in uniprot: >db|UniqueIdentifier|EntryName ProteinName OS=OrganismName[ GN=GeneName]PE=ProteinExistence SV=SequenceVersion
        */
        HashMap<String, String> mappings = new HashMap<String, String>();

        
        Matcher uniprotIdMatch = UNIPROTID.matcher(fastHeader);
        Matcher entryNameMatch = ENTRYNAME.matcher(fastHeader);
        Matcher organismMatch = ORGANISM.matcher(fastHeader);
        
        while(uniprotIdMatch.find()){
            String[] id = uniprotIdMatch.group().split("|", 2);
            mappings.put("ID: ", id[1]);
        }
        while(entryNameMatch.find()){
            String[] eName = entryNameMatch.group().split("|");
            mappings.put("EntryName: ", eName[1]);
        }
        while(organismMatch.find()){
            String[] organism = organismMatch.group().split("=");
            mappings.put("Organismus: ", organism[3]);
        }

        return mappings;
    }
}
