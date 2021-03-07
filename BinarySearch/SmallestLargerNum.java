package BinarySearch;

public class SmallestLargerNum {
    public static void main(String[] args) {
        System.out.println();
    }

    public int smallestElementLargerThanTarget(int[] array, int target) {
        if(array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1){
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] > target) {
            if (array[left] > target) {
                return left;
            } else {
                return right;
            }
        }
        return -1;
    }
}
