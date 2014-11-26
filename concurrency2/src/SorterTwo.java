/**
 * Created by Stijn on 26-11-2014.
 */
public class SorterTwo extends Thread {

    private int[] arrayToSort;

    public void setArrayToSort(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    public int[] getArrayToSort(){
        return arrayToSort;
    }

    /**
     * Bron: http://www.algolist.net/Algorithms/Sorting/Insertion_sort
     * @return
     */
    public void run() {
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
