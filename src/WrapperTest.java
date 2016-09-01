import java.util.ArrayList;
import java.util.List;

/**
 * Created by fazhao on 16/9/1.
 */
public class WrapperTest {
    public static void main(String args[]){
        Integer i = 1;
        Integer i1 = 2;
        i +=i1;

        /**
        * wrong:因为s1+s2结果是int
         * s1+=s2 相当于s1 = (Short) (s1+s2)
         * 因为结果正确是Integer，所以不能转为Short而报错
        * */
        Short s1 = 1;
        Short s2 = 2;
//        s1 += s2;
        System.out.println(s1+s2);

        List list = new ArrayList();
        /**
        * 1.4
        * */
        list.add(new Integer(10));

        Integer integer = (Integer) list.get(0);
        /**
         result:class java.lang.Integer
         所以是还没有拆箱的
        */
        System.out.println(integer.getClass());
        /**
        * 1.4
        * */
        System.out.println(integer.intValue());

        /**
        * 1.5
        * */
        list.add(100);
        System.out.println(list.get(1));
        /**
        * Exception in thread "main" java.lang.NullPointerException
        * */
//        Integer i = null;
//        int i1 = i;

    }
}
