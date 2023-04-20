import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String[] slowa = slowa(new File("src/sygnaly.txt"));

        zad1(slowa);
        System.out.println();

        zad2(slowa);
        System.out.println();

        zad3(slowa);

    }

    static String[] slowa(File file) throws FileNotFoundException{

        Scanner scan = new Scanner(file);

        String[] slowo = new String[1000];

        for (int i = 0; i < 1000; i++) {

            slowo[i] = scan.nextLine();

        }

        return slowo;

    }

    static void zad1(String[] slowa){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 39; i < 1000;) {

            if (slowa[i].length() < 10){
                System.out.println("BLAD!!!");
            } else {

                stringBuilder.append(slowa[i].charAt(9));

            }

            i += 40;

        }

        System.out.println(stringBuilder);

    }

    static void zad2(String[] slowa){

        Set<Character> litery;

        String MAX = "";
        int MAX_num = 0;

        for (int i = 0; i < 1000; i++) {

            litery = new HashSet<>();

            for (int j = 0; j < slowa[i].length(); j++) {

                litery.add(slowa[i].charAt(j));

            }

            if (litery.size() > MAX_num){

                MAX_num = litery.size();
                MAX = slowa[i];

            }

        }

        System.out.println(MAX + " " + MAX_num);

    }

    static void zad3(String[] slowa){

        boolean ok = true;
        int odleglosc = 0;

        for (int k = 0; k < 1000; k++) {

            for (int i = 0; i < slowa[k].length(); i++) {

                for (int j = i+1; j < slowa[k].length(); j++) {

                    odleglosc = Math.abs((int) slowa[k].charAt(j) - (int) slowa[k].charAt(i));

                    if (odleglosc > 10) {
                        ok = false;
                        break;
                    }

                }

                if (odleglosc > 10){
                    break;
                }

            }

            if (ok){
                System.out.println(slowa[k]);
            }

            ok = true;

        }

    }

}
