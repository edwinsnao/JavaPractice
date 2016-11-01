package basic.string;

/**
 * Created by fazhao on 2016/11/1.
 */
public class TryTest {
    /**
    * 如果只定义了有参构造函数，没有定义无参，编译器不会自动加上
     * 这时Class.newInstance只找无参数构造函数
     * 因为找不到，所以报错
     * iationException: basic.string.TryTest
     *
     * 此外
     * 下面B继承
     * 如果只定义了有参构造函数，没有定义无参，编译器不会自动加上
     * 这时super()只找无参数构造函数，但找不到，所以编译阶段就报错
     * 所以需要supe(null)才可以通过
    * */
//    TryTest(){
//
//    }
    TryTest(String s){
        System.out.println(s);
    }

    public static void main(String args[]){
        String s = "hello";
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
//            Object class3 = class1.newInstance();
//            Object class4 = class1.newInstance();
            /**
            * newInstance不可以有参数
            * */
//            Object class4 = class1.newInstance("hello");
//            TryTest class6 = (TryTest) class1.newInstance();
//            TryTest class2 = TryTest.class.newInstance();
//            TryTest class5 = TryTest.class.newInstance();
            System.out.println(""+class1.getName());
            /**
            * wrong
            * */
//            System.out.println(""+class2.main(s1));
            /**
            * 应该不是单例了
             * basic.string.TryTest
             basic.string.TryTest@511d50c0
             basic.string.TryTest@60e53b93
             basic.string.TryTest@5e2de80c
             basic.string.TryTest@1d44bcfa
            * */
//            System.out.println(""+class2);
//            System.out.println(""+class3);
//            System.out.println(""+class4);
//            System.out.println(""+class5);
//            System.out.println(""+class6);
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
             * s为null时不可以和其他进行比较
            * */
            System.out.println(""+s.equals(null));
//            System.out.println(""+s.equals("hello"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
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

        class B extends TryTest{
            B(String s){
//                super();
                super(null);
            }
        }
}
class B extends TryTest{
    B(String s){
        super(null);
//        super();
    }
}