import java.util.ArrayList;

// Implement Heap Structure by hands
public class Heap {

    // build Heap
    private ArrayList<Integer> buildHeap(int[] nums){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0)
            return  res;
        int[] heap = new int[nums.length];
        for (int i = 0; i<nums.length;i++){
            heap[i] = nums[i];
            heapInsert(heap,i,nums[i]);
        }
        for (int i = 0; i < heap.length;i++){
            res.add(heap[i]);
        }
        return res;
    }

    // insert x to heap
    private void heapInsert(int[] heap, int index, int x) {
        while (index > 0) {
            int parent = (index - 1) >>> 1;
//            if (x > heap[parent]) { // X 大于 父节点值 ---> 最大堆
            if (x < heap[parent]) { // X 小于 父节点值 ---> 最小堆
                heap[index] = heap[parent]; // 父节点值向下沉
                index = parent; // index 往上等于父节点index，继续比较
            } else {
                break;
            }
        }
        heap[index] = x;
    }

    // extract the head of heap
/*    private int heapExtract(int[] heap){
        int head = heap[0];
        heap[0] = heap[heap.length-1];


    }*/
    // Top K
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // [4,5,1,6,2,7,3,8],0
        if (input == null || k > input.length || k <= 0)
            return list;
        int[] target = new int[k];
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            if (i < k) {
                target[i] = input[i];
                heapInsert(target, i, target[i]);
            } else {
                if (target[0] > input[i]) { // 最大堆下沉
                    target[0] = input[i];
                    shiftDown(target, 0, target[0]);
                    // 相比优先级队列，这里不会offer操作(里面有上浮)，少了一步上浮调整，效率高了不止一丁点
                }
            }
        }
        for (int i = 0; i < k; ++i) {
            list.add(target[i]);
        }
        return list;
    }




    private void shiftDown(int[] target, int k, int x) {
        int half = target.length >>> 1;
        while (k < half) {
            int child = (k << 1) + 1; // 默认先左孩子
            int big = target[child];
            int right = child + 1;
            if (right < target.length && target[right]>big) {
                big = target[right];
                child = right; // 可以直接一步big = target[child = right];
            }
            if (x > big) // x比子节点中的最大值还大，已经是大顶堆了
                break; // 往上拉不动了，准备退出把最初堆顶的结点赋值到上一个结点
            target[k] = big; // 往上拉
            k = child;
        }
        target[k] = x;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int [] nums = {4,1,2,3,6,5,7};
        ArrayList<Integer> minHeap = heap.buildHeap(nums);
        System.out.println(minHeap);
        System.out.println(minHeap.get(0));
//        ArrayList<Integer> newMinHeap = heap.buildHeap(minHeap);
        System.out.println(minHeap);


    }
}
