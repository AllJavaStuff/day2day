package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileReadWrite {

	public static void main(String[] args) throws FileNotFoundException {

		// Read operation
		// 1 . Read File Using BufferedReader

		readFileUsingBufferedReader();

		System.out
				.println("---------------------------------------------------------");

		// 2 . Read File Using FileReader

		readFileUsingFileReader();

		System.out
				.println("---------------------------------------------------------");

		// 3 . Read file using Scanner ( for small file)

		readFileUsingScanner();

		System.out
				.println("---------------------------------------------------------");

		// 4. Read all bytes of file Using Java NIO Files Utility , Since java
		// 1.7

		readFileBytesUsingFilesNio();

		System.out
				.println("---------------------------------------------------------");

		// 5. Read all lines of Files using Java NIO Files Utility , since java
		// 1.7

		readFileLinesUsingFilesNio();

		// Write Operation

		String data = "this is my content 1st line \n here is second line";

		// 1 . Write using BufferedWriter

		writeUsingBufferedWriter(data);

		// 2 . Write Using FileWriter

		writeUsingFileWriter(data);

		// 3. write Using PrintWriter

		WriteUsingPrintWriter(data);

		// 4 . Write Using Files Nio Utility

		writeUsingFilesNio(data);

	}

	private static void writeUsingFilesNio(String data) {
		// TODO Auto-generated method stub
		try {
			Files.write(new File("Resource/z.txt").toPath(), data.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void WriteUsingPrintWriter(String data) {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Resource/z.txt",
					true));

			// if append is not required , can use below as well
			// PrintWriter pw = new PrintWriter("Resource/z.txt");
			pw.println(data);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeUsingFileWriter(String data) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("Resource/z.txt", true);
			fw.write(data);
			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeUsingBufferedWriter(String data) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("Resource/z.txt")));
			bw.write(data);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readFileLinesUsingFilesNio() {
		// TODO Auto-generated method stub
		// Charset charset = Charset.forName("ISO-8859-1");
		Charset charset = StandardCharsets.ISO_8859_1;
		Path p2 = new File("Resource/a.txt").toPath();

		try {
			List<String> lines = Files.readAllLines(p2, charset);
			for (String s1 : lines) {
				System.out.println(s1);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readFileBytesUsingFilesNio() {
		// TODO Auto-generated method stub
		// Path p = Paths.get("Resource", "a.txt");
		Path p = new File("Resource/a.txt").toPath();

		byte[] bArray;
		try {

			bArray = Files.readAllBytes(p);
			String bString = new String(bArray);

			System.out.println(bString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readFileUsingScanner() {
		// TODO Auto-generated method stub
		Scanner s;
		try {
			s = new Scanner(
					new BufferedReader(new FileReader("Resource/a.txt")));
			String l;
			while (s.hasNext()) {
				l = s.next();
				System.out.println(l);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readFileUsingFileReader() {
		// TODO Auto-generated method stub
		try {
			BufferedReader z = new BufferedReader(new FileReader(
					"Resource/b.txt"));
			String line;

			while ((line = z.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readFileUsingBufferedReader() {
		// TODO Auto-generated method stub
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					new FileInputStream("Resource/a.txt")));
			// BufferedReader b = new BufferedReader(new
			// InputStreamReader(System.in));
			String bl;

			while ((bl = b.readLine()) != null) {
				System.out.println(bl);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}