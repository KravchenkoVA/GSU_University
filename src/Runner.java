import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import by.gsu.lab.*;


public class Runner {
	public static void main(String[] args) {
		FileWriter writer = null;
		FileReader reader = null;
		String string = "";
		List<Phone> phones = new ArrayList<Phone>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			writer = new FileWriter("in.txt");
			System.out.println("Array size: ");
			int size = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Please use the following format:\n firstName; secondName; address; numberOfCard; debit; credit; timeOfCityCalls; timeOfInternationalCalls");
			Phone[] phone = new Phone[size];
			for (int i = 0; i < size; i++) {
				String[] values = bufferedReader.readLine().split(";");
				String firstName = values[0];
				String secondName = values[1];
				String address = values[2];
				int numberOfCard = Integer.parseInt(values[3]);
				double debit = Double.parseDouble(values[4]);
				double credit = Double.parseDouble(values[5]);
				int timeOfCityCalls = Integer.parseInt(values[6]);
				int timeOfInternationalCalls = Integer.parseInt(values[7]);
				Phone newPhone = new Phone(firstName, secondName, address, numberOfCard, debit, credit, timeOfCityCalls, timeOfInternationalCalls);
				writer.write(newPhone.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();

			} catch (IOException e) {
				// TODO: handle exception
			}
		}

		try {
			reader = new FileReader("in.txt");
			int a;

			do {
				a = reader.read();
				if (a != -1) {
					string = string + (char) a;
				}
			} while (a != -1);

				String[] data = string.split("; ");
				for(int i=0;i<data.length;i++) {
					Phone phone = new Phone(UUID.fromString(data[i]),data[++i],data[++i],data[++i],Integer.parseInt(data[++i]),Double.parseDouble(data[++i]),Double.parseDouble(data[++i]),Integer.parseInt(data[++i]),Integer.parseInt(data[++i]));
					phones.add(phone);
				}

				Collections.sort(phones);
				System.out.println("\nSorted phone by Surname: \n");
				
				for(int i=0;i<phones.size();i++) {
					System.out.println("\n"+phones.get(i));
				}

				List<Phone> smtn = Phone.saysMorethanNorm(phones, 1200);
				System.out.println("\nSays More than Norm: \n");
				
				for(int i=0;i<smtn.size();i++) {
					
					System.out.println("\n"+smtn.get(i));
				}

            List<Phone> eic = Phone.enjoyedInternationalCommunication(phones);
            System.out.println("\n Enjoyed International Communication: \n");

            for(int i=0;i<eic.size();i++) {

                System.out.println("\n"+eic.get(i));
            }

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
		}
	}

