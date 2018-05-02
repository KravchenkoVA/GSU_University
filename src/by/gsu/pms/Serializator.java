package by.gsu.pms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializator {

	public static <T> void serialize(T[] array, String fileName) throws IOException {
		File file = new File(fileName);

		try (OutputStream out = new FileOutputStream(file)) {
			if (out != null) {
				try (ObjectOutputStream fileOut = new ObjectOutputStream(out)) {
					fileOut.writeObject(array);
				}
			}
		}
	}

	public static <T> T[] deserialize(String fileName) {
		File file = new File(fileName);
		try (InputStream in = new FileInputStream(file); 
				ObjectInputStream fileIn = new ObjectInputStream(in)) {
			
			T[] patient = (T[]) fileIn.readObject();
			return patient;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}
}
