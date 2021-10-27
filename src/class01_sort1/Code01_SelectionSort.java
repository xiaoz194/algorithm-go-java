package class01_sort1;
/**
 * @Classname Code02_BubbleSort
 * @Description 选择排序
 * @Date 2021/8/31
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_SelectionSort {
    public static void main(String[] args) {
        int arr[] = {5,7,4,6,1,3,2,9};
        selectionSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp =arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
