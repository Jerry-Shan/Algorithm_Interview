import java.util.ArrayList;
import java.util.Stack;

public class T24_FindPath {
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return null;

        Stack <Integer> path = new Stack();
        int currentVal = 0;
        FindPath(root,target,path,currentVal);
        System.out.println(res);
        return res;
    }
    public void FindPath(TreeNode root, int target, Stack<Integer> path, int currentVal){

        path.push(root.val);
        currentVal += root.val;
        boolean isLeaf = (root.left == null && root.right == null);
        if (currentVal == target && isLeaf){
            ArrayList<Integer> oneRes = new ArrayList<>();
            while(!path.isEmpty()){
                oneRes.add(0,path.pop());
            }
            res.add(oneRes);
        }
        // if no new path 2, leftNodes will influence rightNodes
        Stack <Integer> path2 = new Stack();
        path2.addAll(path);
        if(root.left!=null)
            FindPath(root.left,target,path,currentVal);
        if(root.right!=null)
            FindPath(root.right,target,path2,currentVal);
        // if can not find the path, delete the current node from the path and add
        if(!path.isEmpty())
            path.pop();
        currentVal -= root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = null;
        root.right.right = null;
        root.left.left = new TreeNode(7);
        root.left.left = null;
        root.left.right = null;
        root.left.right = new TreeNode(4);
        root.left.right.left = null;
        root.left.right.right = null;


        T24_FindPath fp = new T24_FindPath();
        fp.FindPath(root,15);
    }
}
