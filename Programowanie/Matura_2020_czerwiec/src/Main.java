import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        zad1();
        System.out.println();

        zad2();
        System.out.println();

        zad3();

    }

    static boolean czyPierwsza(int liczba){

        boolean odp = true;

        if (liczba == 1){
            odp = false;
        } else {
            for (int i = 2; i < liczba; i++) {

                if (liczba % i == 0) {
                    odp = false;
                    break;
                }

            }
        }

        return odp;
    }

    static String minMax(int liczba){

        String odp;

        if (liczba % 2 == 0){

            int min = 0;
            int max = 0;

            for (int i = liczba; i > 0; i--) {

                if (czyPierwsza(i)){
                    max = i;
                    min = liczba - max;

                    if (max + min == liczba && czyPierwsza(min)) {
                        break;
                    }
                }

            }

            odp = liczba + " " + min + " " + max;
            return odp;

        } else {

            odp = "X";
            return odp;

        }

    }

    static int[] liczby(int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/pary.txt"));

        int[] liczby = new int[limit];

        String tempLine;

        for (int i = 0; i < limit; i++) {

            tempLine = scan.nextLine();

            liczby[i] = Integer.parseInt(tempLine.substring(0, tempLine.indexOf(' ')));

        }

        return liczby;

    }

    static String[] slowa(int limit) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/pary.txt"));

        String[] liczby = new String[limit];

        String tempLine;

        for (int i = 0; i < limit; i++) {

            tempLine = scan.nextLine();

            liczby[i] = tempLine.substring(tempLine.indexOf(' ') + 1);

        }

        return liczby;

    }

    static void zad1() throws FileNotFoundException {

        int[] liczby = liczby(100);

        for (int x:
                liczby) {

            if (!minMax(x).equals("X")){
                System.out.println(minMax(x));
            }

        }

    }

    static void zad2() throws FileNotFoundException {

        String[] slowa = slowa(100);

        int max = 0;
        int maxTEMP = 0;

        char current;
        char currentBEST = ' ';

        for (int i = 0; i < 100; i++) {

            current = slowa[i].charAt(0);
            maxTEMP = 1;

            for (int j = 0; j < slowa[i].length(); j++) {

                if (j>0){

                    if (slowa[i].charAt(j-1) == slowa[i].charAt(j)){

                        maxTEMP++;
                        current = slowa[i].charAt(j);


                    } else {

                        maxTEMP = 1;
                        current = slowa[i].charAt(j);

                    }

                }

                if (maxTEMP > max){
                    max = maxTEMP;
                    currentBEST = current;
                }

            }

        }

        System.out.println(currentBEST + " " + max);

    }

    static void zad3() throws FileNotFoundException {

        int[] liczby = liczby(100);
        String[] slowa = slowa(100);
        List<String> slowaMin = new ArrayList();

        int min = liczby[0];

        for (int i = 1; i < 100; i++) {

            if (liczby[i] < min){

                min = liczby[i];

            }

        }

        for (int i = 0; i < 100; i++) {

            if (liczby[i] == min) {

                slowaMin.add(slowa[i]);

            }

        }

        Collections.sort(slowaMin);

        System.out.println(min + " " + slowaMin.get(0));

    }

}
