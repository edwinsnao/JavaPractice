package c11;

/**
 * Created by Kings on 2016/4/12.
 */
class Person {
    private String name;

    {//构造代码块。可以给所有对象进行初始化的。
        System.out.println("constructor code ");
// cry();
    }

    static {
        System.out.println("static code");
    }

    Person()//是给对应的对象进行针对性的初始化。
    {
        name = "baby";
// cry();
    }

    Person(String name) {
        this.name = name;
// cry();
    }

    public void cry() {
        System.out.println("哇哇");
    }

    public void speak() {
        System.out.println("name:" + name);
    }

    static void show() {
        System.out.println("show run");
    }
}
