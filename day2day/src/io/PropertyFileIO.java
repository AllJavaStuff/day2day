package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		readPropertyFile();

		writePropertyFile();

	}

	private static void writePropertyFile() {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileOutputStream fo;

		try {

			fo = new FileOutputStream("Resource/property2.txt");
			p.setProperty("1", "one");
			p.store(fo, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readPropertyFile() {
		// TODO Auto-generated method stub

		FileInputStream f;
		Properties p = new Properties();

		try {
			f = new FileInputStream("Resource/property.txt");
			p.load(f);

			String value = p.getProperty("line");
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
