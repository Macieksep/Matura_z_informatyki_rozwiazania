import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        zad1(107);
        System.out.println();

        zad2();
        System.out.println();

        zad3();

    }

    static int k (char a, char b){

        int k = 0;

        while (a != b) {

            a++;

            if (a == (char) ('Z' + 1)) {

                a = 'A';

            }

            k++;

        }

        return k;

    }

    static void zad1(int k) throws FileNotFoundException {

        File file = new File("src/dane_6_1.txt");
        Scanner scan = new Scanner(file);

        for (int l = 0; l < 100; l++) {

            String slowoTEMP = scan.nextLine();

            for (int j = 0; j < slowoTEMP.length(); j++) {

                char a = slowoTEMP.charAt(j);

                if (a + k > 90) {

                    for (int i = 0; i < k; i++) {

                        a++;

                        if (a == (char) 91) {
                            a = 'A';
                        }

                    }

                    System.out.print(a);

                } else {

                    System.out.print((char) (a + k));

                }

            }

            System.out.println();

        }

    }

    static void zad2() throws FileNotFoundException {

        File file = new File("src/dane_6_2.txt");
        Scanner scan = new Scanner(file);

        for (int l = 0; l < 3000; l++) {

            String line = scan.nextLine();

            String slowoTEMP = line.substring(0, line.indexOf(' '));

            if (!line.substring(line.indexOf(' ')+1).equals("")) {

                int k = Integer.parseInt(line.substring(line.indexOf(' ')+1));

                for (int j = 0; j < slowoTEMP.length(); j++) {

                    char a = slowoTEMP.charAt(j);

                    if (a - k < 65) {

                        for (int i = 0; i < k; i++) {

                            a--;

                            if (a == (char) 64) {
                                a = 'Z';
                            }

                        }

                        System.out.print(a);

                    } else {

                        System.out.print((char) (a - k));

                    }

                }
            } else {
                System.out.print(slowoTEMP);
            }


            System.out.println();

        }

    }

    static void zad3() throws FileNotFoundException {

        File file = new File("src/dane_6_3.txt");
        Scanner scan = new Scanner(file);

        List<String> lista = new ArrayList<>();

        for (int l = 0; l < 3000; l++) {

            String slowoTEMP = scan.nextLine();

            String slowo1 = slowoTEMP.substring(0, slowoTEMP.indexOf(' '));
            String slowo2 = slowoTEMP.substring(slowoTEMP.indexOf(' ') + 1);

            int k = k(slowo1.charAt(0), slowo2.charAt(0));

            for (int i = 1; i < slowo1.length(); i++) {

                if (k != k(slowo1.charAt(i), slowo2.charAt(i))){

                    if (!lista.contains(slowo1)){
                        lista.add(slowo1);
                    }

                }

            }

        }

        for (String x:
             lista) {

            System.out.println(x);

        }

    }

}
