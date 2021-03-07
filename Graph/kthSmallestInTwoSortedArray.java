package Graph;
import java.util.*;
public class kthSmallestInTwoSortedArray {
    class cell{
        int val;
        int i;
        int j;
        public cell(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    class MyComparator implements Comparator<cell>{
        public int compare(cell one, cell two){
            if(one.val == two.val){
                return 0;
            }
            return one.val < two.val ?  -1 : 1;
        }
    }
    public int kthSum(int[] one, int[] two, int k) {
        // Write your solution here
        if (one == null || one.length == 0){
            return two[k-1];
        }
        if(two == null || two.length == 0){
            return one[k-1];
        }
        // visited: 2d array;
        int l1 = one.length;
        int l2 = one.length;
        boolean[][] visited = new boolean[l1][l2];
        for(int i = 0; i < l1; i++){
            for (int j = 0; j < l2; j++){
                visited[i][j] = false;
            }
        }
        PriorityQueue<cell> pq = new PriorityQueue<cell>(new MyComparator());
        pq.offer(new cell(one[0]+two[0], 0, 0));
        visited[0][0] = true;
        cell cur;
        int val = one[0]+two[0];
        int i;
        int j;
        while(!pq.isEmpty()){
            cur = pq.poll();
            val = cur.val;
            i = cur.i;
            j = cur.j;
            k--;
            if (k == 0){
                return val;
            }
            // add neighbors if exist
            if (i+1 < one.length && !visited[i+1][j]){
                visited[i+1][j] = true;
                pq.offer(new cell(one[i+1] + two[j], i+1, j));
            }
            if (j+1 < two.length && !visited[i][j+1]){
                visited[i][j+1] = true;
                pq.offer(new cell(one[i] + two[j+1], i, j+1));
            }
        }
        return val;
    }
    public static void main(String[] args){
        kthSmallestInTwoSortedArray obj = new kthSmallestInTwoSortedArray();
        int[] a = new int[]{1,3,5,8,9};
        int[] b = new int[]{2,3,4,7};
        int result = obj.kthSum(a, b, 20);
        System.out.println(result);
    }
}
