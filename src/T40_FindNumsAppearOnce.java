import java.util.HashMap;
public class T40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (array==null)
            return;
        int length = array.length;
        for(int i = 0;i<length;i++) {
            if(map.containsKey(array[i])){
                int value = map.get(array[i]);
                value += 1;
                map.put(array[i],value);
            }else{
                map.put(array[i],1);
            }
        }
        int count = 0;
        for(int i = 0;i<length;i++){
            if(map.get(array[i])==1 && count == 1){
                num2[0] = array[i];
            }

            if(map.get(array[i])==1 && count == 0){
                num1[0] = array[i];
                count +=1;
            }

        }

    }

    public static void main(String[] args) {
        T40_FindNumsAppearOnce t40 = new T40_FindNumsAppearOnce();
        int [] array = {1,2,2,3,4,4};
        int num1[] = new int[1];
        int num2[] = new int[1];
        t40.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
