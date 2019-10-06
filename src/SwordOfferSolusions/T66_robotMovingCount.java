package SwordOfferSolusions;

public class T66_robotMovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flags = new int[rows][cols];
        return count(0,0,threshold,rows,cols,flags);
    }

    private int count(int i, int j, int threshold, int rows, int cols,int[][] flags) {
        if(i<0 || j<0 || i>=rows || j>=cols || sum(i,j)>threshold || flags[i][j] == 1)
            return 0;
        flags[i][j] = 1;
        return  count(i-1,j,threshold,rows,cols,flags)
                + count(i+1,j,threshold,rows,cols,flags)
                + count(i,j-1,threshold,rows,cols,flags)
                + count(i,j+1,threshold,rows,cols,flags)
                + 1;
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
        int threshold = 2;
        int rows = 20;
        int cols =2;
        T66_robotMovingCount t66 = new T66_robotMovingCount();
        System.out.println(t66.movingCount(5,2,2));
    }
}
