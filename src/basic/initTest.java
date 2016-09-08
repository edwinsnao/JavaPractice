package basic;

/**
 * Created by fazhao on 16/9/6.
 */
public class initTest {
    public static int x;
    public void testDemo(){
        int i ,j = 0 ,n = 0;
        i = 100;
        while(i>0){
            /**
            * 如果不初始化j则报错
            * */
            j = j+1;
            j = i*2;
            n = n +1;
            i--;
        }
    }

    /**
    * 结果是0，陷阱！
     * 因为x是形参，这里的x++是对形参进行加的，而不是全局的x
     * 稍微修改一下就是1
    * */
    public static void name(int x ){
        x++;
        System.out.println("x:"+x);
    }
    /**
    * 第一种
    * */
    public static void name1(int x ){
        /**
        * this can't be referenced from a static context
        * */
//        this.x++;
        initTest.x++;
    }
    /**
    * 第二种
    * */
    public static void name2(int y ){
        x++;
    }

    public static void main(String args[]){
//        name(x);
//        name1(x);
        initTest main = new initTest();
        name2(x);
        System.out.println(x);
        System.out.println(main.x);
    }
}
class Parent{
    protected String name;
    /**
    * 不能获得private的权限
    * */
//    String name;
    public Parent(){

    }
}
class Child extends Parent{
    public String getValue(){
        return name;
    }
    public static void main(String args[]){
        Parent p = new Parent();
        }
}

/**
*wrong class can't be defined private
*/
//private class B{}

