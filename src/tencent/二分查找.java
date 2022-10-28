package question;

/**
 * @Classname 二分查找
 * @Description 704.二分查找 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target
 * ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * @Date 2022/8/17
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class 二分查找 {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l<=r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}
