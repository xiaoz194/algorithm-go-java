package class02_sort2;

// leetcode493. 翻转对  https://leetcode.cn/problems/reverse-pairs/
// 归并分治，套归并排序思路
public class Code11_ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int ans = process(nums, 0, nums.length - 1);
        return ans;
    }

    public int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r)
                + merge(nums, l, mid, r);
    }

    public int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int res = 0;
        int x = l, y = mid + 1;
        while (x <= mid && y <= r) {
            if ((long) nums[x] > (long) 2 * nums[y]) {
                res += mid - x + 1;
                y++;
            } else {
                x++;
            }
        }


        int p1 = l, p2 = mid + 1, idx = 0;

        while (p1 <= mid && p2 <= r) {
            help[idx++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[idx++] = nums[p1++];
        }
        while (p2 <= r) {
            help[idx++] = nums[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
        return res;
    }


}
