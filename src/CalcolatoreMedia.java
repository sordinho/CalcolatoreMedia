import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Title: Main class per il calcolo della media e gestisce gli esami e le statistiche di uno studente
 * Created by Davide Sordi on 16/02/2018 at 15.18.
 */

public class CalcolatoreMedia {

	private List<String> lettura = Utility.readLines("esami.txt");
	private Map<Integer, Esame> esami = Utility.elaboraEsami(lettura);

	public void stampaLibretto() {
		System.out.println("ESAME - VOTO - CREDITI");
		for (Esame e : esami.values()) {
			if (e.pass()) {
				System.out.println(e.getNome() + " - " + e.getVoto() + " - " + e.getCrediti());
			}
		}
		return;
	}

	public void stampaEsamiDaDare() {
		System.out.println("CODICE - ESAME - CREDITI");
		for (Esame e : esami.values()) {
			if (!e.pass())
				System.out.println(e.geCodice() + " - " + e.getNome() + " - " + e.getCrediti());
		}
		return;
	}

	public void calcolaMedia() {
		double media = 0;
		double mediap=0;
		int crediti = 0;
		int creditip=0;

		for (Esame e : esami.values()) {
			if (e.pass()) {
				media += e.getCrediti() * e.getVoto();
				crediti += e.getCrediti();
				mediap += e.getCrediti() * e.getVoto();
				creditip += e.getCrediti();
			}
			if(e.previsto()) {
				mediap += e.getCrediti() * e.getVoto();
				creditip+=e.getCrediti();
			}
		}
		media = media / crediti;
		mediap=mediap/creditip;
		System.out.println("Media di: " + String.format("%.2f",media) + " calcolata su " + crediti + " crediti");
		System.out.println("Media con previsioni di: " + String.format("%.2f",mediap) + " calcolata su " + creditip + " crediti");
		return;
	}

	public void previsione() {
		int code;
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci il codice di un esame non dato");
		code = in.nextInt();
		if(esami.get(code)==null){
			System.out.println("Codice inserito non valido");
			return;
		}
		Esame exam=esami.get(code);
		System.out.println("Inserisci il voto che pensi di prendere");
		int voto=in.nextInt();
		exam.setVoto(voto);
	}

    public static void main(String[] args) {

        CalcolatoreMedia calcolatoreMedia = new CalcolatoreMedia();

        Character cmd ='E';
        Scanner in = new Scanner(System.in);
        do {
            printMenu();
            cmd = in.next().charAt(0);
            switch (cmd) {
                case 'L':
                case 'l':
                    calcolatoreMedia.stampaLibretto();
                    break;
                case 'M':
                case 'm':
                    calcolatoreMedia.calcolaMedia();
                    break;
                case 'N':
                case 'n':
                    calcolatoreMedia.stampaEsamiDaDare();
                    break;
                case 'P':
                case 'p':
                    calcolatoreMedia.stampaEsamiDaDare();
                    calcolatoreMedia.previsione();
                    break;
                case 'D':
                case 'd':
                    //calcolatoreMedia.deletePrevisione();
                    break;
                case 'E':
                case 'e':
                    System.out.println("Fine del programma");
                    break;
                default:
                    System.out.println("Errore comando non valido");
            }


        } while (cmd != 'e' && cmd != 'E');

    }

    static void printMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("L per vedere il libretto");
        System.out.println("N per la lista degli esami da dare");
        System.out.println("P per la previsione di un voto");
        System.out.println("M per il calcolo della media attuale");
        System.out.println("D per eliminare la previsione di un voto");
        System.out.println("E per uscire");
        System.out.println("---------------------------------------------------->");
    }
}
