package opdracht2;

/**
 * Created by Stijn on 26-11-2014.
 */
public class SorterThread extends Thread {

    private int[] arrayToSort;

    public int[] getArrayToSort(){
        return arrayToSort;
    }

    public SorterThread(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    public void run() {
        insertionSort(arrayToSort);
    }

    /**
     * Bron: http://www.algolist.net/Algorithms/Sorting/Insertion_sort
     * @param arrayToSort
     * @return
     */
    public static void insertionSort(int[] arrayToSort) {
        int i, j, newValue;
        for (i = 1; i < arrayToSort.length; i++) {
            newValue = arrayToSort[i];
            j = i;
            while (j > 0 && arrayToSort[j - 1] > newValue) {
                arrayToSort[j] = arrayToSort[j - 1];
                j--;
            }
            arrayToSort[j] = newValue;
        }
    }
}
