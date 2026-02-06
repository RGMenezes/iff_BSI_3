package TP.ex.ex03.view;

import TP.ex.ex03.model.Array;
import TP.ex.ex03.model.SelectionSort;
import TP.ex.ex03.model.Sort;
import TP.ex.ex03.model.Timer;

public class TestSelectionSort {
    public static void main(String[] args) {
       Timer timer = new Timer();
        
        Array arrayS = new Array(100000);
        arrayS.fillRandomly(0, 1000);
        Array arrayM = new Array(500000);
        arrayM.fillRandomly(0, 1000);
        Array arrayL = new Array(1000000);
        arrayL.fillRandomly(0, 1000);

        Sort selectionSort = new SelectionSort();

        System.out.println("\nStarting selection Sort...\n");

        timer.start();
        selectionSort.sort(arrayS.getArray());
        timer.stop();
        System.out.println("Array small Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array small Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        selectionSort.sort(arrayM.getArray());
        timer.stop();
        System.out.println("Array medium Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array medium Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        selectionSort.sort(arrayL.getArray());
        timer.stop();
        System.out.println("Array large Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array large Time: " + timer.getElapsedTimeSec() + " seconds\n");
    }
}
