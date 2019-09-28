import java.util.Stack;

public class T05_twoStacksQueue {
    Stack<Integer> stack1 = new Stack<Integer>(); // push
    Stack<Integer> stack2 = new Stack<Integer>(); // for pop

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        T05_twoStacksQueue queue = new T05_twoStacksQueue();
        int i = 5;
        queue.push(i);
        System.out.println(queue.pop());
    }
}
