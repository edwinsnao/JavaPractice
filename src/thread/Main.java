package thread;

/**
 * Created by fazhao on 16/9/19.
 */
public class Main {
//    public volatile static int SUM  = 1;
    public static int SUM  = 1;
    public static void main(String args[]) {
        ThreadTest t1 = new ThreadTest(1);
        t1.setPriority(1);
        ThreadTest t2 = new ThreadTest(2);
        ThreadTest t3 = new ThreadTest(3);
        /**
         * Thread1: 0
         Thread1: 1
         Thread1: 2
         Thread1: 3
         Thread1: 4
         Thread2: 0
         Thread2: 1
         Thread2: 2
         Thread2: 3
         Thread2: 4
         Thread2: 5
         Thread2: 6
         Thread2: 7
         Thread2: 8
         Thread2: 9
         Thread1: 5
         Thread1: 6
         Thread1: 7
         Thread1: 8
         Thread1: 9
         end
         这里是因为Thread2在thread1之后运行，start是需要短暂时间配置
         所以thread1先运行，然后由于thread2优先级高所以先执行完再1执行
        * 优先度高的先执行完再继续其他没执行完的线程
        * */
        t2.setPriority(10);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
//            t1.wait();
//            t2.wait();
//            Thread.sleep(1000);
//            t1.notifyAll();
//            t2.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setStop(true);
        t2.setStop(true);
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(t1.getContextClassLoader());
        System.out.println(t2.getContextClassLoader());
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getPriority());
        System.out.println("end");
//        t1.notifyAll();
//        t2.notifyAll();
    }
}
