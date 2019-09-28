import java.util.HashMap;

public class T34_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str == null)
            return -1;
        int [] times = new int[256];
        for (int i = 0; i<str.length();i++){
            System.out.println(str.charAt(i));
            times[str.charAt(i)]+=1;
        }

        for (int i = 0; i<str.length();i++){
            System.out.println(str.charAt(i) + " : "+times[str.charAt(i)]);
            if (times[str.charAt(i)] == 1)
                return str.indexOf(str.charAt(i));
        }
        return -1;
    }

    public int FirstNotRepeatingCharHashMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
            if (str==null)
                return -1;
            int length = str.length();
            for(int i = 0;i<length;i++) {
                if(map.containsKey(str.charAt(i))){
                    int value = map.get(str.charAt(i));
                    map.put(str.charAt(i),value+1);
                }else{
                    map.put(str.charAt(i),1);
                }
            }
            for(int i = 0;i<length;i++){
                if(map.get(str.charAt(i))==1)
                    return i;
            }
            return -1;
    }

    public static void main(String[] args) {
        T34_FirstNotRepeatingChar fnrc = new T34_FirstNotRepeatingChar();
        String str = "google";
        System.out.println(fnrc.FirstNotRepeatingChar(str));
        System.out.println(fnrc.FirstNotRepeatingCharHashMap(str));
    }
}
