package DFS;

import java.util.List;
import java.util.ArrayList;
public class PermutationI {
    public List<String> permutations(String input){
        List<String> result = new ArrayList<String>();
        char[] word = input.toCharArray();
        dfs(word, 0, result);
        return result;
    }
    // level: input.length(); swap level's index with later chars;
    // branch: input.length() - index;
    private void dfs(char[] input, int index, List<String> result){
        //base case
        if (index == input.length){
            result.add(new String(input));
            return;
        }
        // swap char at index with the later chars
        for (int i = index; i < input.length; i++){
            swap(input, index, i);
            // from this base, keep permute the chars after index
            dfs(input, index + 1, result);
            // swap back
            swap(input, index, i);
        }

    }
    private void swap(char[] input, int i, int j){
        if (i == j){
            return;
        }
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args){
        PermutationI allPerm = new PermutationI();
        String input = "abc";
        List<String> result = allPerm.permutations(input);
        System.out.println(result.toString());
    }
}
