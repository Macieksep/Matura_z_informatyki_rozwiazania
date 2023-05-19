import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Integer> dane = dane(new File("src/dane.txt"));
		List<Integer> lucky = lucky(luckyTEMP(10000), 1);
		
		//System.out.println(lucky);
		
		zad1(lucky, dane);
		
		zad2(lucky, dane);
		
		zad3(lucky, dane);
		
	}
	
	static void zad1(List<Integer> lucky, List<Integer> dane) {
		
		int liczba = 0;
		
		for(int i = 0; i < dane.size(); i++) {
			if(lucky.contains(dane.get(i))) {
				liczba++;
			}
		}
		
		System.out.println(liczba);
		
	}
	
	static void zad2(List<Integer> lucky, List<Integer> dane) {
		
		for(int i = 0; i < dane.size(); i++) {
			if(!lucky.contains(dane.get(i))) {
				dane.set(i, 0);
			}
		}
		
		int pierwsza = dane.get(0);
		int liczba = 0;
		
		int pierwszaMAX = dane.get(0);
		int liczbaMAX = 0;
		
		
		for(int i = 0; i < dane.size(); i++) {
			
			if(dane.get(i) != 0) {
				liczba++;
				
				
				
			} else {
				if(i < dane.size()-1) {
				pierwsza = dane.get(i+1);
				}
				liczba = 0;
			}
			
			if(liczbaMAX < liczba) {
				liczbaMAX = liczba;
				pierwszaMAX = pierwsza;
			}
			
		}
		
		System.out.println("\n" + pierwszaMAX + " " + liczbaMAX);
		
	}

	static void zad3(List<Integer> lucky, List<Integer> dane) {
		
		int liczba = 0;
		
		for(int i = 0; i < dane.size(); i++) {
			if(lucky.contains(dane.get(i)) && czyPierwsza(dane.get(i))) {
				liczba++;
			}
		}
		
		System.out.println( "\n"+ liczba);
		
	}
	
	
	static List<Integer> dane(File file) throws FileNotFoundException{
		
		List<Integer> dane = new ArrayList<>();
		
		Scanner scan = new Scanner(file);
		
		for(int i = 0; i < 2526; i++) {
			dane.add(Integer.parseInt(scan.nextLine()));
		}
		
		return dane;
		
	}
	
	static List<Integer> luckyTEMP(int max){
		
		List<Integer> lucky = new ArrayList<>();
		
		for(int i = 1; i <= max; i ++) {
			if(i % 2 != 0) {
				lucky.add(i);
			}
		}
		
		return lucky;
		
	}
	
	static List<Integer> lucky(List<Integer> lucky, int nr){
		
		for(int i = lucky.get(nr)-1; i < lucky.size(); i += lucky.get(nr)) {
			
			lucky.remove(i);
			i--;
			
		}
		
		try {
		return lucky(lucky, nr+1);
		} catch(Exception e) {
			return lucky;
		}
		
	}
	
	static boolean czyPierwsza(int a) {
		
		if(a <=1) {
			return false;
		}else if (a == 2 || a == 3) {
			return true;
		} else if (a % 2 == 0) {
			return false;
		}
		
		for(int i = 3; i < a; i += 2) {
			
			if(a % i == 0) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
}
