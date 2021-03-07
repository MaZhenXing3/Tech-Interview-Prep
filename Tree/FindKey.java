package Tree;

public class FindKey {
    public TreeNode search(TreeNode root, int key){
        TreeNode p = root;
        while(p != null){
            if (p.key == key){
                return p;
            }
            else if (p.key > key){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }
        return null;
    }
    public static void main(String[] args){
        FindKey findK = new FindKey();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(8);
        TreeNode key = findK.search(root, 3);
        System.out.println(key.key);
        key = findK.search(root, 100);
        System.out.println(key);
    }
}
