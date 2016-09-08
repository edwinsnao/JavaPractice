package network.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by fazhao on 16/9/8.
 */
public class ListIteratorTest {
    /**
    * 逆序输出ArrayList
     * main方法可以加synchronized
    * */
    public static synchronized void main(String args[]){
//        int []a[] = new int[4][0];
//        int a[][] = new int[4][];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 10; j++) {
//                [i]a[j] = j;
//            }
//        }
        /**
        * wrong:相当于构造器里面调用构造器会stackoverflow
        * */
//        ListIteratorTest main = new ListIteratorTest();
//        main.main(null);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("全部元素"+list);
        Object[] tmp = list.toArray();
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i]+" ,");
        }
        System.out.println("");
        ListIterator<Integer> iterator = list.listIterator();
        for (; iterator.hasNext() ; iterator.next()) {

        }
//        for (iterator = list.listIterator(); iterator.hasNext() ; iterator.next()) {
//
//        }
        while(iterator.hasPrevious())
            System.out.println(iterator.previous());
    }
}
