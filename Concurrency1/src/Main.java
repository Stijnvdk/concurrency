/**
 * Created by Stijn on 26-11-2014.
 */
public class Main {

    public static void main (String args[]){
        createAndLogForAantal(25000);
        createAndLogForAantal(50000);
        createAndLogForAantal(100000);
        createAndLogForAantal(200000);
        createAndLogForAantal(400000);
        createAndLogForAantal(800000);

    }

    public static void createAndLogForAantal(int aantal){

        long start = System.currentTimeMillis();

        int[] arrayToSort = ArrayGenerator.createArray(aantal);
        Sorter.insertionSort(arrayToSort);

        long end = System.currentTimeMillis();
        System.out.println("Done sorting list of " + aantal + " , took " + (end - start) + " milisecs");
    }
}
