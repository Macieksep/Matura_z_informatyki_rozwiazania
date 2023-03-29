import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        zad1(new File("src/liczby.txt"));
        System.out.println();

        zad2(new File("src/liczby.txt"));
        System.out.println();

        zad3(new File("src/liczby.txt"));
        System.out.println();

        zad4(new File("src/liczby.txt"));

    }

    static void zad1(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        String TEMP;

        for (int i = 0; i < 100; i++) {

            TEMP = odwot(scan.nextLine());

            if (Integer.parseInt(TEMP) % 17 == 0){

                System.out.println(TEMP);

            }

        }



    }

    static void zad2(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        int MAX = 0;
        String MAX_n = "";

        String TEMP;

        for (int i = 0; i < 100; i++) {

            TEMP = scan.nextLine();

            if (Math.abs(Integer.parseInt(TEMP) - Integer.parseInt(odwot(TEMP))) > MAX){

                MAX = Math.abs(Math.abs(Integer.parseInt(TEMP) - Integer.parseInt(odwot(TEMP))));
                MAX_n = TEMP;

            }

        }

        System.out.println(MAX_n + " " + MAX);

    }

    static void zad3(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        String TEMP;

        for (int i = 0; i < 100; i++) {

            TEMP = scan.nextLine();

            if (czyPierwsza(Integer.parseInt(TEMP)) && czyPierwsza(Integer.parseInt(odwot(TEMP)))){

                System.out.println(TEMP);

            }

        }

    }

    static void zad4(File file) throws FileNotFoundException {

        int linijki = 100;

        Scanner scan = new Scanner(file);

        // a)
        Set<String> liczbyA = new HashSet<>();

        for (int i = 0; i < linijki; i++) {

            liczbyA.add(scan.nextLine());

        }

        System.out.println(liczbyA.size());


        // b)

        List<String> liczbyB = new ArrayList<>();
        scan = new Scanner(file);

        for (int i = 0; i < linijki; i++) {

            liczbyB.add(scan.nextLine());

        }

        Collections.sort(liczbyB);

        String ostatni = liczbyB.get(0);
        int powtarzanieTEMP = 1;
        int powtarzanieB = 0;
        int powtarzanieC = 0;

        for (int i = 1; i < linijki; i++) {

            if (liczbyB.get(i).equals(ostatni)){

                powtarzanieTEMP++;

            } else {

                powtarzanieTEMP = 1;

            }

            if (powtarzanieTEMP == 2){
                powtarzanieB++;
            } else if (powtarzanieTEMP == 3){
                powtarzanieB--;
            }

            if (powtarzanieTEMP == 3){
                powtarzanieC++;
            } else if (powtarzanieTEMP == 4){
                powtarzanieC--;
            }

            ostatni = liczbyB.get(i);

        }

        System.out.println(powtarzanieB);
        System.out.println(powtarzanieC);

    }


    static String odwot(String liczba){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < liczba.length(); i++) {

            stringBuilder.append(liczba.charAt(liczba.length()-1-i));

        }

        return stringBuilder.toString();

    }

    static boolean czyPierwsza(int liczba){

        if (liczba == 1){

            return false;

        }

        for (int i = 2; i < liczba; i++) {

            if (liczba % i == 0){

                return false;

            }

        }

        return true;

    }

}
