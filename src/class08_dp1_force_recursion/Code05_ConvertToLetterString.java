package class08_dp1_force_recursion;

/**
 * @Classname Code05_ConvertToLetterString
 * @Description 规定1和A对应、2和B对应、3和C对应... 那么一个数字字符串比如"111"，
 * 就可以转化为"AAA"、"KA"和"AK"。 给定一个只有数字字符组成的字符串str，返回有多少种转化结果。
 * @Date 2022/3/12
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code05_ConvertToLetterString {

    //i之前的位置，如何转化已经做过决定了
    //i... 有多少种转化的结果
    private int process(char[] str,int i){
        if(i == str.length) return 1;
        if(str[i] == '0') return 0;
        if(str[i] == '1'){
            int res = process(str,i+1);// 第i个位置单独转化为一个字母,后续有多少种方法
            //第i+1位置可以是任意数字 都能和i位置拼成一个字母 因为是26个字母，第1个位置是1，第二个位置任意都可以）
            //若i，i+1可以组合，后续有多少种方法
            if(i+1 < str.length){
                res += process(str,i+2);
            }
            return res;
        }
        if(str[i] == '2'){
            int res = process(str,i+1);// 第i个位置单独转化为一个字母
            //如果i+1位置不越界，且范围在0～6 则可以组合成一个字母 （因为是26个字母，第二个位置不能超过6）
            //若i，i+1可以组合，后续有多少种方法
            if(i+1 < str.length && (str[i+1] >='0' && str[i+1] <='6')){
                res += process(str,i+2);
            }
            return res;
        }
        //i位置的数 是 '3'～'9'
        return process(str,i+1);
    }

}
