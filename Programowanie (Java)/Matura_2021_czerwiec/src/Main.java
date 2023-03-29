import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(zad1(new File("src/napisy.txt")) + "\n");

        System.out.println(zad2(new File("src/napisy.txt")) + "\n");

        System.out.println(zad3(new File("src/napisy.txt")) + "\n");

        zad4(new File("src/napisy.txt"));

    }

    static int zad1(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int cyfry = 0;

        String wierszTEMP;

        String regex = "[0-9]";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < 1000; i++) {

            wierszTEMP = scan.nextLine();

            for (int j = 0; j < wierszTEMP.length(); j++) {

                if (pattern.matcher(String.valueOf(wierszTEMP.charAt(j))).matches()){

                    cyfry++;

                }

            }

        }

        return cyfry;

    }

    static String zad2(File file) throws FileNotFoundException {

        StringBuilder haslo = new StringBuilder();

        Scanner scan = new Scanner(file);

        int j = 0;
        String TEMP = "";

        for (int i = 1; i < 1001; i++) {

            TEMP = scan.nextLine();

            if (i % 20 == 0) {
                haslo.append(TEMP.charAt(j));
                j++;
            }

        }

        return haslo.toString();

    }

    static String zad3(File file) throws FileNotFoundException{

        StringBuilder haslo = new StringBuilder();

        Scanner scan = new Scanner(file);

        StringBuilder TEMP;

        for (int i = 0; i < 1000; i++) {

            TEMP = new StringBuilder(scan.nextLine());
            TEMP.append(TEMP.charAt(0));

            if (czyPalindrom(TEMP.toString())){

                haslo.append(TEMP.charAt(TEMP.length()/2));

            } else {

                TEMP.deleteCharAt(TEMP.length()-1);
                TEMP = new StringBuilder(String.valueOf(TEMP.charAt(TEMP.length()-1)) + TEMP);

                if (czyPalindrom(TEMP.toString())){

                    haslo.append(TEMP.charAt(TEMP.length()/2));

                }

            }

        }

        return haslo.toString();
    }

    static void zad4(File file) throws FileNotFoundException {

        StringBuilder haslo = new StringBuilder();

        Scanner scan = new Scanner(file);

        String TEMP;
        List<String> liczba;
        int liczbaX = 0;

        for (int i = 0; i < 1000; i++) {

            TEMP = scan.nextLine();
            liczba = liczby(TEMP);

            liczba.removeIf(x -> Integer.parseInt(x) > 90 || Integer.parseInt(x) < 65);

            for (String x:
                 liczba) {

                haslo.append((char)(Integer.parseInt(x)));

            }

        }

        for (int i = 0; i < haslo.length(); i++) {

            if (haslo.charAt(i) == 'X'){
                liczbaX++;

                if (liczbaX == 3){

                    haslo = new StringBuilder(haslo.subSequence(0, i+1));

                }

            } else {

                liczbaX = 0;

            }

        }

        System.out.println(haslo);

    }


    static boolean czyPalindrom(String str){

        for (int i = 0; i < str.length()/2+1; i++) {

            if (!(str.charAt(i) == str.charAt(str.length()-i-1))){

                return false;

            }

        }

        return true;

    }

    static List<String> liczby(String string){


        List<String> liczba = new ArrayList<>();


        int cyfry = 0;

        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);

        //liczba cyfr
        for (int i = 0; i < string.length(); i++) {

            if (pattern.matcher(String.valueOf(string.charAt(i))).matches()){

                cyfry++;

            }

        }



        StringBuilder TEMP = new StringBuilder();

        if (cyfry % 2 == 0) {

            for (int i = 0; i < string.length(); i++) {

                if (pattern.matcher(String.valueOf(string.charAt(i))).matches()) {

                    TEMP.append(string.charAt(i));

                    if (TEMP.length() == 2){

                        liczba.add(TEMP.toString());
                        TEMP = new StringBuilder();

                    }

                }

            }

        } else {

            for (int i = 0; i < string.length(); i++) {

                if (pattern.matcher(String.valueOf(string.charAt(i))).matches()) {

                    TEMP.append(string.charAt(i));

                    if (TEMP.length() == 2){

                        liczba.add(TEMP.toString());
                        TEMP = new StringBuilder();

                    } else if (TEMP.length() == 1 && cyfry == 1){

                        liczba.add(TEMP.toString());
                        TEMP = new StringBuilder();

                    }

                    cyfry--;
                }

            }

        }

        return liczba;

    }

}
