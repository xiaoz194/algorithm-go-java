import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname Text
 * @Description TODO
 * @Date 2021/10/19
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Test {
    public static void main(String[] args) {
        canConstruct("aa","ab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] m = magazine.toCharArray();
        char[] r =ransomNote.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m.length;i++){
            map.put(m[i],map.getOrDefault(m[i],0)+1);
        }
        for(int i=0;i<r.length;i++){
            if(map.containsKey(r[i]) && map.get(r[i])>0){
                int count = map.get(r[i]);
                map.put(r[i],--count);
            }else{
                return false;
            }
        }
        return true;
    }

}
