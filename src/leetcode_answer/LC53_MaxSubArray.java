package leetcode_answer;

/**
 * @Classname LC53_MaxSubArray
 * @Description TODO
 * @Date 2022/3/21
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class LC53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum>=0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
