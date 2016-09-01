/**
 * Created by fazhao on 16/9/1.
 */
public class OverrideTest {
    public static void m(String s){
        System.out.println("String");
    }

    public static void m(Object o){
        System.out.println("Object");
    }
//    public void m(String s){
//        System.out.println("String");
//    }
//
//    public void m(Object o){
//        System.out.println("Object");
//    }

    public static void main(String args[]){
        Object o = new String();
//        OverrideTest test = new OverrideTest();
        /**
        * result Object
        * */
//        test.m(o);
        /**
        * 同上
        * */
        m(o);
        }

}
