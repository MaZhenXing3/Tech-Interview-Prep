package Graph;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Converter {
    // from a tree to an ArrayList; using bfs;
    public List<Integer> treeToList(Tree.TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Queue<Tree.TreeNode> q = new LinkedList<Tree.TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> levelList = new ArrayList<Integer>();
            int size = q.size();
            boolean allNullFlag = true;
            // using a for loop to print each level separately;
            for (int i = 0; i < size; i++){
                Tree.TreeNode out = q.poll();
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
    public Tree.TreeNode listToTree(Integer[] input){
        // corner case;
        if (input.length == 0){
            return null;
        }
        // put the first element of the array at the root;
        Tree.TreeNode root = new Tree.TreeNode(input[0]);
        // put each tree node in this queue;
        Queue<Tree.TreeNode> q = new LinkedList<Tree.TreeNode>();
        q.offer(root);
        int i = 1;
        int size = input.length;
        // using this while loop to loop through the array and put the elements onto the tree accordingly;
        while(!q.isEmpty()){
            Tree.TreeNode curr = q.poll();
            // if the current node is null then skip this iteration;
            if (curr == null){
                continue;
            }
            // if it's not null; then add elements from the array, at the same time put them on the queue;
            if ( i < size){
                if (input[i] == null){
                    curr.left = null;
                    i++;
                }
                else{
                    curr.left = new Tree.TreeNode(input[i++]);
                }
                if(input[i] == null){
                    curr.right = null;
                    i++;
                }
                else{
                    curr.right = new Tree.TreeNode(input[i++]);
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
    public void printATree(Tree.TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        list = treeToList(root);
        System.out.println(list.toString());
    }

    public static void main(String[] args){
        Tree.Converter converter = new Tree.Converter();
        Tree.TreeNode root = new Tree.TreeNode(1);
        root.left = new Tree.TreeNode(2);
        root.right = new Tree.TreeNode(3);
        converter.printATree(root);
        root.left.left = new Tree.TreeNode(5);
        root.right.left = new Tree.TreeNode(10);
        root.left.left.left = new Tree.TreeNode(15);
        converter.printATree(root);

        // ---------------------------------------

        Integer[] arr = new Integer[]{1,2,3,5,null, 10, null, 15, null, null, null};
        TreeNode outTree = converter.listToTree(arr);
        converter.printATree(outTree);
    }
}
