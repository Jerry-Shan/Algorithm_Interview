import java.util.Stack;

public class T44_reverseSentence {
    // reverse a whole sentence but do not reverse letters in a word.
    public String ReverseSentence(String str) {
        // using str.trim().equals("") to remove multiple space
        if(str==null||str.trim().equals(""))
            return str;
        String reverseStr = Reverse(str);
        String [] words = reverseStr.split("");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< words.length-1;i++){
            sb.append(Reverse(words[i])+" ");
        }
        // Note : the last word without space symbol
        sb.append(Reverse(words[words.length-1]));
        return sb.toString();
    }
    public String Reverse(String str){
        StringBuffer sb = new StringBuffer();
        int index = 0;
        Stack<Character> stack = new Stack<Character>();
        for(;index < str.length();index++){
            stack.push(str.charAt(index));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T44_reverseSentence reverse = new T44_reverseSentence();
        String a = "ab     cd efg.   ";
//        System.out.println(reverse.Reverse(a));
//        System.out.println(reverse.ReverseSentence(a));
        System.out.println(a);
        System.out.println(a.trim());
    }
}
