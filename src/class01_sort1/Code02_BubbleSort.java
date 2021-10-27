package class01_sort1;
/**
 * @Classname Code02_BubbleSort
 * @Description 冒泡排序
 * @Date 2021/8/31
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_BubbleSort {

    public static void main(String[] args) {
        int arr[] = {5,7,4,6,1,3,2,9};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int arr[]){
        if(arr==null || arr.length<2){
            return;
        }
        for (int i=arr.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    /**
     * 技巧，异或运算
     * 性质：1 0^n = n n^n = 0    2 满足交换律和结合律
     * **/
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
