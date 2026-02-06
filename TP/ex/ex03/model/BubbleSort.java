package TP.ex.ex03.model;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] array) {
        int arrSize = array.length;
        Boolean swapped = false;

        if(arrSize <= 1) {
            return;
        }

        for(int i = 0; i < arrSize - 1; i++) {
            for(int j = 0; j < arrSize - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }

    }
}
