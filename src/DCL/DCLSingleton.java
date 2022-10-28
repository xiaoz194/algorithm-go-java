package DCL;

/**
 * @Classname DCLSingleton
 * @Description TODO
 * @Date 2022/8/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */


/**
 * 指令重排序
 * Singleton A = new Singleton（）
 * 创建对象的时候，先分配空间，类里面的变量先有一个默认值，等调用了构造方法后才给变量赋值。
 * a = 1
 *
 * 例如int a = 1 刚开始的时候 a = 0。字节码指令执行过程如下，
 * 1）new 分配空间，
 * 2）赋默认值 0
 * 3）invokespecial 构造方法 初始化：a=1
 *
 * cpu  指令重排序
 * **/

public class DCLSingleton {
    private volatile static DCLSingleton singleton = null;//加上volatile
    //private static DCLSingleton singleton = null;
    private DCLSingleton(){}

    public static DCLSingleton getInstance(){
        /*
        一堆业务处理代码
         */
        if(null == singleton){
            synchronized(DCLSingleton.class){//锁粒度变小
                if(null == singleton){//DCL
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(()-> System.out.println(DCLSingleton.getInstance().hashCode())).start();
        }
    }
}


