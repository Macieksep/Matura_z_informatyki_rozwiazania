import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        zad1(new File("src/identyfikator.txt"));

        zad2(new File("src/identyfikator.txt"));

        zad3(new File("src/identyfikator.txt"));

    }

    static List linijka(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        List<String> x = new ArrayList();

        while (scan.hasNextLine()) {

            x.add(scan.nextLine());

        }

        return x;

    }

    static void zad1(File file) throws FileNotFoundException {

        List linijka = linijka(file);

        char[] TEMP;
        int sumaTEMP = 0;

        List<String> sumy = new ArrayList<>();

        for (int i = 0; i < linijka.size(); i++) {

            TEMP = String.valueOf(linijka.get(i)).substring(3).toCharArray();

            for (int j = 0; j < 6; j++) {

                sumaTEMP += TEMP[j];

            }

            sumy.add(sumaTEMP + " " + i);

            sumaTEMP = 0;

        }

        Collections.sort(sumy);

        //sprawdzanie indexu/indexów
        //System.out.println(sumy);

        //wypisanie indexu/indexów
        System.out.println(linijka.get(26));
        System.out.println(linijka.get(87));

    }

    static void zad2(File file) throws FileNotFoundException {

        List linijka = linijka(file);

        Set<Integer> id = new HashSet<>();

        for (int i = 0; i < linijka.size(); i++) {

            System.out.println("x");

            if (czyPalindrom(String.valueOf(linijka.get(i)).substring(0,3)) || czyPalindrom(String.valueOf(linijka.get(i)).substring(3))){
                id.add(i);
            }

        }

        for (Integer x:
             id) {

            System.out.println(linijka.get(x));

        }

    }

    static void zad3(File file) throws FileNotFoundException {

        List linijka = linijka(file);

        char[] TEMP;

        for (int i = 0; i < linijka.size(); i++) {

            TEMP = new char[8];

            for (int j = 0; j < 8; j++) {

                if (j < 3){

                    TEMP[j] = String.valueOf(linijka.get(i)).charAt(j);

                } else if (j >=3){

                    TEMP[j] = String.valueOf(linijka.get(i)).charAt(j+1);

                }

            }

            int suma = 0;

            int mnoznik = 7;

            for (int j = 0; j < 8; j++) {

                if (j <3){

                    suma += wartosc(TEMP[j])*mnoznik;

                } else {

                    suma += Integer.parseInt(String.valueOf(TEMP[j]))*mnoznik;

                }

                if (mnoznik == 7){
                    mnoznik = 3;
                } else if (mnoznik == 3){
                    mnoznik = 1;
                } else {
                    mnoznik = 7;
                }

            }


            String a = String.valueOf(Integer.valueOf(suma % 10));
            String b = String.valueOf(String.valueOf(linijka.get(i)).charAt(3));

            if (!a.equals(b)){
                System.out.println(linijka.get(i));
            }

        }

    }


    static int wartosc(char a) {
        return a-55;
    }

    static boolean czyPalindrom(String a){

        char[] element = a.toCharArray();

        boolean palindrom = true;

        for (int i = 0; i < element.length/2+1; i++) {

            if (element[i] != element[element.length-i-1]){
                palindrom = false;
                break;
            }

        }

        return palindrom;
    }

}
