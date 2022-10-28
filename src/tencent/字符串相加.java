package question;

/**
 * @Classname 字符串相加
 * @Description 415
 * @Date 2022/8/17
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int n1 = i>=0 ? num1.charAt(i) - '0' : 0;
            int n2 = j>=0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        if(carry>0){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
