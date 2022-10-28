package DCL;

/**
 * @Classname Singleton
 * @Description TODO
 * @Date 2022/8/8
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Singleton {
    //饿汉单例
    //程序刚启动时就创建了实例
    private static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        //Singleton s = new Singleton();

    }
}


