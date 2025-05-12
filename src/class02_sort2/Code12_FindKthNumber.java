package class02_sort2;

// 无序数组中寻找第K大的数
// 给定整数数组nums和整数K，返回数组中第K大的元素
// 寻找到是数组排序后第K大的元素，不是第K个不同的元素
// 要求时间复杂度O(n),空间复杂度O(1) -> 这就要求不能排序，因为排序最好的时间复杂度都要O(nlogn)
// 采用荷兰国旗划分思路来实现
public class Code12_FindKthNumber {
    public static void main(String[] args) {
        int[] arr = {3,2,6,4,7,11,8}; // 2 3 4 6 7 8 11
        int k = 3;
        int res = FindKthNumber(arr,k);
        System.out.println(res);
    }
    public static int less,more;
    public static int FindKthNumber(int[] arr, int k) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r; ) {
            partition(arr,l,r,arr[l+(int)(Math.random()*(r-l+1))]);
            if (k < less) {
                r = less -1;
            } else if (k > more) {
                l = more+1;
            } else {
                ans = arr[arr.length - k];
                break;
            }
        }
        return ans;
    }

    public static void partition(int[] arr, int l, int r, int x) {
        less = l;
        more = r;
        int idx = l;
        while (idx < more) {
            if (arr[idx] < x) {
                swap(arr, less++, idx++);
            } else if (arr[idx] > x) {
                swap(arr, more--, idx);
            } else {
                idx++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
