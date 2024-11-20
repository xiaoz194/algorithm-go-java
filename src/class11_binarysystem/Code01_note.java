package class11_binarysystem;


/**
 * 1）二进制和位的概念
 * 2）正数怎么用二进制表达
 * 3）负数怎么用二进制表达
 * 4）打印二进制；直接定义二进制、十六进制的变量
 * 5）常见的位运算（|、&、^、~、<<、>>、>>>）
 * 6）解释打印二进制的函数
 * 7）注意|、&是位运算或、位运算与；||、&&是逻辑或、逻辑与，两者是有区别的
 * 8）相反数
 * 9）整数最小值的特殊性(取绝对值还是自己)
 * 10）为什么这么设计二进制（为了加法的逻辑是一套逻辑，没有条件转移），那么为啥加法逻辑如此重要呢？
 * 11）关于溢出（自己确保自己的调用所得到的结果不会溢出，一定是自己确保的，计算机不会给你做检查）
 * 12）位运算玩法很多很多，特别是异或运算（后面的课会详细讲述）、如何用位运算实现加减乘除（后面的课会详细讲述）
 **/

// 本文件的实现是用int来举例的
// 对于long类型完全同理
// 不过要注意，如果是long类型的数字num，有64位
// num & (1 << 48)，这种写法不对
// 因为1是一个int类型，只有32位，所以(1 << 48)早就溢出了，所以无意义
// 应该写成 : num & (1L << 48)
public class Code01_note {

    // 打印一个int类型的数字，32位进制的状态
    // 左侧是高位，右侧是低位
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            // 下面这句写法，可以改成 :
            // System.out.print((a & (1 << i)) != 0 ? "1" : "0");
            // 但不可以改成 :
            // System.out.print((a & (1 << i)) == 1 ? "1" : "0");
            // 因为a如果第i位有1，那么(a & (1 << i))是2的i次方，而不一定是1
            // 比如，a = 0010011
            // a的第0位是1，第1位是1，第4位是1
            // (a & (1<<4)) == 16（不是1），说明a的第4位是1状态
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===a===");
        // 负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===b===");
        // 二进制定义变量
        int c = 0b100110;
        System.out.println(c);
        printBinary(c);
        System.out.println("===c===");
        // 16进制定义变量
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("===d===");
        //打印相反数
        System.out.println(a);
        printBinary(a);
        printBinary(~a);
        System.out.println("======");
        // e是a的相反数
        int e = ~a + 1;
        System.out.println(e);
        System.out.println("===e===");
        // int long的最小值，取相反数是自己，没法转换，因为会溢出
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);
        System.out.println(-f);
        printBinary(-f);
        System.out.println(~f+1);
        printBinary(~f+1);
        System.out.println("===f===");
        // | & ^
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        printBinary(g ^ h);
        System.out.println("===g,h===");
        // 可以这么写： int num = 3231 | 6434
        // 可以这么写：int num = 3231 & 6434
        // 不能这么写：int num = 3231 || 6434
        // 不能这么写：int num = 3231 && 6434
        // 因为 || && 是逻辑与、逻辑或，只能连接boolean类型
        // 不仅如此，| & 连接的两侧一定会计算，而|| && 具有截断性特点
        System.out.println("test1 测试开始");
        boolean test1 = returnTrue() | returnFalse();
        System.out.println("test1 测试结果："+test1);
        System.out.println("test2 测试开始");
        boolean test2 = returnTrue() || returnFalse();
        System.out.println("test2 测试结果："+test2);
        System.out.println("test3 测试开始");
        boolean test3 = returnFalse() & returnTrue();
        System.out.println("test3 测试结果："+test3);
        System.out.println("test4 测试开始");
        boolean test4 = returnFalse() & returnTrue();
        System.out.println("test4 测试结果："+test4);
        // << 左移
        int i = 0b0011010;
        printBinary(i);
        printBinary(i<<1);
        printBinary(i<<2);
        System.out.println("===i << ===");
        // >> >>> 右移 非负数 这两效果一样
        printBinary(i);
        printBinary(i>>2);
        printBinary(i>>>2);
        System.out.println("===i >> >>> ===");
        // 负数 >> >>> 效果不一样: >> 拿符号为补位，>>> 一律用0补位
        int j = 0b11110000000000000000000000000000;
        printBinary(j>>2);
        printBinary(j>>>2);
        System.out.println("===j >> >>> ===");


    }

    public static boolean returnTrue() {
        System.out.println("进入了returnTrue函数");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("进入了returnFalse函数");
        return false;
    }

}
