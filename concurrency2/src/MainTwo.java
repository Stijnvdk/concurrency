import java.lang.InterruptedException;

/**
 * Created by Stijn on 26-11-2014.
 */
public class MainTwo {

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

        int[] arrayToSort = ArrayGeneratorTwo.createArray(aantal);
        SorterTwo threadOne = new SorterTwo();
        SorterTwo threadTwo = new SorterTwo();
        int[] toSortOne;
        int[] toSortTwo;
        int half = aantal/2;
        for( int i = 0; i > aantal; i++ ){
            if(i > half){
                toSortOne[] = arrayToSort[i];
            }else{
                toSortTwo[] = arrayToSort[i];
            }
        }
        threadOne.setArrayToSort(toSortOne);
        threadTwo.setArrayToSort(toSortTwo);

        threadOne.start();
        threadTwo.start();

        try{
                threadOne.join();threadTwo.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage();
        }

        int[] listOne = threadOne.getgetArrayToSort();
        int[] listTwo = threadTwo.getgetArrayToSort();



//        Sorter.insertionSort(arrayToSort);

        long end = System.currentTimeMillis();
        System.out.println("[DEBUG] Done sorting list of " + aantal + " , took " + (end - start) + " milisecs");
        return end - start;
    }

    private int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
        {
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
