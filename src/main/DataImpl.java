package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Davide Sordi
 * Using IntelliJ IDEA
 * Date: 23/05/2019
 * Time: 13.11
 * <p>
 * Class: main.DataImpl
 * Project: main.CalcolatoreMedia
 */


public class DataImpl {

	private Map<Integer, Esame> esami;
	private static final String dataFilepath = "APP_DATA";

	public DataImpl() {
		esami = new HashMap<>();

		// Lettura da file
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(dataFilepath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Read data
			System.out.println("Reading data...");
			esami = (HashMap<Integer, Esame>) objectInputStream.readObject();
			System.out.println("Data read...");

			objectInputStream.close();
			fileInputStream.close();

		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Data file not found...");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error while reading data, no data available...");

			// Try to overwrite read data with clean data structures if file can't be read
			esami = new HashMap<>();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void calcolaMedia() {
		double media = 0;
		double mediap = 0;
		int crediti = 0;
		int creditip = 0;

		for (Esame e : esami.values()) {
			if (e.pass()) {
				media += e.getCrediti() * e.getVoto();
				crediti += e.getCrediti();
				mediap += e.getCrediti() * e.getVoto();
				creditip += e.getCrediti();
			}
			if (e.previsto()) {
				mediap += e.getCrediti() * e.getVoto();
				creditip += e.getCrediti();
			}
		}
		media = media / crediti;
		mediap = mediap / creditip;
		System.out.println("Media di: " + String.format("%.2f", media) + " calcolata su " + crediti + " crediti");
		System.out.println("Media con previsioni di: " + String.format("%.2f", mediap) + " calcolata su " + creditip + " crediti");
		return;
	}

	public void previsione() {
		int code;
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci il codice di un esame non dato");
		code = in.nextInt();
		if (esami.get(code) == null) {
			System.out.println("Codice inserito non valido");
			return;
		}
		Esame exam = esami.get(code);
		System.out.println("Inserisci il voto che pensi di prendere");
		int voto = in.nextInt();
		exam.setVoto(voto);
	}

	private void deletePrevisione() {
		int code;

		//stampa esami previsti se presenti
		if (esami.values().stream().filter(Esame::previsto).count() == 0) {
			System.out.println("Non ci sono esami previsti");
			return;
		}
}
