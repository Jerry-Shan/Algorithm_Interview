package Interview2019;

import java.util.*;

public class LucyNums {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int max=0;
        int temp;
        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
                if(a[j]>=a[i])
                {
                    temp=a[i]^a[j];
                    max=max>temp?max:temp;
                    break;
                }
            for(int j=i+1;j<n;j++)
                if(a[j]>=a[i])
                {
                    temp=a[i]^a[j];
                    max=max>temp?max:temp;
                    break;
                }
        }
        System.out.println(max);
    }

}

