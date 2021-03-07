package Tree;

public class InsertBST {
    public TreeNode insert(TreeNode root, int key){
        TreeNode insert = new TreeNode(key);
        if (root == null){
            return insert;
        }
        TreeNode p = root;
        while(p != null){
            if(p.key == key){
                return root;
            }
            else if (p.key < key){
                if (p.right == null){
                    p.right = insert;
                    return root;
                }
                p = p.right;
            }
            else{
                if(p.left == null){
                    p.left = insert;
                    return root;
                }
                p = p.left;
            }
        }
        return root;
    }
}
