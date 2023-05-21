import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Integer> dane = dane(new File("src/liczby.txt"));
		
		zad1(dane);
		
		zad2(dane);
		
		// na tym poległem :(
		//zad3(dane);
				
	}
	static void zad1(List<Integer> dane) {
		
		int liczba = 0;
		
		for(int i = 0 ; i < 500; i++) {
			
			if(dane.get(i) % 3 == 0) {
				
				for(int j = 3; j <= dane.get(i); j*=3) {
					
					if(j == dane.get(i)) {
						liczba++;
					}
					
				}
				
			} else if(dane.get(i) == 1) {
				liczba++;
			}
			
		}
		
		System.out.println(liczba);
		
	}
	
	static void zad2(List<Integer> dane) {

		
		for(int i = 0 ; i < 500; i++) {
			
			int TEMP = 0;
			
			String cyfry = Integer.toString(dane.get(i));
			
			for(int j = 0; j < cyfry.length(); j++) {
				
				TEMP += silnia(Integer.valueOf(String.valueOf(cyfry.charAt(j))));
				
				
			}
			
			if(TEMP == dane.get(i)) {
				System.out.println(TEMP);
			}
			
		}
		
		
	}

	// :(
	static void zad3(List<Integer> dane) {
		
		int MAX = 1;
		
		int TEMP_MAX = 1;
		
		int NWD_temp;
		
		boolean git;
		
		for(int i = 1; i < 500; i++) {
			
			git = true;
			
			NWD_temp = NWD(dane.get(i-1), dane.get(i));
			
			if(NWD_temp != 1) {
				
				for(int j = i+1; git; j++) {
					
					NWD_temp = NWD(NWD_temp, dane.get(j));
					
					if(NWD_temp != 1) {
						TEMP_MAX++;
					} else {
						git= false;
						TEMP_MAX = 1;
					}
					
				}
			} else {
				TEMP_MAX =1;
			}
			
			//update maxa
			if(MAX < TEMP_MAX) {
				MAX = TEMP_MAX;
			}
			
		}
		
		System.out.println(MAX);
		
	}
	
	
	static List<Integer> dane(File file) throws FileNotFoundException{
		
		List<Integer> dane = new ArrayList<>();
		
		Scanner scan = new Scanner(file);
		
		for(int i = 0; i < 500; i++) {
			
			dane.add(Integer.parseInt(scan.nextLine()));
			
		}
		
		return dane;
		
	}
	
	static int silnia(int a) {
		
		int x = 1;
		
		if(a == 0) {
			return x;
		}
		
		for(int i = 1; i <= a ; i++) {
			
			x *= i;
			
		}
		
		return x;
		
	}
	
	static int NWD(int a, int b) {
		
		while(a != b) {
			
			if (a>b) {
				
				a -= b;
				
			} else {
				
				b -= a;
				
			}
			
		}
		
		return a;
		
	}
	
}
