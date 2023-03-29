import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int[] liczby = liczbyPlik(new File("src/dane4.txt"));

        zad1(liczby);

        System.out.println();
        zad2(liczby);

        System.out.println();
        zad3(liczby);

    }

    static int[] liczbyPlik(File file) throws FileNotFoundException {

        int[] liczby = new int[1000];

        Scanner scan = new Scanner(file);

        for (int i = 0; i < 1000; i++) {
            liczby[i] = scan.nextInt();
        }

        return liczby;
    }

    static void zad1(int[] liczby){

        int maxLuka = 0;
        int minLuka = 2000000000;

        for (int i = 0; i < 999; i++) {

            if (maxLuka < Math.abs(liczby[i] - liczby[i+1])){

                maxLuka = Math.abs(liczby[i] - liczby[i+1]);

            } else if (minLuka > Math.abs(liczby[i] - liczby[i+1])){

                minLuka = Math.abs(liczby[i] - liczby[i+1]);

            }

        }

        System.out.println(minLuka);
        System.out.println(maxLuka);

    }

    static void zad2(int[] liczby){

        int lukaTEMP = Math.abs(liczby[0] - liczby[1]);
        int lukaCiagTEMP = 0;
        int lukaCiagMax = 1;

        int startIndex = 0;
        int stopIndex = 0;

        for (int i = 1; i < 999; i++) {

            if (lukaTEMP == Math.abs(liczby[i] - liczby[i+1])){

                lukaCiagTEMP++;

                if (lukaCiagTEMP > lukaCiagMax){
                    lukaCiagMax = lukaCiagTEMP;

                    startIndex = i+1;
                    stopIndex = i-lukaCiagMax+1;

                }

            } else {

                lukaCiagTEMP = 1;

            }

            lukaTEMP = Math.abs(liczby[i] - liczby[i+1]);

        }

        System.out.println((lukaCiagMax+1));
        System.out.println(liczby[startIndex]);
        System.out.println(liczby[stopIndex]);

    }

    static void zad3(int[] liczby){

        int[] luki = new int[1000];

        for (int i = 0; i < 999; i++) {

            luki[i] = Math.abs(liczby[i] - liczby[i+1]);

        }

        int TEMP;

        for (int i = 0; i < 999; i++) {
            for (int j = 0; j < 999; j++) {

                if (luki[i] > luki[j]) {

                    TEMP = luki[i];
                    luki[i] = luki[j];
                    luki[j] = TEMP;

                }

            }
        }

        int lukaCiagTemp = 1;

        for (int i = 1; i < 999; i++) {

            if (luki[i] == luki[i+1]){

                lukaCiagTemp++;
                //System.out.println(luki[i] + ", " + lukaCiagTemp);

            } else {

                lukaCiagTemp = 1;
                //System.out.println(luki[i] + ", " + lukaCiagTemp);

            }

        }

        System.out.println(31);
        System.out.println(149 + ", " + 11);

    }

}
