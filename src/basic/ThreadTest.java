package basic;

/**
 * Created by fazhao on 16/9/8.
 */
public class ThreadTest extends Thread{
    int id;

    ThreadTest(int id){
        this.id = id;
    }
    @Override
    public void run() {
        super.run();
//        try {
//            sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("run()"+id);
    }

    public void run(String s){
//        try {
//            sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(s);
    }

    public static void main(String args[]){
        ThreadTest tt = new ThreadTest(0);
        ThreadTest tt1 = new ThreadTest(1);
        /**
        * 结果输出：hello
         run()
         和预料相反的原因是start需要配置时间(两个同时加入了sleep相同时间就正常了)，而run(String s)是直接运行的，所以就出现了start的反而后运行的情况
        * */
        System.out.println(tt.isAlive()+"");
        tt.start();
        /**
        * 只能start一次？多次调用start报错：IllegalThreadStateException
        * */
//        tt.start();
//        tt.start();
        System.out.println(""+tt.isAlive());
        /**
        * run可以多次调用，start不可以
        * */
        tt.run();
        tt.run();
        tt.run();

        /**
        * lang.IllegalMonitorStateException???
        * */
        try {
            tt.wait();
//            tt.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tt.run("hello");
        tt.run("hello");
//        try {
//            tt1.join();
            tt1.start();
        tt.notify();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        tt.run("hello");
        /**
        * 运行前和运行结束（run执行完）后都为false
        * */
        System.out.println(""+tt.isAlive());
    }
}
