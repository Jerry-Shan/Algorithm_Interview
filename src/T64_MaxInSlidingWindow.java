import java.util.ArrayList;

public class T64_MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        for(; i<num.length;i++){
            int j = 1;
            int max = num[i];
            for(;j<size && j+i<num.length;j++){
                if(num[i+j] > max)
                    max = num[i+j];
            }
            if(size+i<num.length+1)
                res.add(max);
        }
        return  res;
    }

    public static void main(String[] args) {
        T64_MaxInSlidingWindow max = new T64_MaxInSlidingWindow();
        int [] num ={2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(max.maxInWindows(num,size));
        System.out.println(5/2);
    }
}
