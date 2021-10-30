package class02_sort2;

/**
 * @Classname Code03_ReversePairs
 * @Description 逆序对问题（和"小和问题"反过来）
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，
 * 求出这个数组中的逆序对的总数。
 * 如：
 * 输入: [7,5,6,4]
 * 输出: 5
 * 与小和问题是逆向思维，将归并排序由从小到大排序换成从大到小排序
 * @Date 2021/10/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code03_ReversePairs {
    public static int reversePairs(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;
        return process(nums,0,nums.length-1);
    }

    private static int process(int[] nums,int l,int r){
        if(l==r)
            return 0;
        int mid = l+((r-l)>>1);
        return process(nums,l,mid) + process(nums,mid+1,r) + merge(nums,l,mid,r);
    }

    private static int merge(int[] nums,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int p1=l,p2=mid+1;
        int idx = 0;
        int res = 0;
        while(p1<=mid && p2<=r){
            res += nums[p1]>nums[p2]? (r-p2+1):0;
            help[idx++] = nums[p1]>nums[p2]?nums[p1++]:nums[p2++];
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
        int[] nums = {7,5,6,4};
        int res = reversePairs(nums);
        System.out.println(res);
    }

}
