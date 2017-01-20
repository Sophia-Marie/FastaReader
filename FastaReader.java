
package fastareader;

import java.io.*;

/**
 * @author Sophia
 */
public class FastaReader {

    /**
     * @param args the command line arguments
     */
    String header, sequence;
    public FastaReader(){
        this.header=header;
        this.sequence=sequence;
    }
    public FastaReader getNextSequence(FastaReader header, FastaReader sequence){
        
        fasta = new FastaReader();
         BufferedReader input = null;
        try {

            String currentLine;

            input = new BufferedReader(new FileReader("C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta"));

            while ((currentLine = input.readLine()) != null) {
               // System.out.println(sCurrentLine);
                if(currentLine.startsWith(">")){
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null)input.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return fasta; 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //getNextSequence()
        //String inputLine = input.readLine();
        
    }
    
}
