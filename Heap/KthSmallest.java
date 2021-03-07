package Heap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
public class KthSmallest {
    public int[] kSmallest(int[] array, int k){
        if (array.length == k){
            Arrays.sort(array);
            return array;
        }
        if(k == 0){
            return new int[0];
        }
        quickSelect(array, k, 0, array.length - 1);
        int[] arr = Arrays.copyOfRange(array,0,k);
        Arrays.sort(arr);
        return arr;
    }

    private void quickSelect(int[] arr, int k, int l, int r){ // l,r are left, right bound of arr(input)
        // base cases
        if (k == 0 || l >= r){
            return;
        }
        int pIndex = l + (int)Math.random() * (r - l + 1);
        int p = arr[pIndex];
        swap(arr, pIndex, r);
        int i = l;
        int j = r;
        while(i <= j){
            if(arr[i] >= p){
                // swap i and j; j--;
                swap(arr, i, j--);
            }
            else{
                i++;
            }
        }
        // post process, swap last element with i;
        swap(arr, i, r);
        // if there are exactly k numbers smaller than p, then put these numbers into the result and return;
        if (i == k){
            return;
        }
        // if there are less than k numbers smaller than p; append all the smallers then do quickSelect on the right;
        else if (i < k){
            quickSelect(arr, k, i, r);
        }
        else{ // more than k smaller than p,  quickSelect on the left;
            quickSelect(arr, k, l, i-1);
        }
        return;
    }
    private void appendArrToList(int[] arr, List<Integer> lst ,int begin, int end){ // end inclusive
        for(int m = begin; m <= end; m++){
            lst.add(arr[m]);
        }
        return;
    }
    public void swap(int[] arr, int i, int j){
        if(i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public int[] kthSmallestHeap(int[] array, int k){
        if (k == 0 || array.length == 0){
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b){
                if (a.equals(b)){
                    return 0;
                }
                return a > b ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++){
            if (i < k){
                // put first k numbers into the heap;
                maxHeap.offer(array[i]);
            }
            else{
                //  for the rest numbers; if it's  smaller than top of heap, takeover the position.
                if (array[i] < maxHeap.peek()){
                    //  pop the top
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }
    public static void main(String[] args){
        KthSmallest c = new KthSmallest();
        int[] arr = new int[]{8,7,3,1,5,2};
        int[] result = c.kthSmallestHeap(arr,2);
        System.out.println(Arrays.toString(result));
    }
}
