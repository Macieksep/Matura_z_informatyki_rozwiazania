import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("src/instrukcje.txt");
		
		List<String> komenda = dane(file, true, 2000);
		List<String> litera = dane(file, false, 2000);
		
		zad1(komenda, litera);
		
		zad2(komenda, litera);
		
		// Jak coś jest głupie i działa to znaczy, że nie jest głupie XD
		zad3(komenda, litera);
		
		zad4(komenda, litera);
 		
	}
	static void zad1(List<String> komenda, List<String> litera) {
		
		StringBuilder wyraz = new StringBuilder();
		
		for(int i = 0; i < komenda.size(); i++) {
			
			if(komenda.get(i).equals("DOPISZ")) {
				
				wyraz.append(litera.get(i));
				
			} else if(komenda.get(i).equals("ZMIEN")) {
				
				wyraz = new StringBuilder(wyraz.substring(0, wyraz.length()-1));
				wyraz.append(litera.get(i));
				
			} else if(komenda.get(i).equals("USUN")) {
				
				wyraz = new StringBuilder(wyraz.substring(0, wyraz.length()-Integer.parseInt(litera.get(i))));
				
			} else if(komenda.get(i).equals("PRZESUN")) {
				
				char a = litera.get(i).charAt(0);
				
				if (a != 'Z') {
					a +=1;
				} else {
					a = 'A';
				}
				
				wyraz.replace(wyraz.indexOf(litera.get(i)), wyraz.indexOf(litera.get(i))+1, String.valueOf(a));
				
			}
			
			
		}
		
		System.out.println(wyraz.length());
		
	}

	static void zad2(List<String> komenda, List<String> litera) {
		
		int MAX_L = 0;
		int L = 1;
		
		String last_komenda = komenda.get(1);
		String MAX_komenda = "X";
		
		for(int i = 0; i < komenda.size(); i++) {
			
//			if(komenda.get(i).equals("DOPISZ")) {
//				
//				
//				
//			} else if(komenda.get(i).equals("ZMIEN")) {
//				
//				
//				
//			} else if(komenda.get(i).equals("USUN")) {
//				
//				
//				
//			} else if(komenda.get(i).equals("PRZESUN")) {
//				
//				
//				
//			}

			if(last_komenda.equals(komenda.get(i))) {
				L++;
			} else {
				L =1;
			}
			
			if(L > MAX_L) {
				
				MAX_L = L;
				MAX_komenda = komenda.get(i);
				
			}
			
			last_komenda = komenda.get(i);
			
		}
		
		System.out.println(MAX_komenda + " " + MAX_L);
		
	}
	
	static void zad3(List<String> komenda, List<String> litera) {
		
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int E = 0;
		int F = 0;
		int G = 0;
		int H = 0;
		int I = 0;
		int J = 0;
		int K = 0;
		int L = 0;
		int M = 0;
		int N = 0;
		int O = 0;
		int P = 0;
		int R = 0;
		int S = 0;
		int T = 0;
		int U = 0;
		int W = 0;
		int X = 0;
		int Y = 0;
		int Z = 0;
		
		StringBuilder wyraz = new StringBuilder();
		
		for(int i = 0; i < komenda.size(); i++) {
			
			if(komenda.get(i).equals("DOPISZ")) {
				
				if(litera.get(i).equals("A")) {
					A++;
				} else if(litera.get(i).equals("B")) {
					B++;
				} else if(litera.get(i).equals("C")) {
					C++;
				} else if(litera.get(i).equals("D")) {
					D++;
				} else if(litera.get(i).equals("E")) {
					E++;
				} else if(litera.get(i).equals("F")) {
					F++;
				} else if(litera.get(i).equals("G")) {
					G++;
				} else if(litera.get(i).equals("H")) {
					H++;
				} else if(litera.get(i).equals("I")) {
					I++;
				} else if(litera.get(i).equals("J")) {
					J++;
				} else if(litera.get(i).equals("K")) {
					K++;
				} else if(litera.get(i).equals("L")) {
					L++;
				} else if(litera.get(i).equals("M")) {
					M++;
				} else if(litera.get(i).equals("N")) {
					N++;
				} else if(litera.get(i).equals("O")) {
					O++;
				} else if(litera.get(i).equals("P")) {
					P++;
				} else if(litera.get(i).equals("R")) {
					R++;
				} else if(litera.get(i).equals("S")) {
					S++;
				} else if(litera.get(i).equals("T")) {
					T++;
				} else if(litera.get(i).equals("U")) {
					U++;
				} else if(litera.get(i).equals("W")) {
					W++;
				} else if(litera.get(i).equals("X")) {
					X++;
				} else if(litera.get(i).equals("Y")) {
					Y++;
				} else if(litera.get(i).equals("Z")) {
					Z++;
				}
				
			} 
			
		}
		
		
		/*
		System.out.println(A + "\n" + B  + "\n" + C + "\n"+ D+ "\n"+E+ "\n"+F+ "\n"+G + "\n"+H + "\n"+I + "\n"+J
				+ "\n"+K+ "\n"+L+ "\n"+M+ "\n"+N+ "\n"+O+ "\n"+P+ "\n"+R+ "\n"+S+ "\n"+T+ "\n"+U+ "\n"+W+ "\n"+X+ "\n"+Y+ "\n"+Z);
		*/
		
		System.out.println("Z: " + Z);
		
	}
	
	static void zad4(List<String> komenda, List<String> litera) {
		
		StringBuilder wyraz = new StringBuilder();
		
		for(int i = 0; i < komenda.size(); i++) {
			
			if(komenda.get(i).equals("DOPISZ")) {
				
				wyraz.append(litera.get(i));
				
			} else if(komenda.get(i).equals("ZMIEN")) {
				
				wyraz = new StringBuilder(wyraz.substring(0, wyraz.length()-1));
				wyraz.append(litera.get(i));
				
			} else if(komenda.get(i).equals("USUN")) {
				
				wyraz = new StringBuilder(wyraz.substring(0, wyraz.length()-Integer.parseInt(litera.get(i))));
				
			} else if(komenda.get(i).equals("PRZESUN")) {
				
				char a = litera.get(i).charAt(0);
				
				if (a != 'Z') {
					a +=1;
				} else {
					a = 'A';
				}
				
				wyraz.replace(wyraz.indexOf(litera.get(i)), wyraz.indexOf(litera.get(i))+1, String.valueOf(a));
				
			}
			
			
		}
		
		System.out.println(wyraz);
		
	}
	
	
	static List<String> dane(File file, boolean czyKomenda, int linijki) throws FileNotFoundException{
		
		List<String> dane = new ArrayList<>();
		
		Scanner scan = new Scanner(file);
		
		String TEMP;
		
		for(int i = 0; i < linijki; i++) {
			
			TEMP = scan.nextLine();
			
			if(czyKomenda) {
				dane.add(TEMP.substring(0, TEMP.indexOf(' ')));
			} else {
				dane.add(TEMP.substring(TEMP.indexOf(' ')+1));
			}
			
		}
		
		return dane;
	}

	
}
