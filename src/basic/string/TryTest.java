package basic.string;

/**
 * Created by fazhao on 2016/11/1.
 */
public class TryTest {
    public static void main(String args[]){
        String s = null;
        String[] s1 = null;
        try {
            /**
            * 需要加上包名
            * */
            Class class1 = Class.forName("basic.string.TryTest");
            /**
            * cannot be cast to java.lang.Class
            * */
//            Class class2 = (class) class1.newInstance();
            TryTest class2 = TryTest.class.newInstance();
            System.out.println(""+class1.getName());
            /**
            * wrong
            * */
//            System.out.println(""+class2.main(s1));
            System.out.println(""+class2);
            /**
            * 这样写也是可以的
             * 而且最好写成"Java".equals(s);
             * 这样就不需要写成
             * if(s != null)
             * s.equals("Java");
             * 提高效率
            * */

            /**
            * 编译通过，运行错误，NullPointerException
             * equals里面不可以放null
            * */
            System.out.println(""+s.equals(null));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
        * 可以不catch，直接finally
        * */
        try{
            System.out.println("1");
        }finally {
            System.out.println("haha");
        }
        }
}
