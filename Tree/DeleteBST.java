package Tree;

public class DeleteBST {
    public TreeNode deleteTree(TreeNode root, int key){
        if (root == null){
            return root;
        }
        // move the smallest node on the right hand side out, then put it at the key place.
        if (root.key == key){
            // if no node on the right
            if (root.right == null){
                return root.left;
            }
            else if (root.left == null){
                return root.right;
            }
            else if (root.right.left == null){ // smallest found on the right side is just the very right node;
                root.right.left = root.left;
                root = root.right;
                return root;
            }
            else{
                TreeNode replacement = moveSmallest(root);
                replacement.left = root.left;
                replacement.right = root.right;
                return replacement;
            }
        }
        else{
            if (root.key > key){
                root.left = deleteTree(root.left, key);
            }
            else {
                root.right = deleteTree(root.right, key);
            }
            return root;
        }
    }
    private TreeNode moveSmallest(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode p = root.right;
        while(p.left.left != null){
            p = p.left;
        }
        TreeNode smallest = p.left;
        p.left = smallest.right;
        smallest.right = null;
        return smallest;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        DeleteBST d = new DeleteBST();
        root = d.deleteTree(root,5);
        System.out.println(root.key);
        System.out.println(root.right.key);
    }
}
