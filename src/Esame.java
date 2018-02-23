/**
 * Title: Esame classe per la descrizione di un esame
 * Created by Davide Sordi on 16/02/2018 at 15.06.
 */

public class Esame {

    private String nome;
    private int crediti;
    private int voto;
    private boolean passato;
    private int codice;
    private boolean previsto;

    public Esame(String nome, int crediti,int codice, int voto) {
        this.nome = nome;
        this.crediti = crediti;
        this.voto = voto;
        this.passato = true;
        this.codice=codice;
        this.previsto=false;
    }

    public Esame(String nome, int crediti,int codice) {
        this.nome = nome;
        this.crediti = crediti;
        this.voto = -1;
        this.passato = false;
        this.codice=codice;
        this.previsto=false;
    }

    public boolean pass() {
        return passato;
    }

    public String getNome() {
        return nome;
    }

    public int getCrediti() {
        return crediti;
    }

    public int getVoto() {
        return voto;
    }

    public int geCodice() {
        return codice;
    }

    public void setVoto(int voto){
        previsto=true;
        this.voto=voto;
    }

    public boolean previsto() {
        return previsto;
    }
}
