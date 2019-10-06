package SwordOfferSolusions;

import java.util.ArrayList;
import java.util.Stack;

public class T24_FindPath_v2 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)return paths;
        find(paths,new ArrayList<Integer>(),root,target);
        System.out.println(paths);
        return paths;
    }
    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        if(root.left!=null)find(paths,path,root.left,target-root.val);
        if(root.right!=null)find(paths,path2,root.right,target-root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
//        root.right.left = null;
//        root.right.right = null;
        root.left.left = new TreeNode(3);
//        root.left.left = null;
//        root.left.right = null;
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(1);
//        root.left.right.left = null;
//        root.left.right.right = null;


        T24_FindPath_v2 fp = new T24_FindPath_v2();
        fp.FindPath(root,18);
    }
}
