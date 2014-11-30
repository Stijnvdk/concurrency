/**
 * Created by Stijn on 26-11-2014.
 */
public class SorterThree extends Thread {

    private int threshold;

    private int[] arrayToSort;

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public SorterThree(int threshold) {
        this.threshold = threshold;
    }


    /**
     * Bron: http://www.algolist.net/Algorithms/Sorting/Insertion_sort
     *
     * @return
     */
    public void run() {
        if (arrayToSort.length > threshold) {
            split();
        } else {
            sort();
        }
    }

    public void split() {
        int aantal = getArrayToSort().length;
        SorterThree threadOne = new SorterThree(threshold);
        SorterThree threadTwo = new SorterThree(threshold);

        int half = aantal / 2;
        int[] toSortOne = new int[half];
        int[] toSortTwo = new int[half];

        for (int i = 0; i < aantal; i++) {
            if (i < half) {
                toSortOne[i] = arrayToSort[i];
            } else {
                toSortTwo[i - half] = arrayToSort[i];
            }
        }
        threadOne.setArrayToSort(toSortOne);
        threadTwo.setArrayToSort(toSortTwo);

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int[] listOne = threadOne.getArrayToSort();
        int[] listTwo = threadTwo.getArrayToSort();

        arrayToSort = mergeList(listOne, listTwo);
    }

    public void sort() {
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
        //System.out.println("test");
    }

    public int[] mergeList(int[] a, int[] b) {
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
