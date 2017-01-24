package fastareader;

import java.util.ArrayList;
import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader {

    final private static String FILE = "C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta";

    public Fasta getNextSequence(BufferedReader inputStream) {
        Fasta fasta = new Fasta();
        try {
            inputStream.mark(10000);
            while (true) {
                String line = inputStream.readLine();

                if (line == null) {
                    inputStream.reset();
                    return fasta.getSeqlen() > 0 ? fasta : null;
                } else if (line.startsWith(">")) {
                    fasta.setHeader(line);
                } else {
                    fasta.setSequence(line);
                }
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
            Fasta fasta;
            while ((fasta = fastaReader.getNextSequence(inputStream)) != null) {
                allFastaObjects.add(fasta);
                System.out.println(fasta.getHeader() + "\n" + fasta.getSequence());
            }
        } catch (IOException e) {
            System.out.println("Error, File not found!");
        }

    }
}
