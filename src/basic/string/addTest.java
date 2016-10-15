package basic.string;

/**
 * Created by fazhao on 2016/10/13.
 */
public class addTest {
    /**
    * 数字开头不行
    * */
//    static int 1 = 1;
//    static int 1a = 1;

    static int static1 = 2;

    addTest(){
        static1 = 0;
    }

    public static void main(String args[]){
        addTest test1 = new addTest();
        /**
        * 原来是没错的，我以为是非法向前引用；
        * */
        System.out.println(test1.static1);
        byte a = 1;
        byte b = 123;
        System.out.println(String.valueOf(a+=b));
        a = (byte) (a+b);
        a+=b;
        /**
        * 右移是除以，是以/来算的
         * 我中了陷阱，我以为是乘以
        * */
        int test = 89;
        int result = test >>> 1;
        int result1 = test >> 1;
        /**
        * 余1.2000000000000028
         * 是double类型
        * */
        System.out.println((double)49.2%2);
        System.out.println(result);
        System.out.println(result1);
        long d = a;
        System.out.println(d);
        System.out.println((long)a);
        System.out.println(a);
        System.out.println(String.valueOf(a+=b));
    }
}
