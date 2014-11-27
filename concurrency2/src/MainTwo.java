import java.lang.InterruptedException;
import java.util.Arrays;

/**
 * Created by Stijn on 26-11-2014.
 */
public class MainTwo {

    public static void main(String args[]) {

        int[] aantallen = {25000, 50000, 100000, 200000, 400000, 800000};

        for (int aantal : aantallen) {
            int totaal = 0;
            for (int i = 0; i < 5; i++) {
                totaal += testSortForAantal(aantal);
            }
            System.out.println("[Meting 2] Done sorting list of " + aantal + " , took avarage of " + (totaal / 5) + " milisecs");
        }
    }
    
    public static long testSortForAantal(int aantal){

        int[] array = ArrayGeneratorTwo.createArray(aantal);
        long start = System.currentTimeMillis();


        int[] firstHalf = Arrays.copyOfRange(array, 0, array.length/2);
        int[] lastHalf = Arrays.copyOfRange(array, array.length/2, array.length);

        SorterThread firstThread = new SorterThread(firstHalf);
        SorterThread secondThread = new SorterThread(lastHalf);

        firstThread.start();
        secondThread.start();

        try{
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        int[] merged = merge(firstThread.getArrayToSort(), secondThread.getArrayToSort());

        long end = System.currentTimeMillis();
        System.out.println("[DEBUG] Done sorting list of " + aantal + " , took " + (end - start) + " milisecs");
        return end - start;
    }

    private static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                answer[k++] = a[i++];

            else
                answer[k++] = b[j++];
        }

        while (i < a.length)
            answer[k++] = a[i++];


        while (j < b.length)
            answer[k++] = b[j++];

        return answer;
    }
}
