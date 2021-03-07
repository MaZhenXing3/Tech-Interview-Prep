package SortingAlgs;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println();
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] quickSort(int[] array) {
        // sanity check
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        Random random = new Random();
        int pivotIn = left + random.nextInt(right - left + 1);
        swap(array, pivotIn, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < array[right]) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}
