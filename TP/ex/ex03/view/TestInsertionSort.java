package TP.ex.ex03.view;

import TP.ex.ex03.model.Array;
import TP.ex.ex03.model.InsertionSort;
import TP.ex.ex03.model.Sort;
import TP.ex.ex03.model.Timer;

public class TestInsertionSort {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Array arrayS = new Array(100000);
        arrayS.fillRandomly(0, 1000);
        Array arrayM = new Array(500000);
        arrayM.fillRandomly(0, 1000);
        Array arrayL = new Array(1000000);
        arrayL.fillRandomly(0, 1000);

        Sort insertionSort = new InsertionSort();

        System.out.println("\nStarting insertion Sort...\n");

        timer.start();
        insertionSort.sort(arrayS.getArray());
        timer.stop();
        System.out.println("Array small Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array small Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        insertionSort.sort(arrayM.getArray());
        timer.stop();
        System.out.println("Array medium Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array medium Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        insertionSort.sort(arrayL.getArray());
        timer.stop();
        System.out.println("Array large Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array large Time: " + timer.getElapsedTimeSec() + " seconds\n");
    }
}
