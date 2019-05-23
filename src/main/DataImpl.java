import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Davide Sordi
 * Using IntelliJ IDEA
 * Date: 23/05/2019
 * Time: 13.11
 * <p>
 * Class: DataImpl
 * Project: CalcolatoreMedia
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
}
