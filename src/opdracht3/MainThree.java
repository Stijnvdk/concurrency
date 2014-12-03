package opdracht3;

import util.ArrayGenerator;
import opdracht3.SorterThree;

import java.awt.*;

/**
 * Created by Stijn on 26-11-2014.
 */
public class MainThree {

    public static void main(String args[]) {

        int threshold = 10000;
        int[] aantallen = {25000, 50000, 100000, 200000, 400000, 800000};

        for (int aantal : aantallen) {
            int totaal = 0;
            for (int i = 0; i < 5; i++) {
                totaal += createAndLogForAantal(aantal, threshold);
            }
            System.out.println("[Meting 3] Done sorting list of " + aantal + " , took avarage of " + (totaal / 5) + " milisecs");
        }
        Toolkit.getDefaultToolkit().beep();
    }

    public static long createAndLogForAantal(int aantal, int threshold) {

        int[] arrayToSort = ArrayGenerator.createArray(aantal);
        long start = System.currentTimeMillis();
        SorterThree mainThread = new SorterThree(threshold);
        mainThread.setArrayToSort(arrayToSort);

        mainThread.start();

        try{
            mainThread.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        mainThread.getArrayToSort();

        long end = System.currentTimeMillis();
        System.out.println("[DEBUG 3] Done sorting list of " + aantal + " , took " + (end - start) + " milisecs");
        return end - start;
    }
}
