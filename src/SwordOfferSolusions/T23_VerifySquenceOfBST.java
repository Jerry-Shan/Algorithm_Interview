package SwordOfferSolusions;

import java.util.Arrays;
public class T23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len  = sequence.length;
        if(len <= 0 || sequence==null)
            return false;
        int rootVal = sequence[len-1];
        int i = 0;
        for(; i<len-1;i++){
            if(sequence[i]>rootVal){
                break;
            }
        }
        int index = i;
        for (int j = i;j<len-1;j++){
            if(sequence[j]<rootVal)
                return false;
        }
        boolean left=true;
        boolean right=true;
        if(index>0){
            int [] leftNodes  = Arrays.copyOfRange(sequence,0,index);
            left = VerifySquenceOfBST(leftNodes);
        }

        if(index<len-1){
            int [] rightNodes = Arrays.copyOfRange(sequence,index,len-1);
            right = VerifySquenceOfBST(rightNodes);
        }
        return (left&&right);
    }

    public static void main(String[] args) {
        T23_VerifySquenceOfBST vsbst = new T23_VerifySquenceOfBST();
        int [] s = new int[]{6,7}; //= new int[8,6,12,16,14,10];
        boolean res = vsbst.VerifySquenceOfBST(s);
        System.out.println(res);
    }
}
