package c11;

import java.util.concurrent.*;

/**
 * Created by Kings on 2016/4/12.
 */
public class FutureTaskPrac {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    public void useFutureTask(){
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hello future";
            }
        });
        task.run();
        try {
            System.out.print(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public String useFuture() throws ExecutionException, InterruptedException {

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "helloworld";
            }
        });
        return future.get();
    }

    public void close(){
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(3,TimeUnit.MINUTES)){
                executorService.shutdown();
                executorService.awaitTermination(1,TimeUnit.MINUTES);
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    static Runnable test = new Runnable() {
        @Override
        public void run() {
            FutureTaskPrac prac = new FutureTaskPrac();
            prac.useFutureTask();
            try {
                System.out.println(prac.useFuture());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

     public static void main(String[] args) throws ExecutionException, InterruptedException {
          FutureTaskPrac prac = new FutureTaskPrac();
//          ExecutorService pool = Executors.newFixedThreadPool(10);
//         pool.submit(test);
         prac.useFutureTask();
         prac.useFuture();
         System.out.print("----------- ");
         System.out.println(prac.useFuture());
         prac.close();
         }
}
