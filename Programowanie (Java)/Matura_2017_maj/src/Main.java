import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> dane = dane(new File("src/dane.txt"));
		
		zad1(dane);
		
		zad2(dane);
		
		// mały błąd wychodzi, o 1 rozjeżdża się wynik!!!
		zad3(dane);
		
	}
	
	static void zad1(List<String> dane) {
		
		List<String> linijka;
		
		int min = 256;
		int max = -1;
		
		for(int i = 0; i < 200; i++) {
			
			linijka = linijka(dane.get(i));
			
			for(int j = 0; j < 320; j++) {
				
				if(Integer.parseInt(linijka.get(j)) > max) {
					max = Integer.parseInt(linijka.get(j));
				} else if(Integer.parseInt(linijka.get(j)) < min) {
					min = Integer.parseInt(linijka.get(j));
				}
				
			}
		}
		
		System.out.println(max + " " + min);
		
	}

	static void zad2(List<String> dane) {
		
		List<String> linijka;
		
		boolean git;
		
		int liczba = 0;
		
		for(int i = 0; i < 200; i++) {
			
			git = true;
			
			linijka = linijka(dane.get(i));
			
			for(int j = 0; j < 160; j++) {
				
				if(!linijka.get(j).equals(linijka.get(319-j))) {
					
					git = false;
					
				}
				
			}
			
			if(!git) {
				liczba++;
			}
			
		}
		
		System.out.println(liczba);
		
		
	}
	
	static void zad3(List<String> dane) {
		
		List<Integer> linijka;
		
		// X Y
		Set<String> lokacja = new HashSet<>();
		
		int liczba = 0;
		
		//poziomo
		
		//pierwsze
		for(int i = 0; i < 200; i++) {
			
			linijka = linijkaInt(dane.get(i));
			
			if(Math.abs(linijka.get(0) - linijka.get(1)) > 128) {
				
				lokacja.add("0" + " " + i);

			}
			
		}
		
		//ostatnie
		for(int i = 0; i < 200; i++) {
			
			linijka = linijkaInt(dane.get(i));
			
			if(Math.abs(linijka.get(318) - linijka.get(319)) > 128) {
				
				lokacja.add("199" + " " + i);
				
			}
			
		}
		
		//środkowe
		for(int i = 0; i < 200; i++) {
			
			linijka = linijkaInt(dane.get(i));
			
			for(int j = 1; j < 319; j++) {
				
				if(Math.abs(linijka.get(j) - linijka.get(j-1)) > 128 || Math.abs(linijka.get(j) - linijka.get(j+1)) > 128) {
					
					lokacja.add(j + " " + i);
					
				}
				
			}
			
		}
		
		//pion
		
		List<Integer> kolumna;
		
		//pierwsze
		for(int i = 0; i < 200; i++) {
			
			kolumna = kolumnaInt(dane, i);
			
			if(Math.abs(kolumna.get(0) - kolumna.get(1)) > 128) {
				
				lokacja.add(i + " " + "0");
				
			}
			
		}
		
		//ostatnie
		for(int i = 0; i < 200; i++) {
			
			kolumna = kolumnaInt(dane, i);
			
			if(Math.abs(kolumna.get(198) - kolumna.get(199)) > 128) {
				
				lokacja.add(i + " " + "199");
				
			}
			
		}
		
		//środkowe
		for(int i = 0; i < 320; i++) {
			
			kolumna = kolumnaInt(dane, i);
			
			for(int j = 1; j < 199; j++) {
				
				if(Math.abs(kolumna.get(j) - kolumna.get(j-1)) > 128 || Math.abs(kolumna.get(j) - kolumna.get(j+1)) > 128) {
					
					lokacja.add(i + " " + j);
					
				}
				
			}
			
		}
		
		System.out.println(lokacja.size());
		
	}
	
	
	static List<String> dane(File file) throws FileNotFoundException{
		
		List<String> dane = new ArrayList<>();
		
		Scanner scan = new Scanner(file);
		
		for(int i = 0; i < 200; i++) {
			
			dane.add(scan.nextLine());
			
		}
		
		return dane;
	}
	
	static List<String> linijka(String linijka){
		
		List<String> dane = new ArrayList<>();
		
		linijka = linijka + " ";
		
		for(int i = 0; i < 320; i++) {
			
			dane.add(linijka.substring(0, linijka.indexOf(" ")));
			
			
			
			linijka = linijka.substring(linijka.indexOf(" ")+1);
			
		}
		
		return dane;
	}

	static List<Integer> linijkaInt(String linijka){
		
		List<Integer> dane = new ArrayList<>();
		
		linijka = linijka + " ";
		
		for(int i = 0; i < 320; i++) {
			
			dane.add(Integer.parseInt(linijka.substring(0, linijka.indexOf(" "))));
			
			
			
			linijka = linijka.substring(linijka.indexOf(" ")+1);
			
		}
		
		return dane;
	}
	
	static List<Integer> kolumnaInt(List<String> dane, int nr){
		
		List<Integer> liczby = new ArrayList<>();
		
		List<Integer> linijka;
		
		for(int i = 0; i < 200; i++) {
			
			linijka = linijkaInt(dane.get(i));
			
			liczby.add(linijka.get(nr));
			
		}
		
		return liczby;
	}
	
}
