package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fazhao on 2016/10/31.
 */
public class ReentrantLockTest {
    static int i = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static int addSum(){
        lock.lock();
        i++;
        System.out.println("currentThread:"+Thread.currentThread()+"   valueOf(i):"+i+"");
        lock.unlock();
        return i;
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
//                System.out.println("currentThread:"+Thread.currentThread());
                addSum();
            }
        }
    };

    /**
    * 没有lock
     * currentThread:Thread[Thread-0,5,main]   valueOf(i):1
     currentThread:Thread[Thread-1,5,main]   valueOf(i):2
     currentThread:Thread[Thread-0,5,main]   valueOf(i):3
     currentThread:Thread[Thread-1,5,main]   valueOf(i):4
     currentThread:Thread[Thread-0,5,main]   valueOf(i):5
     currentThread:Thread[Thread-1,5,main]   valueOf(i):6
     currentThread:Thread[Thread-0,5,main]   valueOf(i):7
     currentThread:Thread[Thread-0,5,main]   valueOf(i):9
     currentThread:Thread[Thread-1,5,main]   valueOf(i):8
     currentThread:Thread[Thread-0,5,main]   valueOf(i):10
     currentThread:Thread[Thread-1,5,main]   valueOf(i):11
     currentThread:Thread[Thread-0,5,main]   valueOf(i):12
     currentThread:Thread[Thread-0,5,main]   valueOf(i):14
     currentThread:Thread[Thread-0,5,main]   valueOf(i):15
     currentThread:Thread[Thread-0,5,main]   valueOf(i):16
     currentThread:Thread[Thread-1,5,main]   valueOf(i):13
     currentThread:Thread[Thread-1,5,main]   valueOf(i):17
     currentThread:Thread[Thread-1,5,main]   valueOf(i):18
     currentThread:Thread[Thread-1,5,main]   valueOf(i):19
     currentThread:Thread[Thread-1,5,main]   valueOf(i):20
    * */

    /**
    * 加入lock后是顺序的
     * currentThread:Thread[Thread-0,5,main]   valueOf(i):1
     currentThread:Thread[Thread-0,5,main]   valueOf(i):2
     currentThread:Thread[Thread-0,5,main]   valueOf(i):3
     currentThread:Thread[Thread-0,5,main]   valueOf(i):4
     currentThread:Thread[Thread-0,5,main]   valueOf(i):5
     currentThread:Thread[Thread-0,5,main]   valueOf(i):6
     currentThread:Thread[Thread-0,5,main]   valueOf(i):7
     currentThread:Thread[Thread-0,5,main]   valueOf(i):8
     currentThread:Thread[Thread-0,5,main]   valueOf(i):9
     currentThread:Thread[Thread-0,5,main]   valueOf(i):10
     currentThread:Thread[Thread-1,5,main]   valueOf(i):11
     currentThread:Thread[Thread-1,5,main]   valueOf(i):12
     currentThread:Thread[Thread-1,5,main]   valueOf(i):13
     currentThread:Thread[Thread-1,5,main]   valueOf(i):14
     currentThread:Thread[Thread-1,5,main]   valueOf(i):15
     currentThread:Thread[Thread-1,5,main]   valueOf(i):16
     currentThread:Thread[Thread-1,5,main]   valueOf(i):17
     currentThread:Thread[Thread-1,5,main]   valueOf(i):18
     currentThread:Thread[Thread-1,5,main]   valueOf(i):19
     currentThread:Thread[Thread-1,5,main]   valueOf(i):20
    * */
    public static void main(String args[]) {
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
    }
}
