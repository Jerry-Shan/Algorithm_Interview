import java.util.Stack;

public class T21_StackPushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if(pushA == null || popA == null || pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int indexPush = 0;
        int indexPop  = 0;
        while (indexPop < popA.length){
            // Do not find the equal value
            if (stack.isEmpty() || stack.peek() != popA[indexPop]){
                // the push sequence is not clear
                if(indexPush < pushA.length){
                    stack.push(pushA[indexPush]);
                    indexPush += 1;
                }
                else
                    return false;
            }
            // Find the equal value
            else{
                stack.pop();
                indexPop += 1;
            }
        }
        return true;
    }
}

