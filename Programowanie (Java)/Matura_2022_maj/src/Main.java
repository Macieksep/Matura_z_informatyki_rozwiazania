import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/przyklad.txt");

        zad1(file, 200);
        System.out.println();

        zad2a(file, 200);
        zad2b(file, 200);
        System.out.println();

        zad3(file, 200);

    }

    static int zad1(File file, int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int liczba = 0;

        String current;
        String first = "";

        for (int i = 0; i < limit; i++) {

            current = scan.nextLine();

            if (current.charAt(0) == current.charAt(current.length()-1)){

                first = current;
                break;

            }

        }

        scan = new Scanner(file);

        for (int i = 0; i < limit; i++) {

            current = scan.nextLine();

            if (current.charAt(0) == current.charAt(current.length()-1)){

                liczba++;

            }

        }

        System.out.println(liczba + " " + first);

        return liczba;
    }

    static void zad2a(File file, int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int czynnikiMAX = 0;
        int liczbaMAX = 0;
        String currentLine = "";

        for (int i = 0; i < limit; i++) {

            currentLine = scan.nextLine();

            if (czynnikiMAX < czynniki(Integer.parseInt(currentLine))){
                czynnikiMAX = czynniki(Integer.parseInt(currentLine));
                liczbaMAX = Integer.parseInt(currentLine);
            }

        }

        System.out.print(liczbaMAX + " " + czynnikiMAX);

    }
    static void zad2b(File file, int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int czynnikiMAX = 0;
        int liczbaMAX = 0;
        String currentLine = "";

        for (int i = 0; i < limit; i++) {

            currentLine = scan.nextLine();

            if (czynnikiMAX < czynnikiPojedyncze(Integer.parseInt(currentLine))){
                czynnikiMAX = czynnikiPojedyncze(Integer.parseInt(currentLine));
                liczbaMAX = Integer.parseInt(currentLine);
            }

        }

        System.out.println(" " + liczbaMAX + " " + czynnikiMAX);

    }

    static void zad3(File file, int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int[] liczby = new int[limit];

        for (int i = 0; i < limit; i++) {

            liczby[i] = Integer.parseInt(scan.nextLine());

        }

        Set<String> trojki = new HashSet<>();

        for (int i = 0; i < limit; i++) {

            for (int j = 0; j < limit; j++) {

                for (int k = 0; k < limit; k++) {


                    if (!(liczby[i] == liczby[j] || liczby[j] == liczby[k])) {
                        if (czyTrojka(liczby[i], liczby[j], liczby[k])) {

                            trojki.add(liczby[i] + " " + liczby[j] + " " + liczby[k]);

                        }
                    }

                }

            }

        }

        System.out.println(trojki.size());

        Set<String> piatki = new HashSet<>();

        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                for (int k = 0; k < limit; k++) {
                    for (int l = 0; l < limit; l++) {
                        for (int m = 0; m < limit; m++) {

                            if (!(liczby[i] == liczby[j] || liczby[j] == liczby[k] || liczby[k] == liczby[l] || liczby[l] == liczby[m])) {
                                if (czyPiatka(liczby[i], liczby[j], liczby[k], liczby[l], liczby[m])) {

                                    piatki.add(liczby[i] + " " + liczby[j] + " " + liczby[k] + " " + liczby[l] + " " + liczby[m]);

                                }
                            }

                        }
                    }
                }
            }
        }

        System.out.println(piatki.size());

    }


    static int czynniki(int liczba){

        int czynnik = 0;

        do {

            if (liczba % 2 == 0){
                liczba /= 2;
                czynnik++;
            } else if (liczba % 3 == 0){
                liczba /= 3;
                czynnik++;
            } else if (liczba % 5 == 0){
                liczba /= 5;
                czynnik++;
            } else if (liczba % 7 == 0){
                liczba /= 7;
                czynnik++;
            } else if (liczba % 11 == 0){
                liczba /= 11;
                czynnik++;
            } else if (liczba % 13 == 0){
                liczba /= 13;
                czynnik++;
            } else if (liczba % 17 == 0){
                liczba /= 17;
                czynnik++;
            } else if (liczba % 19 == 0){
                liczba /= 19;
                czynnik++;
            } else if (liczba % 23 == 0){
                liczba /= 23;
                czynnik++;
            } else if (liczba % 29 == 0){
                liczba /= 29;
                czynnik++;
            } else {
                break;
            }

        } while (true);

        return czynnik;
    }

    static int czynnikiPojedyncze(int liczba){

        Set<Integer> czynniki = new HashSet<>();

        do {

            if (liczba % 2 == 0){
                liczba /= 2;
                czynniki.add(2);
            } else if (liczba % 3 == 0){
                liczba /= 3;
                czynniki.add(3);
            } else if (liczba % 5 == 0){
                liczba /= 5;
                czynniki.add(5);
            } else if (liczba % 7 == 0){
                liczba /= 7;
                czynniki.add(7);
            } else if (liczba % 11 == 0){
                liczba /= 11;
                czynniki.add(11);
            } else if (liczba % 13 == 0){
                liczba /= 13;
                czynniki.add(13);
            } else if (liczba % 17 == 0){
                liczba /= 17;
                czynniki.add(17);
            } else if (liczba % 19 == 0){
                liczba /= 19;
                czynniki.add(19);
            } else if (liczba % 23 == 0){
                liczba /= 23;
                czynniki.add(23);
            } else if (liczba % 29 == 0){
                liczba /= 29;
                czynniki.add(29);
            } else {
                break;
            }

        } while (true);

        return czynniki.size();
    }

    static boolean czyTrojka(int a, int b, int c){

        if (b%a == 0 && c%b == 0){

            return true;

        }

        return false;

    }

    static boolean czyPiatka(int a, int b, int c, int d, int e){

        if (b%a == 0 && c%b == 0 && d%c == 0 && e%d == 0){

            return true;

        }

        return false;

    }

}
