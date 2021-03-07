package Tree;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class CheckBalance {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        if (root == null){
            return true;
        }
        // find depth;
        int result = helper(root);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    private int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left= left;
        root.right = right;
        CheckBalance check = new CheckBalance();
        System.out.println(check.isBalanced(root));
        left.left = new TreeNode(4);
        left.left.left = new TreeNode(5);
        System.out.println(check.isBalanced(root));

    }
}
