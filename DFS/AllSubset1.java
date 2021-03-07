package DFS;
import java.util.List;
import java.util.ArrayList;
public class AllSubset1 {
    public List<String> subSets(String set){
        List<String> result = new ArrayList<String>();
        dfs(set, 0, new StringBuilder(), result);
        return result;
    }
    private void dfs(String set, int index, StringBuilder solution, List<String> result){
        if (index == set.length()){
            result.add(solution.toString());
            return;
        }
        // consider the case with element at index
        solution.append(set.charAt(index));
        dfs(set, index + 1, solution, result);
        // dis append the element that was appended;
        // consider the case with element at index
        solution.deleteCharAt(solution.length() - 1);
        dfs(set, index + 1, solution, result);
    }
    private void dfs2(String set, int index, String solution, List<String> result){
        if (index == set.length()){
            result.add(solution.toString());
            return;
        }
        // consider the case with element at index
        //solution.append(set.charAt(index));
        dfs2(set, index + 1, solution+set.charAt(index), result);
        // consider the case without element at index;
        // dis append the element
        //solution.deleteCharAt(solution.length() - 1);
        dfs2(set, index + 1, solution, result);
    }

    public static void main(String[] args){
        /*
        StringBuilder s = new StringBuilder();
        s.append("abc");
        System.out.println(s);
        int[] arr = new int[]{1,2,3};
        int l = arr.length;
        System.out.println(l);
        */
        AllSubset1 allsub = new AllSubset1();
        String set = "abc";
        List<String> a = allsub.subSets(set);
        System.out.println(a.toString());
        String firstS = new String("ab");
        String secondS = new String("c");
        System.out.println(firstS + secondS);
    }
}
