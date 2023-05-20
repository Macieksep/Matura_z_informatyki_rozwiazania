import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> dane = dane(new File("src/liczby.txt"));
		
		zad1(dane);
		
		zad2(dane);
		
		zad3(dane);
		
	}
	
	static void zad1(List<String> dane) {
		
		int temp0;
		int temp1;
		
		int liczba=0;
		
		for(int i = 0; i < dane.size(); i++) {
			
			temp0 = 0;
			temp1 = 0;
			
			for(int j = 0; j < dane.get(i).length(); j++) {
				
				if(dane.get(i).charAt(j) == '0') {
					temp0++;
				} else {
					temp1++;
				}
				
			}
			
			if (temp0 > temp1) {
				liczba++;
			}
			
		}
		
		System.out.println(liczba);
		
	}
	
	static void zad2(List<String> dane) {
		
		System.out.println(dane.get(0).substring(dane.get(0).length()-1));
		System.out.println(dane.get(0).substring(dane.get(0).length()-3));
		
		int p2 = 0;
		int p8 = 0;
		
		for(int i = 0; i < dane.size(); i++) {
			
			if(dane.get(i).substring(dane.get(i).length()-1).equals("0")) {
				p2++;
				
				if(dane.get(i).substring(dane.get(i).length()-3).equals("000")) {
					p8++;
				}
				
			}
			
		}
		
		System.out.println("2 " + p2 + " 8 " + p8);
		
	}

	static void zad3(List<String> dane) {
		
		int max = 200;
		int min = 3;
		
		List<String> male = new ArrayList<>();
		List<String> duze = new ArrayList<>();
		
		for(int i = 0; i < dane.size(); i++) {
			
			if(dane.get(i).length() == 200) {
				duze.add(dane.get(i));
			} else if(dane.get(i).length() == 3) {
				male.add(dane.get(i));
			}
			
		}
		
		min = 999;
		
		for(int i = 0; i < male.size(); i++) {
			
			if(Integer.valueOf(male.get(i), 2) < min) {
				min = Integer.valueOf(male.get(i), 2);
			}
			
		}
		
		String minBin = Integer.toBinaryString(min);
		
		System.out.println(minBin);
		
		List<String> duzeTemp = duze;
		
		List<String> duzeTemp2 = duzeTemp;
		
		boolean istnieje = false;
		
		//	Sprawdzenie największej liczby. 
		//	Należy podmieniać zasięg substringa i dodawać '1' do equals aż zostanie 1 odpowiedz
		// 	Metoda jest prymitywna, lecz najprostsza i najszybsza
		
		String maxStr = "";
		
		for(String x : duze) {
			if(x.substring(0, 9).equals("111111111")) {
				maxStr = x;
			}
		}
		
		int minID = -1;
		int maxID = -1;
		
		for(int i = 0; i < dane.size(); i++) {
			
			if(dane.get(i).equals(minBin)) {
				minID = i;
			} else if(dane.get(i).equals(maxStr)) {
				maxID = i;
			}
			
		}
		
		System.out.println("max:");
		System.out.println(maxID+1 + " " + maxStr);
		System.out.println("min:");
		System.out.println(minID+1 + " " + minBin);
		
	}
	
	
	static List<String> dane(File file) throws FileNotFoundException{
		
		Scanner scan = new Scanner(file);
		
		List<String> dane = new ArrayList<>();
		
		for(int i = 0; i < 1000; i++) {
			
			dane.add(scan.nextLine());
			
		}
		
		return dane;
		
	}
	
}
