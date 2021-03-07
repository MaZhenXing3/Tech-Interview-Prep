package Tree;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSym(root.left, root.right);
    }
    // isSym checks if subtree with root of one and two are symmetric;
    private boolean isSym(TreeNode one, TreeNode two){
        // one and two are left and right node of previous level's
        // both are null then true;
        if(one == null && two == null){
            return true;
        }
        else if (one == null || two == null){ // not both null, one of them is null--> false
            return false;
        }
        if (one.key != two.key){
            return false;
        }
        else{
            // from two side ends squeeze towards mid;
            return isSym(one.left, two.right) && isSym(one.right, two.left);
        }
    }
    public static void main(String[] args){
        IsSymmetric check = new IsSymmetric();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(check.isSymmetric(root));
        root.right.key = 3;
        System.out.println(check.isSymmetric(root));
        root.left.left = new TreeNode(4);
        System.out.println(check.isSymmetric(root));
    }
}
