package SwordOfferSolusions;

import java.util.Stack;

// 回溯法的非递归方法

public class T66_robotMovingCount_Non_Recursive {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0 || rows<0 || cols<0)
            return 0;
        // 上下左右格子
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};

        boolean [] flags = new boolean[rows*cols];
        flags[0] = true; // 访问过标记为 true

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        int count = 0;

        while (!stack.isEmpty()){
            int curIndex = stack.pop();
            count += 1;
            for (int i = 0; i<4;i++){
                int curRow = curIndex / cols + x[i];
                int curCol = curIndex % cols + y[i];
                int digitalSum = sum(curRow,curCol);
                if (curCol>=0 && curCol<cols && curRow>=0 && curRow<rows && digitalSum <= threshold && !flags[curRow * cols + curCol]){
                    stack.add(curRow * cols + curCol);
                    flags[curRow * cols + curCol] = true;
                }
            }
        }
        return count;
    }

    private  int sum(int i, int j){
        int sum = 0;
        do {
            sum += i%10;
            i = i/10;
        }while (i>0);
        do {
            sum += j%10;
            j = j/10;
        }while (j>0);
        return sum;
    }

    public static void main(String[] args) {
        int threshold = 4;
        int rows = 20;
        int cols =5;
        T66_robotMovingCount_Non_Recursive t66 = new T66_robotMovingCount_Non_Recursive();
        System.out.println(t66.movingCount(threshold,rows,cols));
    }
}
