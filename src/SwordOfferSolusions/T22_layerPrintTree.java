package SwordOfferSolusions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class T22_layerPrintTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // debug： new LinkedList<SwordOfferSolusions.TreeNode>() <>后的括号()漏了！注意细节。
        if(root == null)
            return resList;
        TreeNode curNode = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            curNode = queue.poll();
            if(curNode.left != null){
                queue.offer(curNode.left);
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
            }
            resList.add(curNode.val);
        }
        return resList;
    }

    // By each layer
    public ArrayList<ArrayList<Integer>> PrintTreeByLayer(TreeNode root) {
        if(root == null)
            return  null;
        ArrayList<ArrayList<Integer>> resLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> resList = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode preLayerLastNode = root; // pre layer last node
        TreeNode curLayerLastNode = root; // current layer last node
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode.left != null){
                queue.offer(curNode.left);
                curLayerLastNode = queue.getLast();
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
                curLayerLastNode = queue.getLast();
            }
            if(curNode == preLayerLastNode){ // add
                // add resList to resLists and create a new resList
                resList.add(curNode.val);
                resLists.add(resList);
                preLayerLastNode = curLayerLastNode;
                resList = new ArrayList<Integer>();
            }
            else{
                resList.add(curNode.val);
            }


        }

        return resLists;
    }

    // By each layer as Z style
    public ArrayList<ArrayList<Integer>> zPrintTreeByLayer(TreeNode root) {
        if(root == null)
            return  null;
        ArrayList<ArrayList<Integer>> resLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> resList = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode preLayerLastNode = root; // pre layer last node
        TreeNode curLayerLastNode = root; // current layer last node
        boolean leftToRight = true; // Flag using to control print order
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode.left != null){
                queue.offer(curNode.left);
                curLayerLastNode = queue.getLast();
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
                curLayerLastNode = queue.getLast();
            }
            if(curNode == preLayerLastNode){ // add
                // add resList to resLists and create a new resList
                resList.add(curNode.val);
                if(leftToRight)
                    resLists.add(resList);
                else{
                    Collections.reverse(resList);
                    resLists.add(resList);
                }
                preLayerLastNode = curLayerLastNode;
                resList = new ArrayList<Integer>();
                leftToRight = !leftToRight;
            }
            else{
                resList.add(curNode.val);
            }


        }
        return resLists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
/*        ArrayList<Integer> res = new ArrayList<Integer>();
        SwordOfferSolusions.T22_layerPrintTree pt = new SwordOfferSolusions.T22_layerPrintTree();
        res = pt.PrintFromTopToBottom(root);
        System.out.println(res);*/

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        T22_layerPrintTree pt = new T22_layerPrintTree();
        res = pt.PrintTreeByLayer(root);
        System.out.println(res);
        res = pt.zPrintTreeByLayer(root);
        System.out.println(res);
    }
}
