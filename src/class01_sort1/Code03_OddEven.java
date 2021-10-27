package class01_sort1;

/**
 * @Classname Code03_OddEven
 * @Description 问题1数组中 一种数出现了奇数次，其他的数都出现了偶数次，怎么找到出现奇数次的数
 * 问题2 数组中两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两种出现奇数次的数
 * 要求时间复杂度on，空间复杂度o1
 * @Date 2021/8/31
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code03_OddEven {
    public static int printOddEven1(int[] arr){
        int eor = 0;
        for (int e:arr){
            eor ^= e;
        }
        return eor;
    }

    public static int[] printOddEven2(int[] arr){
        int eor = 0;
        for (int e : arr){
            eor ^= e;
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一位为1
        int rightOne = eor & (~eor+1);//提取二进制中最右边的1
        int onlyOne = 0;
        for (int cur : arr){
            if ((cur & rightOne) == 0)
                onlyOne ^= cur;
        }
        int otherOne = eor ^ onlyOne;
        return new int[]{otherOne,onlyOne};
    }


    public static void main(String[] args) {
        System.out.println(printOddEven1(new int[]{1,2,3,2,1,1,1,3,3}));
        int[] ans = {1, 2, 3, 2, 1, 1, 1, 3, 3, 5};
        int[] res = printOddEven2(ans);
        for (int e : res){
            System.out.print(e + " , ");
        }

    }

}
