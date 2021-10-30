package class02_sort2;

/**
 * @Classname Code02_SmallSum
 * @Description 小和问题 (leetcode hard)
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 如：[1，3，4，2，5]中
 * 1左边比1小的数 没有
 * 3左边比2小的数 1
 * 4左边比3小的数 1 3
 * 2左边比2小的数 1
 * 5左边比5小的数 1 3 4 2
 * 因此，小和= 1+1+3+1+1+3+4+2=16
 *
 * 解法：可以用暴力法，先遍历数组，每遍历到一个位置时，再遍历一遍该位置前面所有数，找到比该位置数小的数然后相加，
 * 这样做的时间复杂度为 O(n^2),如何优化到O(n*logn)?
 * 考虑采用归并排序的思想来解。
 * 逆向思考：找每一个数左边比当前数小的数 == 找当前数右边比该数大的数有几个
 * 然后利用归并排序的思想，在merge的过程中，产生小和。
 * @Date 2021/10/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_SmallSum {

    public static int getSmallSum(int[] nums){
        if(nums==null || nums.length<2)
            return 0;
        return process(nums,0,nums.length-1);
    }

    private static int process(int[] nums, int l, int r) {
        if(l==r)
            return 0;
        int mid =l +((r-l)>>1);
        return process(nums,l,mid)+process(nums,mid+1,r)+merge(nums,l,mid,r);
    }

    private static int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int p1 = l,p2 = mid+1;
        int idx = 0;
        int res = 0;
        while(p1<=mid && p2<=r){
            res += nums[p1]<nums[p2]?(r-p2+1)*nums[p1]:0;
            help[idx++] = nums[p1]<nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1<=mid)
            help[idx++] = nums[p1++];
        while(p2<=r)
            help[idx++] = nums[p2++];
        for(int i=0;i<help.length;i++)
            nums[l+i] = help[i];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5};
        int res = getSmallSum(nums);
        System.out.println(res);
    }

}
