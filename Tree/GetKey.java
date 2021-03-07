package Tree;
import java.util.List;
import java.util.ArrayList;

public class GetKey {
    public List<Integer> getRange(TreeNode root, int min, int max){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        helper(root, min, max, result);
        return result;
    }
    private void helper(TreeNode root, int min, int max, List<Integer> result){
        if (root == null){
            return;
        }
        if (root.key > min){
            helper(root.left, min, max, result);
        }
        if(root.key >= min && root.key <= max){
            result.add(root.key);
        }
        if(root.key < max){
            helper(root.right, min, max, result);
        }
    }
    public static void main(String[] args){
        GetKey getRange = new GetKey();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        List<Integer> a = getRange.getRange(root, 2,5);
        System.out.println(a.toString());
    }
}

