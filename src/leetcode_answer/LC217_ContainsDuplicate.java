package leetcode_answer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname LC217_ContainsDuplicate
 * @Description 217. 存在重复元素
 * @Date 2022/3/21
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length <2) return false;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
