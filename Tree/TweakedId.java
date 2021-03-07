package Tree;

public class TweakedId {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two){
        if (one == null && two == null) {
            return true;
        }
        else if (one == null || two == null){
            return false;
        }
        else if (one.key != two.key){
            return false;
        }
        // is symmetric or identical
        // is symmetric || identical
        if ( (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)) ||
                (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) ){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        TweakedId isT = new TweakedId();
        TreeNode one = new TreeNode(1);
        one.left  = new TreeNode(2);
        one.right  = new TreeNode(3);

        TreeNode two = new TreeNode(1);
        two.left = new TreeNode(2);
        two.left.left = new TreeNode(3);
        System.out.println(isT.isTweakedIdentical(one,two));
    }
}
