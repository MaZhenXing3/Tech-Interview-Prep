package Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Converter {
    // from a tree to an ArrayList; using bfs;
    public List<Integer> treeToList(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> levelList = new ArrayList<Integer>();
            int size = q.size();
            boolean allNullFlag = true;
            // using a for loop to print each level separately;
            for (int i = 0; i < size; i++){
                TreeNode out = q.poll();
                if (out != null){
                    allNullFlag = false;
                }
                if (out == null){
                    levelList.add(null);
                }
                else {
                    levelList.add(out.key);
                    q.offer(out.left);
                    q.offer(out.right);
                }
            }
            //avoid printing the last level (if it's a full tree)
            if (!allNullFlag){
                result.addAll(levelList);
            }
        }
        return result;
    }

    // convert an array to a tree; return the root of the tree
    public TreeNode listToTree(Integer[] input){
        // corner case;
        if (input.length == 0){
            return null;
        }
        // put the first element of the array at the root;
        TreeNode root = new TreeNode(input[0]);
        // put each tree node in this queue;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int i = 1;
        int size = input.length;
        // using this while loop to loop through the array and put the elements onto the tree accordingly;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            // if the current node is null then skip this iteration;
            if (curr == null){
                continue;
            }
            // if it's not null; then add elements from the array, at the same time put them on the queue;
            if ( i < size) {
                if (input[i] == null) {
                    curr.left = null;
                    i++;
                } else {
                    curr.left = new TreeNode(input[i++]);
                }
            }
            if (i < size){
                if(input[i] == null){
                    curr.right = null;
                    i++;
                }
                else{
                    curr.right = new TreeNode(input[i++]);
                }
            }
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return root;
    }

    // convert an array to a list;
    public List<Integer> arrayToList(int[] arr){
        int size = arr.length;
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < size; i++){
            output.add(arr[i]);
        }
        return output;
    }

    // print a tree; using treeToList method;
    public void printATree(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        list = treeToList(root);
        System.out.println(list.toString());
    }

    public static void main(String[] args){
        Converter converter = new Converter();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        converter.printATree(root);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.left.left.left = new TreeNode(15);
        converter.printATree(root);

        // ---------------------------------------

        Integer[] arr = new Integer[]{1,2,3,5,null, 10, null, 15, null, null, null};
        TreeNode outTree = converter.listToTree(arr);
        converter.printATree(outTree);
    }
}
