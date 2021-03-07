package Tree;
import java.util.List;
import java.util.LinkedList;



public class PreorderTraverseBtree {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null){
            return output;
        }
        recursion(root, output);
        return output;
    }
    private void recursion(TreeNode root, List<Integer> output){
        if (root == null){
            return;
        }
        System.out.println(root.key);
        output.add(root.key); // List interface doesn't have offer()!!!
        recursion(root.left, output);
        recursion(root.right, output);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left= left;
        root.right = right;
        PreorderTraverseBtree traverse = new PreorderTraverseBtree();
        traverse.preOrder(root);
    }
}
