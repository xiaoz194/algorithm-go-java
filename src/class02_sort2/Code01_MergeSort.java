package class02_sort2;

/**
 * @Classname MergeSort
 * @Description 归并排序
 * 1）整体就是一个简单递归，左边排好序，右边排好序，让其整体有序
 * 2）让其整体有序的过程里用了外排序方法
 * 3）利用master公式求解时间复杂度 O(n*logn) 额外空间复杂度 O(n)
 * 4）归并排序的实质
 *
 * master公式： T(N) = a*T(N/b) + O(N^d) a 次数 1/b 自问题规模 O(N^d) 出递归外其他代码的时间复杂度
 * 等规模的递归问题 可以用master公式计算时间复杂度，如果自问题规模不等，则不能使用master公式
 * 1）log(b,a) < d 时间复杂度 O(N^d)
 * 2)log(b,a) > d 时间复杂度 O(N^log(b,a))
 * 3)log(b,a) == d 时间复杂度 O(N^d*logN)
 * @Date 2021/9/13
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_MergeSort {
    public static void mergeSort(int[] arr){
        if(arr==null || arr.length<2)
            return;
        process(arr,0,arr.length-1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l==r)
            return;
        int mid = l + ((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while(p1<=mid && p2<=r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for (i = 0;i < help.length;i++){
            arr[l+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,7,4,6,1,3,2,9};
        mergeSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
