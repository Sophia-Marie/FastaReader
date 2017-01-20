
package fastareader;

import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader extends Fasta {

    
    public static Fasta getNextSequence(){
        Fasta fasta= new Fasta();
        return fasta;
    }
    
    public static void main(String[] args) {
        BufferedReader input = null;
        
        Fasta [] fastas= new Fasta[100];
        
        //TODO count header for array size ?
        
        int fastasIndex=0;
        try {
            String currentLine;
            
            input = new BufferedReader(new FileReader("C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta"));
            
            while ((currentLine = input.readLine()) != null){
                Fasta fasta = getNextSequence();
                if (currentLine.startsWith(">")){
                    fasta.header=currentLine.substring(1);
                    while(false==currentLine.startsWith(">")){
                        fasta.sequence +=currentLine;
                    }
                }
                fasta.seqlen=fasta.sequence.length();
                fastas[fastasIndex]= fasta;
                fastasIndex= fastasIndex+1;
            }
        }
        catch (IOException e) {
            System.out.println("Exception, file not found");
        }        
    }
}