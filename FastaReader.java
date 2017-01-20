
package fastareader;

import java.io.*;

/**
 * @author Sophia and Julia
 */
public class FastaReader {

    String header, sequence;
    int len;
    public FastaReader(){
        this.header=header;
        this.sequence=sequence;
        this.len=len;
    }
    public FastaReader getNextSequence(){
        String seq="";
        
        FastaReader fasta = new FastaReader();
        
        BufferedReader input = null;
        try {

            String currentLine;
            
            input = new BufferedReader(new FileReader("C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta"));

            while ((currentLine = input.readLine()) != null) {
                if(currentLine.startsWith(">")){
                    //fasta header der sequenz
                    fasta.header= currentLine.substring(1);
                    fasta.sequence=seq;
                }
                else{
                    //fasta Sequenz zusammensetzen
                    fasta.sequence +=currentLine;
                }
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
        
        finally {
            try {
                if (input != null)input.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return fasta; 
    }
    
    public static void main(String[] args) {
        
        FastaReader fasta = getNextSequence();
        //getNestSequence ausführen und Header und Sequenz ausgeben

        
    }
    
}
