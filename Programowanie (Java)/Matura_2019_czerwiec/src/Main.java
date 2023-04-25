import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<Integer> linijki = linijki(new File("src/liczby.txt"));
        List<Integer> linijki2 = linijki(new File("src/pierwsze.txt"));

        zad1(linijki);
        System.out.println();

        zad2(linijki2);
        System.out.println();

        zad3(linijki2);

    }

    static List<Integer> linijki(File file) throws FileNotFoundException{

        List<Integer> linijki = new ArrayList<>();

        Scanner scan = new Scanner(file);

        while (scan.hasNext()){

            linijki.add(scan.nextInt());

        }

        return linijki;

    }

    static void zad1(List<Integer> lista){

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) >= 100 && lista.get(i) <= 5000){

                if (czyPierwsza(lista.get(i))){
                    System.out.println(lista.get(i));
                }

            }

        }

    }

    static void zad2(List<Integer> lista){

        for (int i = 0; i < lista.size(); i++) {

            if (czyPierwsza(odwrot(lista.get(i)))) {
                System.out.println(lista.get(i));
            }

        }

    }

    static void zad3(List<Integer> lista){

        int wynik = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (w(lista.get(i)) == 1){
                wynik++;
            }

        }

        System.out.println(wynik);

    }


    static boolean czyPierwsza(int a){


        for (int i = 2; i < a; i++) {

            if (a % i == 0){
                return false;
            }

        }

        if (a == 1){
            return false;
        }

        return true;

    }

    static int odwrot(int a){

        String temp = String.valueOf(a);

        StringBuilder wynik = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {

            wynik.append(temp.charAt(temp.length()-i-1));

        }

        return Integer.parseInt(wynik.toString());

    }

    static int w(int N){

        String temp = String.valueOf(N);

        int suma = 0;

        for (int i = 0; i < temp.length(); i++) {

            suma += Integer.parseInt(String.valueOf(temp.charAt(i)));

        }

        if (String.valueOf(suma).length() == 1){
            return suma;
        } else {
            return w(suma);
        }

    }

}
