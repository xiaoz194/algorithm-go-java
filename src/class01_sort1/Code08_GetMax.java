package class01_sort1;

/**
 * @Classname Code08_GetMax
 * @Description 递归的方法找数组中的最大值
 * @Date 2021/9/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code08_GetMax {

    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int l, int r) {
        int mid = l + ((r-l)>>1);
        if (l==r) return arr[l];
        int leftMax = process(arr,l,mid);
        int rightMax = process(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }

}
