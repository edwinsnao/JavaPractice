package network.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fazhao on 16/9/8.
 */
public class IteratorTest {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        /**
        * wrong
         * 一开始需要先it.next()来获取第一个元素，因为it一开始在头结点的位置？
         * 需要it.next向后移动一位才可以获取到第一个元素
         * 并且以后每次remove之后都需要it.next配合使用，不可以连续remove
        * */
//        Iterator<Integer> it = list.iterator();
//        it.remove();
//        it.remove();
//        System.out.println(it.next());
        /**
        * 同样是错的
        * */
//        Iterator<Integer> it = list.iterator();
//        it.next();
//        it.next();
//        it.remove();
//        it.remove();
        /**
        * 正确
        * */
        Iterator<Integer> it = list.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();
        System.out.println(it);
        System.out.println(it.next());
    }
}
