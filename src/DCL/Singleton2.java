package DCL;

/**
 * @Classname Singleton2
 * @Description TODO
 * @Date 2022/8/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */

public class Singleton2 {
    //懒汉
    //真正用到它的时候才去创建实例，并不是一开始就创建
    private static Singleton2 singleton = null;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(null == singleton){
            //第一个线程过来了，执行到singleton = new Singleton2()，睡了1ms,正在睡的同时第二个线程来了，
            // 第二个线程执行到if判断时，结果肯定为空，因此接下来将会有两个线程各自创建一个对象，
            // 这必然会导致Singleton.getInstance().hashCode()结果不一致。
            // 可以通过给整个方法加上一把锁
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton2();
        }
        return singleton;
    }


    //存在一个问题，就是线程不安全的问题。例如，现在有1000个线程，
    // 都需要这一个Singleton的实例，验证一下是否拿到同一个实例
    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(()-> System.out.println(Singleton2.getInstance().hashCode())).start();
        }
    }

}


