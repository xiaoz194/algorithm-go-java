/**
 * @Classname Text
 * @Description TODO
 * @Date 2021/10/19
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,5,4,9,6,3,1};
        mergeSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    private static void mergeSort(int[] arr) {
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
}
