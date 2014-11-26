/**
 * Created by Stijn on 26-11-2014.
 */
public class Main {

    public static void main (String args[]){

        int[] aantallen = {25000, 50000, 100000, 200000, 400000, 800000};

        for (int aantal: aantallen) {
            int totaal = 0;
            for (int i = 0; i < 5; i++) {
                totaal += createAndLogForAantal(aantal);
            }
            System.out.println("[Meting] Done sorting list of " + aantal + " , took avarage of " + (totaal / 5) + " milisecs");

        }

    }

    public static long createAndLogForAantal(int aantal){

        long start = System.currentTimeMillis();

        int[] arrayToSort = ArrayGenerator.createArray(aantal);
        Sorter.insertionSort(arrayToSort);

        long end = System.currentTimeMillis();
        System.out.println("[DEBUG] Done sorting list of " + aantal + " , took " + (end - start) + " milisecs");
        return end - start;
    }
}
