import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		
		File file = new File("src/punkty.txt");
		
		List<Integer> X = liczba(file, false);
		List<Integer> Y = liczba(file, true);
		
		zad1(X, Y);
		
		zad2(X, Y);
		
		zad3(X, Y);
		
		zad4(X, Y);
		
	}
	
	static void zad1(List<Integer> X, List<Integer> Y) {
		
		int ilosc = 0;
		
		for(int i = 0; i < 1000; i++) {
			
			if(czyPierwsza(X.get(i)) && czyPierwsza(Y.get(i))) {
				ilosc++;
			}
			
		}
		
		System.out.println(ilosc);
		
	}
	
	static void zad2(List<Integer> X, List<Integer> Y) {
		
		int ilosc = 0;
		
		Set<Character> cyfryX;
		Set<Character> cyfryY;
		
		for(int i = 0; i < 1000; i++) {
			
			cyfryX = new HashSet<>();
			cyfryY = new HashSet<>();
			
			
			for(int j = 0; j < String.valueOf(X.get(i)).length(); j++) {
				cyfryX.add(String.valueOf(X.get(i)).charAt(j));
			}
			
			for(int j = 0; j < String.valueOf(Y.get(i)).length(); j++) {
				cyfryY.add(String.valueOf(Y.get(i)).charAt(j));
			}
			
			
			if(cyfryX.equals(cyfryY)) {
				ilosc++;
			}
			
		}
		
		System.out.println("\n" + ilosc);
		
	}

	static void zad3(List<Integer> X, List<Integer> Y) {
		
		int ilosc = 0;
		
		double MAX = -1;
		double MAXtemp;
		int A = -1;
		int B = -1;
		
		for(int i = 0; i < 1000; i++) {
			
			for(int j = 0; j < 1000; j++) {
				
				MAXtemp = Math.sqrt(Math.pow(X.get(i) - X.get(j), 2) + Math.pow(Y.get(i) - Y.get(j), 2));
				
				if(MAXtemp > MAX) {
					
					MAX = MAXtemp;
					
					A = i;
					B = i;
					
				}
				
			}
			
		}
		
		System.out.println("\n" + "A: " + X.get(A) + " " + Y.get(A) + " B: " + X.get(B) + " " + Y.get(B));
		System.out.println(Math.round(MAX));
		
	}
	
	static void zad4(List<Integer> X, List<Integer> Y) {
		
		int a = 0; 
		int b = 0;
		int c = 0;
		
		for(int i = 0; i < 1000; i++) {
			
			if(X.get(i) < 5000 && Y.get(i) < 5000) {
				a++;
			} else if(X.get(i) == 5000 && Y.get(i) <= 5000) {
				b++;
			} else if(X.get(i) <= 5000 && Y.get(i) == 5000) {
				b++;
			} else if(X.get(i) > 5000 || Y.get(i) > 5000) {
				c++;
			}
			
		}
		
		System.out.println("\nwewnatrz: " + a + " na boku: " + b + "  zewnatrz: " + c);
		
	}
	
	
	static List<Integer> liczba(File file, boolean druga) throws FileNotFoundException{
		
		Scanner scan = new Scanner(file);
		
		List<Integer> liczba = new ArrayList<>();
		
		String TEMP;
		
		for(int i = 0; i < 1000; i++) {
			
			TEMP = scan.nextLine();
			
			if(druga) {
				
				liczba.add(Integer.parseInt(TEMP.substring(TEMP.indexOf(' ')+1)));
				
			} else {
				
				liczba.add(Integer.parseInt(TEMP.substring(0, TEMP.indexOf(' '))));
				
			}
			
		}
		
		return liczba;
		
	}
	
	static boolean czyPierwsza(int a) {
		
		if (a == 1 || a == 0) {
			
			return false;
			
		} else if (a == 2) {
			
			return true;
			
		} else if (a % 2 == 0) {
			
			return false;
			
		}
		
		for(int i = 3; i < a; i+=2) {
			
			if(a % i == 0) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
}
