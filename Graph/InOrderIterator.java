package Graph;
import Tree.Converter;
import Tree.TreeNode;

import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class InOrderIterator {
    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode helper = root;
        while(!stack.isEmpty() || helper !=null){
            // case1, keep going left for helper; push to stack;
            if (helper != null){
                stack.offerFirst(helper);
                helper = helper.left;
            }
            // case2, where helper is null: pop cur, add cur to result; go cur.right
            else{
                helper = stack.pollFirst();
                result.add(helper.key);
                helper = helper.right;
            }
        }
        return result;
    }
    public static void main(String[] args){
        InOrderIterator obj = new InOrderIterator();
        List<Integer> list = new ArrayList<Integer>();
        Tree.Converter converter = new Tree.Converter();
        Integer[] arr = new Integer[]{5,3,8,1,4, null, 11};
        Tree.TreeNode root = converter.listToTree(arr);
        list = obj.inOrder(root);
        System.out.println(list.toString());
    }
}
