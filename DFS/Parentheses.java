package DFS;
import java.util.List;
import java.util.ArrayList;
public class Parentheses {
    public List<String> validParentheses(int n){
        List<String> result = new ArrayList<String>();
        if (n == 0){
            return result;
        }
        StringBuilder solution = new StringBuilder();
        dfs(n, 0, 0, solution, result);
        return result;
    }
    // adding (: this can happen when we still have (
    // adding ): this can happen when out string already have more ( than ).
    // problem: add ( or ), every level must add one;
    // 2n levels; 2 branches (add left or right);
    private void dfs(int n, int l, int r, StringBuilder solution, List<String> result){
        // base case, add solution to result;
        if (l == n && r == n){
            result.add(solution.toString());
            return;
        }
        // adding (
        if (l < n){
            solution.append("(");
            dfs(n, l+1, r, solution, result);
            solution.deleteCharAt(solution.length() - 1);
        }
        // adding )
        // can not use else if because these two cases can both happen at the same level;
        if (l > r){
            solution.append(")");
            dfs(n, l, r+1, solution, result);
            solution.deleteCharAt(solution.length() - 1);
        }
    }
    public static void main(String[] args){
        Parentheses pr = new Parentheses();
        List<String> result = new ArrayList<String>();
        result = pr.validParentheses(3);
        System.out.println(result.toString());
    }
}
