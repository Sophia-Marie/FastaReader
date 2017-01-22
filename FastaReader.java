
package fastareader;

import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader extends Fasta {

    
    public static Fasta [] getAllFastas(){
        
        Fasta [] fastas = new Fasta[50000];
        String currentLine;
        try {
            Fasta fasta = null;
            BufferedReader input = null;
            
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
                fastas[fastasIndex]= fasta;
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
        Fasta [] all;
        all=getAllFastas();
        for (int i=0; i<all.length; i++) {
            if (all[i]!=null){
            System.out.println(all[i].header + "\n" + all[i].sequence);
            }
        }
        
        
    }
}