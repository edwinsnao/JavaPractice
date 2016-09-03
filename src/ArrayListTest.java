import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fazhao on 16/8/28.
 */
public class ArrayListTest {
//    private  ArrayList list;

    public static void StringList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        list.forEach(System.out::println);
//        for (String s : list){
//            System.out.println(s);
//        }
    }

    public void list(){
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int tmp = 0;
        list.forEach(System.out::println);
//        for (tmp : list){
//            System.out.println(""+tmp);
//        }
    }
    
    public static void main(String args[]){
//        List<Integer> list  = new ArrayList<>();
        List list  = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        int tmp = 0;
        /**
        * 没有任何类型的时候要用Object，否则是不通过的，不是int tmp
        * */
        for (Object tmp:list) {
            System.out.println(tmp);
        }
        Object[] a = list.toArray();
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        for (String s : list)
//            System.out.println(s);
        StringList();
    }
}
