package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationCoins {
    public List<List<Integer>> combinations(int target, int[] coins){
        // coins are in descending order
        // levels: coins.length()
        // branches: from 0 - target / coin[index];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        dfs(target, coins, 0, result, solution);
        return result;
    }
    private void dfs(int remain, int[] coins, int index, List<List<Integer>> result, List<Integer> solution){

        if (index == coins.length - 1){
            // find how many coins of the last index we need to fill up the remain;
            if (remain % coins[index] == 0){
                solution.add(remain/coins[index]);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }

        /*
        // stop after the last coin
        // this way take a lot more time than official answer
        if (index == coins.length){
            if (remain == 0) {
                result.add(new ArrayList<Integer>(solution));
            }
            return;
        }
         */

        // else just try different coins at this level with coin[index]
        for(int i = 0; i <= remain / coins[index]; i++){
            solution.add(i);
            dfs(remain - i*coins[index], coins, index + 1, result, solution);
            solution.remove(solution.size()-1);
        }
    }
    public static void main(String[] args){
        CombinationCoins comb = new CombinationCoins();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] coins = new int[]{25,10,5,1};
        long start = System.nanoTime();
        result = comb.combinations(99,coins);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(result.toString());
        System.out.println(elapsedTime);
    }
}
