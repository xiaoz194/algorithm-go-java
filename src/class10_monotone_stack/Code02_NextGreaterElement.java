package class10_monotone_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496 下一个更大元素I
public class Code02_NextGreaterElement {
    public static void main(String[] args) {
        int[] num1 = new int[]{2,4};
        int[] num2 = new int[]{1,2,3,4};
        int[] res = nextGreaterElement(num1, num2);
        for(int r:res){
            System.out.print(r+" ");
        }

    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums2.length];
        int[] res = new int[nums1.length];
        Arrays.fill(ans,-1);
        Arrays.fill(res,-1);
        stack.add(0);
        for(int i=1;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                ans[stack.peek()] = nums2[i];
                if(map.containsKey(nums2[stack.peek()])){
                    res[map.get(nums2[stack.peek()])] = ans[stack.peek()];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
