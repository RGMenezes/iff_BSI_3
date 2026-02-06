package TP.ex.ex03.model;

public class Array {
    private int[] array;

    public Array(int size) {
        this.array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void fillRandomly(int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
    }

    public void reverse() {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
