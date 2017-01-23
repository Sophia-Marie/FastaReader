
package fastareader;

import java.util.ArrayList;
import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader extends Fasta {

    
    public static ArrayList<Fasta> getAllFastas(){
        
        ArrayList<Fasta> fastas = new ArrayList<Fasta>();
        try {
            Fasta fasta = null;
            BufferedReader input = null;
            String currentLine;
            
            input = new BufferedReader(new FileReader("C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta"));
            int fastasIndex=0;
            
            while ((currentLine = input.readLine()) != null){
                
                if (currentLine.startsWith(">")){
                    fasta= new Fasta();
                    fasta.header=currentLine.substring(1);
                }
                else{
                    fasta.sequence +=currentLine;
                }
                fasta.seqlen=fasta.sequence.length();
                fastas.add(fastasIndex, fasta);
                fastasIndex +=1;
//                System.out.println(fasta.header + " " + fasta.sequence);
//                System.out.println(fastasIndex);
            }
        }
        
        catch (IOException e) {
            System.out.println("Exception, file not found");
        }
        return fastas;
    }
    
    public static Fasta getNextSequence(Fasta[] allSequences, int i){
        Fasta fast= allSequences[i];
        return fast;
    }
    
    public static void main(String[] args) {
        ArrayList<Fasta> all;
        all=getAllFastas();
        for (int i=0; i<all.size(); i++) {
            if (all.get(i)!=null){
            System.out.println(all.get(i).header + "\n" + all.get(i).sequence);
            }
        }
        
        
    }
}