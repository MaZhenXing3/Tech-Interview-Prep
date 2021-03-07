package Graph;
import Tree.Converter;
import Tree.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
public class getKeysInTree {
    public List<List<Integer>> layerByLayer(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            result.add(new ArrayList<Integer>());
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                result.get(count).add(cur.key);
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            count++;
        }
        return result;
    }
    public static void main(String[] args){
        getKeysInTree getkeys = new getKeysInTree();
        Tree.Converter converter = new Tree.Converter();
        Integer[] arr = new Integer[]{5,3,8,1,4, null, 11};
        Tree.TreeNode outTree = converter.listToTree(arr);
        converter.printATree(outTree);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = getkeys.layerByLayer(outTree);
        System.out.println(res.toString());
    }
}
