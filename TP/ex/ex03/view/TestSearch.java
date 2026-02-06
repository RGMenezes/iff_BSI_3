package TP.ex.ex03.view;

import TP.ex.ex03.model.Array;
import TP.ex.ex03.model.QuickAndInsertionSort;
import TP.ex.ex03.model.Search;
import TP.ex.ex03.model.Sort;
import TP.ex.ex03.model.Timer;

public class TestSearch {
    public static void main(String[] args) {
        Timer timer = new Timer();

        Array array = new Array(1000000);
        array.fillRandomly(0, 1000);

        Sort qis = new QuickAndInsertionSort();
        qis.sort(array.getArray());



        System.out.println("\nStarting sequential search...");

        timer.start();
        Search.sequential(array.getArray(), 0);
        Search.sequential(array.getArray(), 1001);
        Search.sequential(array.getArray(), 371);
        timer.stop();

        System.out.println("Sequential search time: " + timer.getElapsedTimeNano() + " ns");



        System.out.println("\nStarting binary search...");

        timer.start();
        Search.binary(array.getArray(), 0);
        Search.binary(array.getArray(), 1001);
        Search.binary(array.getArray(), 371);
        timer.stop();

        System.out.println("Binary search time: " + timer.getElapsedTimeNano() + " ns");
    }
}
