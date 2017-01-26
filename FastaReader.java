package fastareader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sophia Descho und Julia Meyer
 */
public class FastaReader {

    final private static String FILE = "C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta";
    final private BufferedReader INPUTSTREAM;
    private String currentLine;

    public FastaReader(BufferedReader inputStream) throws IOException {
        this.INPUTSTREAM = inputStream;
        this.currentLine = INPUTSTREAM.readLine();
    }

    public boolean hasNextSequence() {
        return currentLine != null && currentLine.startsWith(">");
    }

    public Fasta getNextSequence() throws IOException {
        Fasta fasta = new Fasta();

        if (currentLine.startsWith(">")) {
            fasta.setHeader(currentLine);
        }
        do {
            currentLine = INPUTSTREAM.readLine();
            if (currentLine != null) {
                fasta.setSequence(currentLine);
            }
        } while (currentLine != null && !currentLine.startsWith(">"));

        return fasta;
    }

    public static void main(String[] args) {
        try {
            BufferedReader INPUTSTREAM = new BufferedReader(new FileReader(FILE));
            FastaReader fastaReader = new FastaReader(INPUTSTREAM);
            ArrayList<Fasta> allFastaObjects = new ArrayList<>();
            
            while (fastaReader.hasNextSequence()) {
                Fasta fasta = fastaReader.getNextSequence();
                allFastaObjects.add(fasta);
            }
            HashMap<String, String> parsedHeader;
            //test the HeaderParser and choose any index of allFastaObjects below
            parsedHeader = HeaderParser.parseHeader(allFastaObjects.get(2).getHeader());
            //output of parsed Header
            System.out.println(parsedHeader);
            
        } catch (IOException e) {
            System.out.println("Error, File not found!");
        }

    }
}
