package fastareader;

import java.util.ArrayList;
import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader {

    final private static String FILE = "C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta";

    public Fasta getNextSequence(BufferedReader inputStream, String currentLine) {

        Fasta fasta = new Fasta();

        try {
            if (currentLine.startsWith(">")) {
                fasta.setHeader(currentLine);
            }
            currentLine = inputStream.readLine();

            while (!currentLine.startsWith(">")) {
                fasta.setSequence(currentLine);
                currentLine = inputStream.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return fasta;
    }

    public static void main(String[] args) {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(FILE));
            FastaReader fastaReader = new FastaReader();
            ArrayList<Fasta> allFastaObjects = new ArrayList<Fasta>();
            int index = 0;
            String currentLine = inputStream.readLine();
            while (currentLine != null) {
                Fasta fast = fastaReader.getNextSequence(inputStream, currentLine);
                allFastaObjects.add(index, fast);
                index += 1;

            }
        } catch (IOException e) {
            System.out.println("Error, File not found!");
        }

    }
}
