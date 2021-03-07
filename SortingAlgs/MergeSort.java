package SortingAlgs;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }

    private int[] merge(int[] leftResult, int[] rightResult) {
        int[] result = new int[leftResult.length + rightResult.length];
        int i = 0, j = 0, k = 0;
        while (i < leftResult.length && j < rightResult.length) {
            if (leftResult[i] > rightResult[j]) {
                result[k] = rightResult[j];
                j++;
            } else {
                result[k] = leftResult[i];
                i++;
            }
            k++;
        }
        while (i < leftResult.length) {
            result[k] = leftResult[i];
            i++;
            k++;
        }
        while (j < rightResult.length) {
            result[k] = rightResult[j];
            j++;
            k++;
        }
        return result;
    }
}
