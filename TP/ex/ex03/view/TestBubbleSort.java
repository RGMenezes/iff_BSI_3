package TP.ex.ex03.view;

import TP.ex.ex03.model.Array;
import TP.ex.ex03.model.BubbleSort;
import TP.ex.ex03.model.Sort;
import TP.ex.ex03.model.Timer;

public class TestBubbleSort {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Array arrayS = new Array(100000);
        arrayS.fillRandomly(0, 1000);
        Array arrayM = new Array(500000);
        arrayM.fillRandomly(0, 1000);
        Array arrayL = new Array(1000000);
        arrayL.fillRandomly(0, 1000);

        Sort bubbleSort = new BubbleSort();

        System.out.println("\nStarting Bubble Sort...\n");

        timer.start();
        bubbleSort.sort(arrayS.getArray());
        timer.stop();
        System.out.println("Array small Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array small Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        bubbleSort.sort(arrayM.getArray());
        timer.stop();
        System.out.println("Array medium Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array medium Time: " + timer.getElapsedTimeSec() + " seconds\n");

        timer.start();
        bubbleSort.sort(arrayL.getArray());
        timer.stop();
        System.out.println("Array large Time: " + timer.getElapsedTimeMilli() + " milliseconds");
        System.out.println("Array large Time: " + timer.getElapsedTimeSec() + " seconds\n");
    }
    
}
