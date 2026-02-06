package TP.ex.ex03.model;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] array) {
        int arrSize = array.length;

        for(int i = 1; i < arrSize; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
    
}
