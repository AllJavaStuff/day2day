package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileReadWrite {

	public static void main(String[] args) throws FileNotFoundException {

		// 1 . Read File Using BufferedReader

		BufferedReader b = new BufferedReader(new InputStreamReader(
				new FileInputStream("Resource/a.txt")));
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
		
		
		System.out.println("---------------------------------------------------------");

		// 2 . Read File Using FileReader

		BufferedReader z = new BufferedReader(new FileReader("Resource/b.txt"));
		String line;

		try {
			while ((line = z.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("---------------------------------------------------------");
		// 3 . Read file using Scanner ( for small file)

		Scanner s = new Scanner(new BufferedReader(new FileReader(
				"Resource/a.txt")));
		String l;
		while (s.hasNext()) {
			l = s.next();
			System.out.println(l);

		}
		System.out.println("---------------------------------------------------------");

		// 4. Read all bytes of file Using Java NIO Files Utility , Since java 1.7
		//Path p = Paths.get("Resource", "a.txt");
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
		
		System.out.println("---------------------------------------------------------");
		
		//5. Read all lines of Files using Java NIO Files Utility , since java 1.7
		
	   // Charset charset = Charset.forName("ISO-8859-1");
		Charset charset = StandardCharsets.ISO_8859_1;
		Path p2 = new File("Resource/a.txt").toPath();
	    
	    try {
			List<String> lines = Files.readAllLines(p2, charset);
			for(String s1 : lines ){
				System.out.println(s1);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}