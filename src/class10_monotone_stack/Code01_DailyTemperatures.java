package class10_monotone_stack;


import java.util.Stack;

// LCR 038 / 739  每日温度
public class Code01_DailyTemperatures {
    public static void main(String[] args) {
        int[] t= new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(t);
        for(int e:res) {
            System.out.print(e+ " ");
        }

    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        s.push(0);
        for(int i=1;i<temperatures.length;i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                res[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);

        }
        return res;
    }
}
