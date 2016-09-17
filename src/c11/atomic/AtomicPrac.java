package c11.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kings on 2016/4/12.
 */
public class AtomicPrac {
   AtomicInteger integer = new AtomicInteger(0);
    public int getNext(){
        return integer.getAndIncrement();
    }
//    public int Accu(){
//        return integer.getAndAccumulate(3);
//    }
     public static void main(String[] args){
         AtomicPrac prac = new AtomicPrac();
         System.out.println(prac.getNext());
         System.out.println(prac.getNext());
         System.out.println(prac.getNext());
         System.out.println(prac.getNext());
         }
}
