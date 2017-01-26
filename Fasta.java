package fastareader;

/**
 *
 * @author Sophia Descho und Julia Meyer
 */
public class Fasta {

    private String header;
    private String sequence;
    private int seqlen;

    public Fasta() {
        header = "";
        sequence = "";
        seqlen = 0;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setSequence(String sequence) {
        this.sequence += sequence;
    }

    public String getHeader() {
        return header;
    }

    public String getSequence() {
        return sequence;
    }

    public int getSeqlen() {
        this.seqlen = this.sequence.length();
        return seqlen;
    }

}
