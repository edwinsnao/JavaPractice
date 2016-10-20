package basic.string;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by fazhao on 2016/10/13.
 */
public  class addTest {
    /**
    * 数字开头不行
    * */
//    static int 1 = 1;
//    static int 1a = 1;

    static int static1 = 2;

//    public abstract void test();

    addTest(){
        static1 = 0;
    }

    public static void main(String args[]){
        int casetest = 1;
        switch (casetest){
            /**
            * case后面不可以是null
            * */
//            case null:
//                break;
        }
        HashMap map = new HashMap();
        /**
        * hashmap的key和值都可以null
        * */
        map.put(null,null);
        Hashtable map1 = new Hashtable();
        map1.put(1,1);
        /**
        * hashtable不允许nullkey和null值
         * java.lang.NullPointerException
        * */
//        map1.put(null,null);
        addTest test1 = new addTest();
        StringBuilder sb = new StringBuilder(",test`");
        /**
        * 下面的是错误的
        * */
//        StringBuilder sb = new StringBuilder(,test`);
        /**
        * 6
        * */
        System.out.println(sb.length());

        /**
        * 下面的语句是错误的
        * */
//        System.out.println(,);
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

        /**
        * 奇偶数判断的方法
         * i & 0x1 == 1 则为奇数，否则偶数
        * */
        for (int i = 0; i < 10; i++) {
            System.out.println(i+":"+String.valueOf(i & 0x1));
        }
    }
}
