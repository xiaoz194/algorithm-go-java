package class02_sort2;

import java.util.PriorityQueue;

/**
 * @Classname Code08_SortArrayDistanceLessK
 * @Description 堆排序例题（优先级队列的应用）
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于
 * 数组来说比较小。请选择一个合适的排序算法针对这个数组进行排序。
 * 要求时间复杂度为O(nlogk)
 *
 * 思路：构建一个小根堆，遍历数组，先遍历前k个数，放进小根堆，此时，小根堆的最小值一定在原数组的0位置，
 * 因为任何数在排完序之后，离原始距离都不会超过k，所以k之后的数不可能在0位置上，因此0位置上的数必是当前这个
 * 小根堆的最小值。所以，把小根堆的最小值弹出，放到0位置上，接下来把第k+1个数放进小根堆，再从当前构建的新的
 * 小根堆中弹出最小值放到原数组1位置，理由同上。周而复始。
 * 最后，在数组临近结束时，只需要依次把小根堆的每一个最小值弹出，依次放到愿数组，完成排序
 *
 * 小根堆可以不用自己构造，借助优先级队列数据结构构造。
 * PriorityQueue默认是小根堆。
 * PriorityQueue的数组是两倍扩容。
 * PriorityQueue支持add一个数，poll一个数，不支持高效的在内部对堆结构进行改造，如删除某一个元素，
 * 让其重新变成堆，此时就需要手写堆结构才能做到高效。
 * @Date 2021/11/7
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code08_SortArrayDistanceLessK {

    public static void sortArrayDistanceLessK(int[] arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int idx = 0;
        int i = 0;
        for(;idx<Math.min(arr.length,k);++idx)
            heap.add(arr[idx]);
        for(;idx<arr.length;++idx,++i){
            heap.add(arr[idx]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty())
            arr[i++] = heap.poll();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,4,11,8,9,7,15,10};
        sortArrayDistanceLessK(arr,5);
        for(int e: arr){
            System.out.print(e + " ");
        }
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        heap.add(8);
//        heap.add(10);
//        heap.add(6);
//        heap.add(4);
//        heap.add(8);
//        heap.add(7);
//        while(!heap.isEmpty()){
//            System.out.println(heap.poll());
//        }
    }
}
