package BinarySearch;

public class KClosestNum {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        } else if (k <= 0 || k > array.length) {
            return new int[0];
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int [] newList = new int[k];
        int i = 0;
        while (i < k && left >=0 && right < array.length) {
            if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                newList[i] = array[left];
                left--;
            } else {
                newList[i] = array[right];
                right++;
            }
            i++;
        }
        while (i < k && left >= 0) {
            newList[i] = array[left];
            left--;
            i++;
        }
        while (i < k && right < array.length) {
            newList[i] = array[right];
            right++;
            i++;
        }
        return newList;
    }
}
