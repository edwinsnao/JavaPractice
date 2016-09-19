package thread;

/**
 * Created by fazhao on 16/9/19.
 */

/**
* 可以既继承Thread也实现Runnable，但是没意义
* */
public class ThreadTest  extends Thread implements Runnable {
//public class ThreadTest extends Thread {
    int i = -1;
    private boolean stop = false;
    public ThreadTest(int i){
        this.i = i;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
//        super.run();
        /*while(!stop)
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread"+this.i+": " +i);
//            try{
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }*/
        System.out.println("Thread"+i);
        Main.SUM+=1;
        System.out.println(Main.SUM);
    }
}
