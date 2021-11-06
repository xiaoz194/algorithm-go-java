package class02_sort2;

/**
 * @Classname Code06_RandomQuickSort
 * @Description 随机快排
 * 时间复杂度 O(nlog) 空间复杂度 O(logn)
 * @Date 2021/11/3
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code06_RandomQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,8,1,4,11,7,7,9,8,13};
        randomQuickSort(arr,0,arr.length-1);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }

    public static void randomQuickSort(int[] arr,int l,int r){
        if(l<r){
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);
            int[] p = partition(arr,l,r);
            randomQuickSort(arr,l,p[0]-1);
            randomQuickSort(arr,p[1]+1,r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l<more){
            if(arr[l]==arr[r])
                ++l;
            else if(arr[l]<arr[r])
                swap(arr,l++,++less);
            else
                swap(arr,l,--more);
        }
        swap(arr,more,r);
        return new int[] {less+1,more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
