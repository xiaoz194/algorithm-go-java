package class02_sort2;

/**
 * @Classname Sort07_HeapSort
 * @Description 堆排序
 * 时间复杂度 O(nlogn) 额外空间复杂度为O(1)
 * 在O(nlogn)的排序算法中，只有堆排序能做到额外空间复杂度为O(1),merge sort O(n),quick sort O(logn)
 * @Date 2021/11/6
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */

/**
 * 1.堆是一个完全二叉树
 * 2.下标从0开始的连续数组可以构造一个完全二叉树，0，1，2，...,n
 * 3.节点i的左孩子 2*i + 1  节点i的右孩子 2*i + 2 节点i的父亲 (i-1)/2
 * 4.优先级队列结构，底层就是堆结构
 * **/

//构造大顶堆
public class Sort07_HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,8,1,4,11,7,7,9,8,13};
        heapSort(arr);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }

    public static void heapSort(int[] arr){
        if(arr.length<2 || arr == null)
            return;
        //O(nlogn)  这里后面介绍一种O(n)的构建方法
        for(int i=0;i<arr.length;i++){ //O(n)
            heapInsert(arr,i); // O(logn)
        }

        /**
         * 更快的heapsort方法，不需要heapInsert过程，直接对数组整体进行操作，改造成大根堆
         * 思路：i从n-1开始，即从最后一个叶子节点开始往前做heapify，时间复杂度为O(n)
         * **/
        for(int i=arr.length-1;i>=0;i--){
            heapify(arr,i,arr.length);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        //O(nlogn)
        while(heapSize>0){  // O(n)
            heapify(arr,0,heapSize);  // O(logn)
            swap(arr,0,--heapSize); //O(1)
        }
    }



    /**
     * 插入，某个数现在正处于idx位置，继续上浮
     * 当idx位置的数不再大于父位置的数或已经到根节点时，停止循环
     * arr[idx]>arr[(idx-1)/2]涵盖了两个循环条件，
     * 因为当到根节点（0位置） (idx-1)/2依然是0位置，while条件依然不会成立（相等）
     * 调整代价 O(logn)
     * **/
    public static void heapInsert(int[] arr,int idx){
        while(arr[idx]>arr[(idx-1)/2]){
            swap(arr,idx,(idx-1)/2);
            idx = (idx-1)/2;
        }
    }

    /**
     * idx位置元素下浮，根节点和左右孩子的最大值比较，若小于，则交换位置
     * 直到它不再小于左右孩子的最大值或没有左右孩子时停止
     * 调整代价 O(logn)
    **/
    public static void heapify(int[] arr,int idx,int heapSize){
        int left = idx*2+1; //左孩子下标
        while(left < heapSize){//下方有孩子
            //两个孩子中，谁的值大，下标给largest
            int largest = left+1 <heapSize && arr[left+1] > arr[left] ? left+1 : left;
            //父亲和最大的孩子，谁的值大，下标给largest
            largest = arr[idx] > arr[largest] ? idx:largest;
            if(largest == idx)
                break;
            swap(arr,largest,idx);
            idx = largest;
            left = idx*2+1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
