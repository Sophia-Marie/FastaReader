package fastareader;

import java.util.ArrayList;
import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader {

    final private static String FILE = "C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta";

    private BufferedReader inputStream;
    private String currentLine;

    public FastaReader(BufferedReader inputStream) throws IOException {
        this.inputStream = inputStream;
        this.currentLine = inputStream.readLine();
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
            currentLine = inputStream.readLine();
            fasta.setSequence(currentLine);
        } while (currentLine != null && !currentLine.startsWith(">"));

        return fasta;
    }

    public static void main(String[] args) {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(FILE));
            FastaReader fastaReader = new FastaReader(inputStream);
            ArrayList<Fasta> allFastaObjects = new ArrayList<Fasta>();
            while (fastaReader.hasNextSequence()) {
                Fasta fasta = fastaReader.getNextSequence();
                allFastaObjects.add(fasta);
                System.out.println(fasta.getHeader() + "\n" + fasta.getSequence());
            }
        } catch (IOException e) {
            System.out.println("Error, File not found!");
        }
    }
}
