package c11;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ConcurrentHashMapUsage {
//    public void useIterator() {
//static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer,Integer>(50, 0.75f, 2);
static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer,Integer>();

   static ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>();
    static int count1 = 0;
//static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(50, 0.75, 2,1);

//    }
    private static class ReadThread extends Thread {
//        private final ConcurrentHashMap<Integer, Integer> map;
//        public ReadThread(ConcurrentHashMap<Integer, Integer> map) {
//            this.map = map;
//        }



        public void run() {
            synchronized ((Object) count1) {
                count1++;
            }
            System.out.print("Thread1 ");
            Iterator<String> iterator = map1.keySet().iterator();
            int count = 0;
            synchronized ((Object) count) {
                while (iterator.hasNext()) {
                    count++;
                    Object key = iterator.next();
                    Object value = map1.get(key);
                    System.out.println("key" + key + " value" + value);
                }
                System.out.print("count==" + count);
            }
        }
    }

    private static class ReadThread1 extends Thread{

        @Override
        public void run() {
            synchronized ((Object) count1) {
                count1++;
            }
            System.out.print("Thread2 ");
            super.run();
            int count = 0;
//            Iterator<Integer> iterator = map.keySet().iterator();
//            while(iterator.hasNext()){
//                count++;
//                Object key = iterator.next();
//                Object value = map.get(key);
//                System.out.println("key"+key+" value"+value);
//            }
//            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println("key"+key+" value"+value);
//                count++;
//            }
//            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
//            while(iterator.hasNext()){
//                Map.Entry<Integer,Integer> entry = iterator.next();
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println("key"+key+" value"+value);
//                count++;
//            }
//            for(Integer key:map.keySet()){
//                count++;
//                System.out.println("value=="+map.get(key));
//            }
//            Iterator<Integer> iterator = map.entrySet().iterator();

/*
*           四种遍历方法的实践
* */
//            Iterator<Integer> iterator = map.keySet().iterator();
//            while(iterator.hasNext()){
//                count++;
//                Object key = iterator.next();
//                Object value = map.get(key);
//                System.out.println("key"+key+" value"+value);
//            }
//            Iterator<Map.Entry<Integer,Integer>> iterator1 = map.entrySet().iterator();
//            while(iterator1.hasNext()){
//                count++;
//                Map.Entry<Integer,Integer> entry = iterator1.next();
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println("key"+key+" value"+value);
//            }
//            for(Integer key : map.keySet()){
//                count++;
//                System.out.print("value=="+map.get(key));
//            }
            synchronized ((Object) count) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println("key" + key + " value" + value);
                }
                System.out.print("count==" + count);
            }
        }
    }

     public static void main(String[] args){
//        ConcurrentHashMapUsage usage = new ConcurrentHashMapUsage();
//         usage.useIterator();
         map.put(1,1);
         map.put(2,2);
         map1.put("1","1");
         map1.put("2","2");
         ReadThread1 thread1 = new ReadThread1();
//         thread.start();
         ExecutorService pool = Executors.newFixedThreadPool(4);
         for(int i = 0 ; i<10;i++) {
             map.put(i,i);
             pool.submit(thread1);
         }
         System.out.print(" ---------------");
         ReadThread thread = new ReadThread();
         thread.start();
         pool.shutdown();
         System.out.print("count1== "+count1);
         }
}
