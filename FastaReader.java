
package fastareader;

import java.util.ArrayList;
import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader {
    
    final private static String FILE = "C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta";
    private static String currentLine;
    
    public Fasta getNextSequence(BufferedReader inputStream){
        
        Fasta fasta = new Fasta();
        
        try{
            if (currentLine.startsWith(">")){
                fasta.setHeader(currentLine);
            }
            currentLine=inputStream.readLine();
            while(false==currentLine.startsWith(">") && currentLine!=null){   
                    fasta.setSequence(currentLine);
                    currentLine = inputStream.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error");
        }
        System.out.println(fasta.getHeader());
        System.out.println(fasta.getSequence());
        
        return fasta;
    }
    
    public static void main(String[] args) {
        try {
        BufferedReader inputStream = new BufferedReader(new FileReader(FILE));
        FastaReader fastareader= new FastaReader();
//        Fasta fast = new Fasta();
        ArrayList<Fasta> allFastaObjects = new ArrayList<Fasta>();
        int index=0;
        currentLine= inputStream.readLine();
            while (currentLine!=null){
                Fasta fast = new Fasta();
                fast = fastareader.getNextSequence(inputStream);
                allFastaObjects.add(index, fast);
                index +=1;
            }
        }
        catch (IOException e){
            System.out.println("Error, File not found!");
        }
        
 
        
    }
}
