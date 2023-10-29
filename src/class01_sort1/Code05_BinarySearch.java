package class01_sort1;

/**
 * @Classname Code05_BinarySearch
 * @Description 二分搜索法
 * 在一个有序数组中，找某个数是否存在
 * 二分法的时间复杂度是logN
 * @Date 2021/9/7
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code05_BinarySearch {

    public static boolean binarySearch(int[] arr,int target){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
           int mid = (l+r)/2;
           if (arr[mid] == target) {
               return true;
           }else if(arr[mid] > target){
                r = mid -1;
           }else if(arr[mid] < target){
                l = mid +1;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 21;
        int[] arr = {1,2,5,7,10,15,18,21,29};
        boolean res = binarySearch(arr, target);
        System.out.println(res);
    }

}
