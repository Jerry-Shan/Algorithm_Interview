import java.util.Stack;

public class T20_stackWithGetMin {

    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack  = new Stack<Integer>();
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek())
            minStack.push(node);
        // add the old peek value as new peak value (min value)
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    // get top node value in Stack
    public int top() {
        return dataStack.peek();
    }
    // get min node value in Stack
    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        T20_stackWithGetMin stackGetMin = new T20_stackWithGetMin();
        stackGetMin.push(20);
        System.out.println(stackGetMin.min());
        stackGetMin.push(10);
        System.out.println(stackGetMin.min());
        stackGetMin.push(5);
        System.out.println(stackGetMin.min());
    }
}
