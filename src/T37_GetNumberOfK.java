public class T37_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        int start = 0;
        int end   = array.length-1;
        int index = FindFirstNumberK(array,start,end,k);

        if(index == -1)
            return 0;
        int count = 0;
        for(;index<array.length&&array[index]== k;index++)
                count += 1;

        return  count;
    }

    public int FindFirstNumberK(int [] array, int start, int end, int k) {
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(array[mid]>k)
            return FindFirstNumberK(array,start,mid-1,k);// end is mid-1  rather than mid
        else if (array[mid]<k)
            return FindFirstNumberK(array,mid+1,end,k); // start is mid + 1
        else if(mid-1 >=0 && array[mid-1] == k)
            return FindFirstNumberK(array,start,mid-1,k);
        else // array[mid]==k
            return mid;
    }

    public int BinarySearchRecursion(int [] array, int start, int end, int k){

        if(start > end)
            return -1;
        int mid = (start + end) >> 1; // (start+end)/2
        if(array[mid]>k)
            return BinarySearchRecursion(array,mid+1,end,k);
        else if(array[mid]<k)
            return BinarySearchRecursion(array,start,mid-1,k);
        else
            return mid;
    }

    public int BinarySearchLoop(int [] array, int k){
        int start = 0;
        int end   = array.length;
        int mid = (start + end) >> 1;
        while (start<=end){
            if (array[mid]<k)
                start = mid + 1;
            else if (array[mid]>k)
                end = mid - 1;
            else
                return mid;
            mid = (start + end) >> 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,2,3,4,5,5,5,5,6,6,6};
        T37_GetNumberOfK getK = new T37_GetNumberOfK();
//        System.out.println(getK.GetNumberOfK(nums,3));
        System.out.println(getK.BinarySearchLoop(nums,4));
        System.out.println(getK.BinarySearchRecursion(nums,0,nums.length-1,4));
    }
}
