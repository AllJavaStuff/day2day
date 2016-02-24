package io;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadWrite {

	public static void main(String[] args) throws FileNotFoundException {

		// 1 . Read File Using BufferedReader

		BufferedReader b = new BufferedReader(new InputStreamReader(
				new FileInputStream("a.txt")));
		// BufferedReader b = new BufferedReader(new
		// InputStreamReader(System.in));
		String bl;
		try {
			while ((bl = b.readLine()) != null) {
				System.out.println(bl);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2 . Read File Using FileReader

		BufferedReader z = new BufferedReader(new FileReader("b.txt"));
		String line;

		try {
			while ((line = z.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}