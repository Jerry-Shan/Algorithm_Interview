package SwordOfferSolusions;

import java.util.LinkedList;
import java.util.Queue;

public class T61_serialTree {

    private String serialTreeByPreOrder(TreeNode root) {

        if(root == null){
            return "#!";
        }
        String res = root.val+"!";
        res += serialTreeByPreOrder(root.left);
        res += serialTreeByPreOrder(root.right);
        return res;
    }

    private TreeNode DeserialTree(String serial){
        String [] nodes = serial.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i< nodes.length;i++){
            queue.offer(nodes[i]);
        }
        return DeserialTreeByPreOrder(queue);
    }

    private TreeNode DeserialTreeByPreOrder(Queue<String> queue) {
        String node = queue.poll();
        if(node.equals("#"))
            return null;
        TreeNode head = new TreeNode(Integer.valueOf(node));
        head.left = DeserialTreeByPreOrder(queue);
        head.right = DeserialTreeByPreOrder(queue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);

        T61_serialTree st = new T61_serialTree();
        String serial = st.serialTreeByPreOrder(root);
        System.out.println(serial);
        TreeNode newRoot = st.DeserialTree(serial);
        System.out.println(newRoot.val);
    }

}
