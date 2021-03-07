package Graph;
import Tree.Converter;
import Tree.TreeNode;

import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class PostOrderIterator {
    public List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> s = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        s.offerFirst(root);
        while(!s.isEmpty()){
            TreeNode cur = s.peekFirst();
            //case1, when prev is null, just search left;
            if (prev == null || prev.left == cur || prev.right == cur){
                if (cur.left != null){
                    s.offerFirst(cur.left);
                }
                else if (cur.right != null){
                    s.offerFirst(cur.right);
                }
                else{
                    result.add(cur.key);
                    s.pollFirst();
                }
            }
            // case2, when prev came from the left of cur;(left side is finished); need go to the right of cur;
            else if (prev == cur.left){
                if (cur.right == null){
                    result.add(cur.key);
                    s.pollFirst();
                }
                else {
                    s.offerFirst(cur.right);
                }
            }
            // case3, when prev came from right of cur; pop the stack top and print it
            else {
                result.add(cur.key);
                s.pollFirst();
            }
            prev = cur;
        }
        return result;
    }
    public static void main(String[] args){
        PostOrderIterator obj = new PostOrderIterator();
        List<Integer> list = new ArrayList<Integer>();
        Tree.Converter converter = new Tree.Converter();
        Integer[] arr = new Integer[]{11,1,null,null,-1,-9,10,-5,6,-7,null,null,-6,15};
        Tree.TreeNode root = converter.listToTree(arr);
        list = obj.postOrder(root);
        System.out.println(list.toString());
    }
}
