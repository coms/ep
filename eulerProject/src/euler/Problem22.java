package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Problem22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			ArrayList<String> names = new ArrayList<String>();
			BufferedReader reader = new BufferedReader( new FileReader(new File("data/names.txt")));
			String str = reader.readLine();
			String[] namesArray = str.split(",");
			for (String rawName : namesArray) {
				String name = rawName.substring(1, rawName.length() - 1);
				System.out.println(name);
				names.add(name);
			}
			Collections.sort(names);
			System.out.println(names);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
