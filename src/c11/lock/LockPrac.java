package c11.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Kings on 2016/4/12.
 */
/*
* 参考  没有lock  1123456778
*        有lock   12345678910
*        synchronized   12345678910
* */
public class LockPrac {
    static int val  = 0;
//    static ReentrantLock lock = new ReentrantLock();
    static Runnable test = new Runnable() {
        @Override
        public void run() {
//            lock.lock();
            synchronized ((Object)val) {
                val++;
                System.out.print(val);
            }
//            lock.unlock();
        }
    };
     public static void main(String[] args){
//      test.run();
         ExecutorService service = Executors.newFixedThreadPool(10);
         for(int i = 0; i<10;i++){
             service.submit(test);
         }
         service.shutdown();
         }
}
