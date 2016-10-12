package basic;

/**
 * Created by fazhao on 2016/10/12.
 */
public class GetParent {
    static class A{
        protected String getString(){
            return "A";
        }
    }
    static class B extends A{
        protected String getString(){
//            return "B";
            return super.getString();
        }
    }
    static class C extends B{
        protected String getString(){
            return super.getString();
        }
    }
    public static void main(String args[]){
        C c = new C();
        System.out.println(c.getClass().getSuperclass().getSuperclass().getSigners());
        System.out.println(c.getString());
        }
}
