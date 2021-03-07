package Tree;

public class IsBST {
    public boolean isBST(TreeNode root){
        // traverse inorder, compare curr to prev;
        if (root == null){
            return true;
        }
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean helper(TreeNode root, int max, int min){
        if (root == null){
            return true;
        }
        if (root.key > max || root.key < min){
            return false;
        }
        boolean left = helper(root.left, root.key, min);
        boolean right = helper(root.right, max, root.key);
        return left && right;
    }
}

