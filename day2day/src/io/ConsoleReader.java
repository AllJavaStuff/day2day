package io;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader {

	public static void main(String[] args) {

		
		//1. Using Buffered Reader
		
		BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
		String l ;
		try {
			while ((l=a.readLine())!=null){
				System.out.println(l);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//2. using Scanner
		Scanner sc = new Scanner(System.in);
		String line;
		while ((line = sc.nextLine()) != null) {
			System.out.println(line);
		}

	}
}