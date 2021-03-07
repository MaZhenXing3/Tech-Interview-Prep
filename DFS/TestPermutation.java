package DFS;

import java.util.List;

public class TestPermutation {
    public void permutation(char[] input){
        int[] count = new int[1];
        dfs(input, 0, count);
        System.out.println(count[0]);
    }
    private void dfs(char[] input, int index, int[] count){
        if(index == input.length){
            System.out.println(new String(input));
            count[0]++;
            return;
        }
        for(int i = index; i < input.length; i++){
            swap(input, index, i);
            dfs(input, index + 1,count);
            swap(input, index, i);
        }
    }
    private void swap(char[] input, int i, int j){
        if(i == j){
            return;
        }
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args){
        TestPermutation allPerm = new TestPermutation();
        char[] input = new char[]{'a'};
        allPerm.permutation(input);
    }
}
