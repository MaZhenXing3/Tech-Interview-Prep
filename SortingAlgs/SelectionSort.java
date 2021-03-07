package SortingAlgs;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int miniIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[miniIndex]) {
                    miniIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[miniIndex];
            array[miniIndex] = temp;

        }
        return array;
    }
}
