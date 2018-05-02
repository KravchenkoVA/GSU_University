import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.gsu.pms.Serializator;
import by.gsu.pms.Patient;

public class Runner  {

	public static void main(String[] args)  {
		final String FILE_NAME = "src\\in.txt";
		double middleage=0;
		int countFemale=0;
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Array size: ");
			int size = Integer.parseInt(in.readLine());
			Patient[] inPatient = new Patient[size];
			
			for (int i = 0; i < size; i++) {
				String[] values = in.readLine().split(";");
				String surname = values[0];
				int age = Integer.parseInt(values[1]);
				middleage+=age;
					String sex = values[2];
				if (sex.equals("female")){
					countFemale++;
				}
					inPatient[i] = new Patient(surname,age,sex);
			}
			System.out.println("Input array: ");
			printArray(inPatient);
			Serializator.serialize(inPatient, FILE_NAME);
			Patient[] outPatient = Serializator.deserialize(FILE_NAME);
			System.out.println();
			System.out.println("Output array: ");
			printArray(outPatient);
			System.out.println();
			System.out.println("Avarage age: "+middleage/size);
			System.out.println();
			System.out.println("Count female: "+countFemale);
		} catch (IOException e) {
		}
	}
	
	private static <T> void printArray(T[] array) {
		for (T value : array) {
			System.out.println(value);
		}
	}

}
