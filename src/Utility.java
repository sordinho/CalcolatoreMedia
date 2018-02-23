import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: Utility class
 * Created by Davide Sordi on 16/02/2018 at 15.19.
 */

public class Utility {

    /**
     * Read lines from a file into a list of string
     *
     * @param file name or path of the file to read
     * @return list of rows
     */
    public static List<String> readLines(String file) {

        ArrayList<String> rows = new ArrayList<>();

        String line;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            System.err.println("Detected and error while reading file: " + file);
            return null;
        }

        //rows.remove(0);
        return rows;
    }

    public static Map<Integer, Esame> elaboraEsami(List<String> rows) {

        Map<Integer, Esame> esami = new HashMap<>();
        int i=1;
        for (String row : rows) {

            String[] campi = row.split(";");

            String nome = campi[0];
            int crediti = Integer.parseInt(campi[1]);

            if (campi.length == 3) {
                int voto = Integer.parseInt(campi[2]);
                Esame e = new Esame(nome, crediti,i, voto);
                esami.put(i, e);
            } else {
                Esame e = new Esame(nome, crediti,i);
                esami.put(i, e);
            }
        i++;

        }


        return esami;
    }
}
