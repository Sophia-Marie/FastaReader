
package fastareader;

import java.io.*;

/**
 * @author Sophia
 */
public class FastaReader {

    /**
     * @param args the command line arguments
     */
//    public FastaReader getNextSequence(){
//        
//        return; 
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //getNextSequence()
        BufferedReader input = null;
        try {

            String sCurrentLine;

            input = new BufferedReader(new FileReader("C:\\Users\\Sophia\\Documents\\NetBeansProjects\\FastaReader\\src\\fastareader\\uniprot-escherichia.fasta"));

            while ((sCurrentLine = input.readLine()) != null) {
                System.out.println(sCurrentLine);
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
        //String inputLine = input.readLine();
        
    }
    
}
