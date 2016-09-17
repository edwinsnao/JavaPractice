package c11;

/**
 * Created by Kings on 2016/4/12.
 */
class Demo {
    public void Demo() {

    }

    public Demo() {

    }

    //    String Demo(){
//        return "hello";
//    }
    static int num;

    static {
        num = 10;
// num *=3;
        System.out.println("hahahah");
    }

    static void show() {
        System.out.println(num);
    }

    int x = 3;

    public static void main(String[] args) {
        /*
        * static code
show run
constructor code
name:baby
constructor code
name:旺财
constructor code
        * */
        Person p = null;
//        p.speak();
        Person.show();
        Person p1 = new Person();
        p1.speak();
        Person p2 = new Person("旺财");
        p2.speak();
        new Person();
        Demo d = new Demo();
        d.x = 9;
        show(d);
        /*
        * 虽然静态num的值是10，但是可以在这里改变
        * */
        num = 3;
        show();
        System.out.println(d.x);
        Fu test3 = new Fu();
        Fu test2 = new Fu(6);
        Fu test = new Zi(6);
        Zi test1 = new Zi(6);
//        Fu test = new Fu();
//        test.show();
//        test1.show();
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d1 = new D();
//        System.out.println(a1.show(b));
        System.out.println(a1.show());
        System.out.println(a2.show());
        System.out.println(a1.show(a1));
        System.out.println(a1.show(a2));
//        System.out.println(a1.show(c));
//        System.out.println(a1.show(d1));
//        System.out.println(a2.show(b));
        System.out.println(a2.show(a1));
        System.out.println(a2.show(a2));
//        System.out.println(a2.show(c));
//        System.out.println(a2.show(d1));
        System.out.println(b.show(a2));
        System.out.println(b.show(a2));
//        System.out.println(b.show(c));
        System.out.println(b.show(a1));
        System.out.println(b.show(a2));
//        System.out.println(b.show(d1));

    }

    public static void show(Demo d) {
        d.x = 4;
    }
    static class Fu
    {
        int num ;
        Fu()
        {
            num =10;
            System.out.println("A fu run");
            return;
        }
        Fu(int x)
        {
            System.out.println("B fu run..."+x);
        }
    }
    static class Zi extends Fu
    {
        int num;
        Zi()
        {
//super();//调用的就是父类中的空参数的构造函数。
            System.out.println("C zi run"+num);
        }
        Zi(int x)
        {
            this();
//super();
// super(x);
            System.out.println("D zi run "+x);
        }
    }
    static class A {
        int b= 1;
        int version = 0;
        A(){

        }
        A(int a){
            super();
            this.version =a;
        }
        A(int a,int b){
            this.b =b;
        }
        public String show(){
//            System.out.println("A");
            return "A";
        }
        public String show(D obj){
            return ("A and D");
        }
    public String show(A obj){
        return ("A and A");
    }
}
static class B extends A{
    int a = 1;

    B(){
//        this();
    }
    B(int a){
        super(a);
    }
    B(int a ,int b){
        super(a,b);
    }
    public String show(){
//        System.out.println("B");
        return "B";
    }
public String show(B obj){
        return ("B and B");
        }
public String show(A obj){
        return ("B and A");
        }
        }
static class C extends B{}
static class D extends B{}
}
