package LeetCodeSolutions;

import java.util.ArrayList;

public class lc120_Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    /* // method 1 - modify the original list
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    */
        if (triangle.isEmpty())
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int [][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        // Bottom level initialization
        for (int i =0;i<triangle.get(triangle.size()-1).size();i++)
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);

        // From the last second line to the top line
        for(int i = triangle.size()-2; i >=0;i--){
            for (int j = 0; j<=i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>(9);
        for(int i = 0;i<9;i++){
            ArrayList<Integer> layer = new ArrayList<Integer>();
            for (int j = 0; j<=i;j++){
                layer.add(1);
            }
            System.out.println(layer);
            triangle.add(layer);
        }
        lc120_Triangle tri = new lc120_Triangle();
        System.out.println(tri.minimumTotal(triangle));
    }
}
