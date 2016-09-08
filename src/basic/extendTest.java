package basic;

/**
 * Created by fazhao on 16/9/8.
 */
public class extendTest {
    public static void main(String args[]) throws Exception {
//        B b = new B(1);
//        B b = new B();

        /*A b = new B();
        try {
            b.print();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        B b = new B();
        b.print();
        new E();
//        throw new Exception("test");
    }
}
class A{
    /**
    * default: 没有加public或者protected，子类是不能继承这个成员变量值
     * 是书中的错误？default确实可以继承
    * */
    int x = 1;
    A(){
        super();
        /**
        * 构造器里new自己会overflow：构造器->新类->构造器->....
         * 为什么构造器不可以public protected等
        * */
//        new A();
        System.out.println("A"+x);
    }
    A(int x){
        System.out.println("A:"+x+","+this.x);
    }
     void print() throws ClassCastException{
        System.out.println("printA");
    }
}
/**
* 为什么class不可以定义private和protected
* */
//private class C{}
//protected class C{}

class B extends A{
    /**
    * 当定义了一个和父一样的变量，则this取自己的变量的值
    * */
    int x = 37;
    B(){
        /**
        * 如果A中没有super则报错误了，可是编译器不是默认会生成的？是因为我在A定义了一个构造器，所以不会给我默认生产？
         * 果然注释了A(int x)，编译器默认生成一个无参数A构造器就没报错了
        * */
        super();
        System.out.println("B"+this.x);
    }
    B(int x) {
        super(x);
        System.out.println("b:"+x+","+this.x);
    }
    /**
    * 可以不写Override
     * 同时static时不可以写Override，因为是隐藏了父类方法
     * 不同时static则编译错误
     * 不可以低于父类的权限，private会报错
     * 子类抛出的异常不可以范围比父类的大
    * */
//    public void print() throws Exception{
    public void print() throws ClassCastException{
        System.out.println("printB");
    }
}

class E{
    private static String msg(String msg){
        System.out.println(msg);
        return msg;
    }
    static String m = msg("1");
    {
        m = msg("2");
    }
    static {
        m = msg("3");
    }
}
