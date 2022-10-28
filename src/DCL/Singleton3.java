package DCL;

/**
 * @Classname Singleton3
 * @Description TODO
 * @Date 2022/8/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Singleton3 {
    private static Singleton3 singleton = null;
    private Singleton3(){}

    //synchronized的粒度太大了，即锁的临界区太大了，有点影响效率
//    public static synchronized Singleton3 getInstance(){
//        synchronized ()
//        if(null == singleton){
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            singleton = new Singleton3();
//        }
//        return singleton;
//    }


    //再改进
    public static  Singleton3 getInstance(){
        /*
        一堆业务处理代码
         */
        if(null == singleton){

            //锁粒度变小 但是线程不安全了
            //有可能有两个线程同时进来  线程1 拿到了锁 线程1 - new    线程2  拿不到锁
            synchronized (Singleton3.class){

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // stop
                singleton = new Singleton3();
            }
        }
        return singleton;
    }




    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(()-> System.out.println(Singleton3.getInstance().hashCode())).start();
        }
    }
}

