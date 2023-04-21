import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        zad1(liczby());
        System.out.println();

        zad2(liczby());
        System.out.println();

        zad3(liczby());
        System.out.println();

        zad4(liczby());
        System.out.println();

        zad5(liczby());
        System.out.println();

    }

    static String[] liczby() throws FileNotFoundException {

       String[] liczby = new String[999];

        Scanner scanner = new Scanner(new File("src/liczby.txt"));

        for (int i = 0; i < liczby.length; i++) {

            liczby[i] = scanner.nextLine();

        }

        return liczby;

    }

    static void zad1(String[] liczby) {

        int osiem = 0;

        for (int i = 0; i < liczby.length; i++) {

            if (liczby[i].charAt(liczby[i].length()-1) == '8'){
                osiem++;
            }

        }

        System.out.println(osiem);

    }

    static void zad2(String[] liczby) {

        int cztery = 0;

        for (int i = 0; i < liczby.length; i++) {

            if (liczby[i].charAt(liczby[i].length()-1) == '4'){

                if (String.valueOf(Integer.parseInt(liczby[i].substring(0, liczby[i].length()-1), 4)).contains("0")){
                    cztery++;
                }

            }

        }

        System.out.println(cztery);

    }

    static void zad3(String[] liczby) {

        int parzyste = 0;

        for (int i = 0; i < liczby.length; i++) {

            if (liczby[i].charAt(liczby[i].length()-1) == '2'){

                if (Integer.parseInt(liczby[i].substring(0, liczby[i].length()-1), 2) % 2 == 0){
                    parzyste++;
                }

            }

        }

        System.out.println(parzyste);

    }

    static void zad4(String[] liczby) {

        int suma = 0;

        for (int i = 0; i < liczby.length; i++) {

            if (liczby[i].charAt(liczby[i].length()-1) == '8'){

                suma += Integer.parseInt(liczby[i].substring(0, liczby[i].length()-1), 8);

            }

        }

        System.out.println(suma);

    }

    static void zad5(String[] liczby){

        int[] liczby10 = new int[liczby.length];

        char radix;

        for (int i = 0; i < liczby.length; i++) {

            radix = liczby[i].charAt(liczby[i].length() - 1);

            liczby10[i] = Integer.valueOf(liczby[i].substring(0, liczby[i].length()-1), Integer.valueOf(String.valueOf(radix)));

        }

        int TEMP;
        String TEMP2;

        for (int i = 0; i < liczby10.length; i++) {
            for (int j = 0; j < liczby10.length; j++) {

                if (liczby10[i] > liczby10[j]){

                    TEMP = liczby10[j];
                    TEMP2 = liczby[j];

                    liczby10[j] = liczby10[i];
                    liczby[j] = liczby[i];

                    liczby10[i] = TEMP;
                    liczby[i] = TEMP2;

                }

            }
        }

        System.out.println(liczby[0] + " " + liczby10[0]);
        System.out.println(liczby[liczby10.length-1] + " " + liczby10[liczby10.length-1]);

    }

}
