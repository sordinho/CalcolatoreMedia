import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Title: Main class per il calcolo della media
 * Created by Davide Sordi on 16/02/2018 at 15.18.
 */

public class CalcolatoreMedia {

    public static void main(String[] args) {

        Studente studente = new Studente();
        //studente.stampaLibretto();

        Character cmd ='E';
        Scanner in = new Scanner(System.in);
        do {
            printMenu();
            cmd = in.next().charAt(0);
            switch (cmd) {
                case 'L':
                case 'l':
                    studente.stampaLibretto();
                    break;
                case 'M':
                case 'm':
                    studente.calcolaMedia();
                    break;
                case 'N':
                case 'n':
                    studente.stampaEsamiDaDare();
                    break;
                case 'P':
                case 'p':
                    studente.stampaEsamiDaDare();
                    studente.previsione();
                    break;
                case 'D':
                case 'd':
                    //studente.deletePrevisione();
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
