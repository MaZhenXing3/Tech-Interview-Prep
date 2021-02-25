package PracticeClassHw;

import java.util.Arrays;

public class CountArray {
    public int[] countArray(int[] array) {
        // Write your solution here
        // Laicode 276
        // we are sorting indexArr; array can use index to get array[index]; resultArr can use index to get resultArr[index]
        // helper is used to buffer indexArr;
        int[] result = new int[array.length];
        int[] index = new int[array.length];
        int[] helper = new int[array.length];
        for (int i = 0; i < array.length; i++){
            index[i] = i;
        }
        countArray(array, helper, result, index, 0, array.length-1);
        return result;
    }
    private void countArray(int[] array, int[] helper, int[] result, int[] index, int left, int right){
        // mergesort on index
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        countArray(array, helper, result, index, left, mid );
        countArray(array, helper, result, index, mid+1, right);
        merge(array, helper, result, index, left, mid, right);

    }
    private void merge(int[] array, int[] helper, int[] result, int[] index, int left, int mid, int right){
        // copy index to helper and sort on index;
        for(int k = left; k <= right; k++){
            helper[k] = index[k];
        }
        int i = left;
        int j = mid + 1;
        int cur = left;
        // merge two subarrays and result's subarrays
        while(i <= mid){
            if ( j == right + 1 || array[helper[i]] <= array[helper[j]] ){
                index[cur] = helper[i];
                result[index[cur++]] += j - (mid+1);
                i++;
            }
            else{
                index[cur++] = helper[j++];
            }
        }
        while(j <= right){
            index[cur++] = helper[j++];
        }
    }
    public static void main(String[] args){
        CountArray a = new CountArray();
        int[] arr1 = new int[]{4,1,3,2};
        int[] res1 = a.countArray(arr1);
        int[] arr2 = new int[]{4,1,3,2,0,-3};
        int[] res2 = a.countArray(arr2);
        int[] arr3 = new int[]{3,0,8,4,1,3,2};
        int[] res3 = a.countArray(arr3);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}
