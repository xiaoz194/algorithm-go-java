package class07_greedy_alogrithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname Code02_LowestLexicography
 * @Description 例题2 给定一个字符串类型的数组strs，找到一种拼接方式，
 * 使得把所有字符串拼起来之后形成的字符串具有最小的字典序。
 * 例如：["bk","at","cs"]
 * 策略1 先把数组中的字符串按字典序排序，再拼接。显然不对：["at","bk","cs"] =》 atbkcs
 * 看似是对额度，其实不一定每次都能得到字典序最小的。 举反例，如["b","ba"],先对每个字符串按字典序排序,
 * 得到["b","ba"],拼接得到"bba" 但是其实bab才是所有字符串拼起来之后形成的最小的字典序
 * 策略2 假设字符串数组中有 a b两个元素，根据a.b <= b.a（a作为前缀拼接b是否字典序小于等于b作为前缀拼接a）
 * 的策略来排序
 * @Date 2022/3/7
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code02_LowestLexicography {
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b) {
            return (a+b).compareTo(b+a); //compareTo返回字典序结果
        }
    }

    public String lowestString(String[] strs){
        if(strs==null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i=0;i<strs.length;i++){
            res += strs[i];
        }
        return res;
    }



}
