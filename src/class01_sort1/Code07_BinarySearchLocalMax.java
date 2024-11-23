package class01_sort1;

/**
 * @Classname Code07_BinarySearchLocalMax
 * @Description 二分搜索法应用
 * 求无序数组的局部最大值的下标，无序数组相邻的数一定不相等，如果有多个局部最大值，任意返回一个即可
 * 要求时间复杂度O(logn)
 * @Date 2021/9/7
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code07_BinarySearchLocalMax {

    public static int binarySearch(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return - 1;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,9,6,5,2,1};
        int res = binarySearch(arr);
        System.out.println(res);
    }

}
