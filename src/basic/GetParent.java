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
            /**
            * 正常手段不行
            * 除了修改B，还可以使用反射
            * */
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
