package basic;

/**
 * Created by fazhao on 16/9/22.
 */
public class extendTest1 {
    public static void main(String args[]){
        /**
        * 执行过程
         * 先B(),再A(),执行A的add，回到B的add，得到2，再执行B的构造函数，调用add（2），得到6
         * 所以6+6*2=18
        * */
    A1 a = new B1();
        a.add(6);
        a.print();
        }
}

class A1{
    int i = 0;
    public A1(){
        add(1);
    }
    public void add(int n){
        i+=n;
    }

    public void print(){
        System.out.println(i);
    }

}
class B1 extends A1{
    public B1(){
        add(2);
    }
    public void add(int n){
        i+=n*2;
    }
}
