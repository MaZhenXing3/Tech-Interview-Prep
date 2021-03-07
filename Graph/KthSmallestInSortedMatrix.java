package Graph;
import Heap.KthSmallest;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k){
        if (matrix== null || matrix[0] == null){
            return 0;
        }
        PriorityQueue<cell> minHeap = new PriorityQueue<cell>(k, new Comparator<cell>(){
                    public int compare(cell a, cell b){
                        if (a.key == b.key){
                            return 0;
                        }
                        return a.key < b.key ? -1:1;
                    }
                }
        );
        // initialize a true false matrix;
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] dedup = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dedup[i][j] = false;
            }
        }
        minHeap.offer(new cell(matrix[0][0], 0, 0));
        dedup[0][0] = true;
        cell cur = null;
        int i;
        int j;
        while(!minHeap.isEmpty() && k > 0){
            cur = minHeap.poll();
            k--;
            i = cur.i;
            j = cur.j;
            // check if in range;
            if (i+1 < rows && dedup[i+1][j] == false){
                minHeap.offer(new cell(matrix[i+1][j], i+1, j));
                dedup[i+1][j] = true;
            }
            if (j+1 < cols && dedup[i][j+1] == false){
                minHeap.offer(new cell(matrix[i][j+1], i, j+1));
                dedup[i][j+1] = true;
            }
        }
        return cur.key;
    }
    static class cell{
        int key;
        int i;
        int j;
        public cell(int key, int i, int j){
            this.key = key;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args){
        KthSmallestInSortedMatrix obj = new KthSmallestInSortedMatrix();
        int[][] matrix = new int[][]{ {1,  3,   5,  7},

                {2,  4,   8,   9},

                {3,  5, 11, 15},

                {6,  8, 13, 18} };
        System.out.println(obj.kthSmallest(matrix, 1));
        int a = 1;
        System.out.println(a);
        a = a*(-1);
        System.out.println(a);
        a = a* (-1);
        System.out.println(a);
    }
}


