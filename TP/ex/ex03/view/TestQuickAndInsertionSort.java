package TP.ex.ex03.view;

import TP.ex.ex03.model.Array;
import TP.ex.ex03.model.QuickAndInsertionSort;
import TP.ex.ex03.model.QuickSort;
import TP.ex.ex03.model.Sort;
import TP.ex.ex03.model.Timer;

public class TestQuickAndInsertionSort {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Array arrayL1 = new Array(1000000);
        arrayL1.fillRandomly(0, 1000);
        Array arrayL2 = new Array(1000000);
        arrayL2.fillRandomly(0, 1000);


        

        Sort quickSort = new QuickSort();

        System.out.println("\nStarting quick Sort...\n");

        timer.start();
        quickSort.sort(arrayL1.getArray());
        timer.stop();
        System.out.println("Array large Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array large Time: " + timer.getElapsedTimeSec() + " seconds\n");




        Sort quickAndInsertionSort = new QuickAndInsertionSort();

        System.out.println("\nStarting quick and insertion Sort...\n");

        timer.start();
        quickAndInsertionSort.sort(arrayL2.getArray());
        timer.stop();
        System.out.println("Array large Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array large Time: " + timer.getElapsedTimeSec() + " seconds\n");
    }
}
