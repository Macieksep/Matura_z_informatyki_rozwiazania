import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String[] wers = wers(new File("src/galerie.txt"), 50);

        zad1(wers, 50);

        zad2(wers, 50);

        zad3(wers, 50);

    }

    static String[] wers(File file, int linijki) throws FileNotFoundException {

        String[] wers = new String[linijki];

        Scanner scan = new Scanner(file);

        for (int i = 0; i < wers.length; i++) {

            wers[i] = scan.nextLine();

        }

        return wers;
    }

    static void zad1(String[] wers, int linijki){


        Set<String> panstwo = new HashSet<>();

        for (String x:
             wers) {

            panstwo.add(x.substring(0, x.indexOf(' ')));

        }

        String[][] zad = new String[panstwo.size()][2];
        int index = 0;

        for (String x:
             panstwo) {

            zad[index][0] = x;
            zad[index][1] = "0";
            index++;
        }

        for (int i = 0; i < linijki; i++) {

            for (int j = 0; j < panstwo.size(); j++) {

                if (wers[i].substring(0, wers[i].indexOf(' ')).equals(zad[j][0])){
                    zad[j][1] = String.valueOf(Integer.parseInt(zad[j][1]) + 1);
                }

            }

        }

        for (int i = 0; i < panstwo.size(); i++) {

            System.out.println(zad[i][0] + " " + zad[i][1]);

        }

    }

    static void zad2(String[] wers, int linijki){

        String[][] miasto = new String[linijki][3];

        String wersSub;

        int[] TEMP = new int[140];

        int currentSize = 0;

        for (int i = 0; i < linijki; i++) {

            miasto[i][0] = wers[i].substring(wers[i].indexOf(' ')+1, wers[i].indexOf(' ', wers[i].indexOf(' ')+1));

            miasto[i][2] = "70";

            wersSub = wers[i];

            for (int j = 0; j < 142; j++) {

                if (j >= 2 && j != 141) {

                    TEMP[j-2] = Integer.parseInt(wersSub.substring(0, wersSub.indexOf(' ')));

                } else if (j == 141){

                    TEMP[j-2] = Integer.parseInt(wersSub.substring(wersSub.lastIndexOf(' ')+1));

                }

                if (j != 141) {

                    wersSub = wersSub.substring(wersSub.indexOf(' ') + 1);

                }

            }

            for (int j = 0; j < 140; j += 2) {

                currentSize += TEMP[j] * TEMP[j+1];

                if (TEMP[j] == 0 && TEMP[j+1] == 0){

                    miasto[i][2] = String.valueOf(Integer.parseInt(miasto[i][2])-1);

                }

            }

            miasto[i][1] = String.valueOf(currentSize);

            currentSize = 0;

        }

        int max = Integer.parseInt(miasto[0][1]);
        int min = Integer.parseInt(miasto[0][1]);

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < linijki; i++) {

            System.out.println(miasto[i][0] + " " + miasto[i][1] + " " + miasto[i][2]);

            if (max < Integer.parseInt(miasto[i][1])){

                maxIndex = i;
                max = Integer.parseInt(miasto[i][1]);

            }

            if (min > Integer.parseInt(miasto[i][1])){

                minIndex = i;
                min = Integer.parseInt(miasto[i][1]);

            }

        }

        System.out.println();
        System.out.println(miasto[maxIndex][0] + " " + miasto[maxIndex][1]);
        System.out.println(miasto[minIndex][0] + " " + miasto[minIndex][1]);

    }

    static void zad3(String[] wers, int linijki){

        String[][] miasto = new String[linijki][2];

        String wersSub;

        int[] TEMP = new int[140];
        int[] sizeTEMP = new int[70];

        Set<Integer> rodzajeTEMP;

        int max = 0;
        int min = 999;

        int maxIndex = 0;
        int minIndex = 0;

        miasto[maxIndex][0] = "x";
        miasto[minIndex][0] = "x";

        for (int i = 0; i < linijki; i++) {

            rodzajeTEMP = new HashSet<>();

            miasto[i][0] = wers[i].substring(wers[i].indexOf(' ')+1, wers[i].indexOf(' ', wers[i].indexOf(' ')+1));

            wersSub = wers[i];

            for (int j = 0; j < 142; j++) {

                if (j >= 2 && j != 141) {

                    TEMP[j-2] = Integer.parseInt(wersSub.substring(0, wersSub.indexOf(' ')));

                } else if (j == 141){

                    TEMP[j-2] = Integer.parseInt(wersSub.substring(wersSub.lastIndexOf(' ')+1));

                }

                if (j != 141) {

                    wersSub = wersSub.substring(wersSub.indexOf(' ') + 1);

                }

            }

            int index = 0;
            for (int j = 0; j < 70; j++) {

                sizeTEMP[j] = TEMP[index]*TEMP[index+1];

                index += 2;

            }

            for (int x:
                 sizeTEMP) {

                rodzajeTEMP.add(x);

            }

            rodzajeTEMP.remove(0);

            miasto[i][1] = String.valueOf(rodzajeTEMP.size());

            if (max < Integer.parseInt(miasto[i][1])){

                max = Integer.parseInt(miasto[i][1]);

                maxIndex = i;

            }

            if (min > Integer.parseInt(miasto[i][1])){

                min = Integer.parseInt(miasto[i][1]);

                minIndex = i;

            }

        }

        System.out.println();
        System.out.println(miasto[maxIndex][0] + " " + miasto[maxIndex][1]);
        System.out.println(miasto[minIndex][0] + " " + miasto[minIndex][1]);

    }

}
