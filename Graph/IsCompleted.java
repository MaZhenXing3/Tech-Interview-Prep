package Graph;
import Tree.Converter;
import Tree.TreeNode;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;
public class IsCompleted {
    public boolean isCompleted(TreeNode root){
        if (root == null){
            return true;
        }
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        boolean flag = false;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur == null){
                flag = true;
            }
            else {
                if (flag && cur != null){
                    return false;
                }
                if (cur != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        IsCompleted obj = new IsCompleted();
        Tree.Converter converter = new Tree.Converter();
        Integer[] arr = new Integer[]{5,3,8,1,4,4, 11};
        Tree.TreeNode root = converter.listToTree(arr);
        System.out.println(obj.isCompleted(root));
    }
}
