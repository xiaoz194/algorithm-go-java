package class01_sort1;

import java.util.Arrays;

/**
 * @Classname Code04_InsertionSort
 * @Description 插入排序 时间复杂度O(n^2) 空间复杂度O(1) 最好情况时间复杂度O(n)
 * @Date 2021/9/6
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code04_InsertionSort {
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length<2)
            return;
        //0~0有序 ，0～i让其有序
        for (int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0 && arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }


    public static void insertionSort2(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i=1;i<arr.length;i++) {
            for(int j=i;j>=0 && arr[j-1]>arr[j];j--) {
                swap(arr,j,j-1);
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp =arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i=0;i<testTime;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArr(arr1);
            insertionSort2(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice!":"Error!");
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        for (int i=0;i<arr1.length;i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 对数器
     * 构建一个简单不追求效率但绝对正确的方法a测试
     * 需要测试即自己写的算法
     * 随机生成器
     **/

    //for test  method A  this is an absolute right method
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    //for test  随机生成器 返回一个长度和值都随机的数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)Math.random()*(maxSize+1)];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)Math.random()*(maxValue+1) - (int)Math.random()*maxValue;
        }
        return arr;
    }

    //for test copy arr
    public static int[] copyArr(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

}
