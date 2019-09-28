import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T59_zPrintTree {
    public ArrayList<Integer> Print(TreeNode pRoot) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = true;
        if(pRoot == null)
            return resList;
        TreeNode curNode = null;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            curNode = queue.poll();
            System.out.println(curNode.val);
            if (flag){
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            else{
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
            }
            resList.add(curNode.val);
            flag = !flag;
        }
        return resList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(7);

        ArrayList<Integer> res = new ArrayList<Integer>();
        T59_zPrintTree pt = new T59_zPrintTree();
        res = pt.Print(root);
        System.out.println(res);
    }
}
