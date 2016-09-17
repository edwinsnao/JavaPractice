package c3;

/**
 * Created by Kings on 2016/4/25.
 */
public class InterfaceTest {
    interface Interface0{
        int A = 0;

        }
    interface Interface1 extends c3.InterfaceTest.Interface0{
        int A = 1;
    }
    interface Interface2{
        int A = 2;
    }
    static class Parent implements Interface1{
        public static int A = 3;
    }
    static class Sub extends  Parent implements Interface2{
        public static int A = 4;
    }
     public static void main(String[] args){
             System.out.println(Sub.A);
             System.out.println(Parent.A);
             System.out.println(Interface0.A);
             System.out.println(Interface1.A);
         }
}
