import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file1 = new File("src/dane1.txt");
		File file2 = new File("src/dane2.txt");
		
		int wiersze = 1000;
		
		zad1(file1, file2, wiersze);
		
		zad2(file1, file2, wiersze);
		
		zad3(file1, file2, wiersze);
		
		zad4(file1, file2, wiersze);
		
	}
	
	static void zad1(File file1, File file2, int linijki) throws FileNotFoundException {
		
		int ilosc = 0;
		
		for(int i = 1; i <= linijki; i++) {
			
			if (listaWiersza(file1, i).get(listaWiersza(file1, i).size()-1) == listaWiersza(file2, i).get(listaWiersza(file2, i).size()-1)) {
				
				ilosc++;
				
			}
			
		}
		
		System.out.println(ilosc);
		
	}

	static void zad2(File file1, File file2, int linijki) throws FileNotFoundException {
		
		int iloscP1;
		int iloscNP1;
		
		int iloscP2;
		int iloscNP2;
		
		int ilosc = 0;
		
		for(int i = 1; i <= linijki; i++) {
			
			iloscP1 = 0;
			iloscNP1 = 0;
			
			iloscP2 = 0;
			iloscNP2 = 0;
			
			List<Integer> lista1 = listaWiersza(file1, i);
			List<Integer> lista2 = listaWiersza(file2, i);
			
			for(int j = 0; j < lista1.size(); j++) {
				
				if (lista1.get(j) % 2 == 0) {
					iloscP1++;
				} else {
					iloscNP1++;
				}
				
				if (lista2.get(j) % 2 == 0) {
					iloscP2++;
				} else {
					iloscNP2++;
				}
				
			}
			
			if (iloscP1 == 5 && iloscP2 == 5 && iloscNP1 == 5 && iloscNP2 == 5) {
				ilosc++;
			}
			
		}
		
		System.out.println("\n" + ilosc);
		
	}
	
	static void zad3(File file1, File file2, int linijki) throws FileNotFoundException {

		
		
		int ilosc = 0;
		
		List<Integer> listaTEMP1;
		List<Integer> listaTEMP2;
		Set<Integer> lista1;
		Set<Integer> lista2;
		
		List<Integer> wiersze = new ArrayList<>();
		
		for(int i = 1; i <= linijki; i++) {
			
			listaTEMP1 = listaWiersza(file1, i);
			listaTEMP2 = listaWiersza(file2, i);
			
			lista1 = new HashSet<>();
			lista2 = new HashSet<>();
			
			for(int x : listaTEMP1) {
				
				lista1.add(x);
				
			}
			for(int x : listaTEMP2) {
				
				lista2.add(x);
				
			}
			
			if(lista1.equals(lista2)) {
				ilosc++;
				wiersze.add(i);
			}
			
		}
		
		System.out.println("\n" + ilosc);
		System.out.println("wiersze: " + wiersze);
		
	}

	static void zad4(File file1, File file2, int linijki) throws FileNotFoundException {
		
		System.out.println();
		
		for(int i = 1; i <= linijki; i++) {
			
			List<Integer> lista1 = listaWiersza(file1, i);
			List<Integer> lista2 = listaWiersza(file2, i);
			List<Integer> ciagDocelowy = new ArrayList<>();
			
			int a = 0;
			int b = 0;
			
			for(int j = 0; j < lista1.size()*2; j++) {
				
				if(a>=lista1.size()) {
					ciagDocelowy.add(lista2.get(b));
					b++;
				} else if(b>=lista1.size()) {
					ciagDocelowy.add(lista1.get(a));
					a++;
				} else {
				
					if(lista1.get(a) <= lista2.get(b)) {
						ciagDocelowy.add(lista1.get(a));
						a++;
					} else {
						ciagDocelowy.add(lista2.get(b));
						b++;
					}
					
				}
				
			}
			
			for(int x : ciagDocelowy) {
				
				System.out.print(x + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	static List<Integer> listaWiersza(File file, int linijka) throws FileNotFoundException{
		
		Scanner scan = new Scanner(file);
		
		for(int i = 1; i<=linijka; i++) {
			
			if(i == linijka) {
				
				return oddzielLiczby(scan.nextLine());
				
			}
			
			scan.nextLine();
			
		}
		
		return null;
	}
	
	static List<Integer> oddzielLiczby(String ciag){
		
		List<Integer> lista = new ArrayList<>();
		
		ciag = ciag +" ";
		
		while(ciag.length() > 0){
			
			lista.add(Integer.parseInt(ciag.substring(0, ciag.indexOf(' '))));
			
			ciag = ciag.substring(ciag.indexOf(' ')+1);
			
		}
		
		return lista;
		
	}
	
}
