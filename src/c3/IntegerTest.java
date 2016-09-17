package c3;

/**
 * Created by Kings on 2016/4/21.
 */
public class IntegerTest {
    static int test;
    public static void main(String[] args) {
//        String str4 = "java";     不加这个str1也返回false
//        String tmp = "IntegerTest";
//        String str5 = "private";  加了这个后private的str2也返回false;
        String str = new StringBuilder("计算机软件").append("Test").toString();
//        String str1 = new StringBuilder("ja").append("va").toString();
        String str1 = new StringBuilder("java").toString();       //返回false，因为在StringBuilder创建java这个字符串之前已经有了，"java"已经有他的引用了
        String str4 = new StringBuilder("ja").append("va1").toString();
//        String str4 = new StringBuilder("1").append("1").toString();
//        String str5 = new StringBuilder("Integer").append("Test").toString();
        String str5 = new StringBuilder("IntegerT").append("est").toString();
        String str2 = new StringBuilder("pri").append("vate").toString();
        String str3 = new StringBuilder("te").append("st").toString();
        Double d1 = 1.2;
        Double d2 = 1.2;
        System.out.println(str.intern()==str);
        System.out.println(d1==d2);
        System.out.println(str1.intern()==str1);
        System.out.println(str4.intern()==str4);
        System.out.println(str5.intern()==str5);
        System.out.println(str2.intern()==str2);
        System.out.println(str3.intern()==str3);
        System.out.println(test);
        System.out.println(Integer.parseInt("1"));
        System.out.println(Integer.parseInt("2"));
        System.out.println(MySizeOf.sizeOf(new Integer(1)));
        System.out.println(MySizeOf.sizeOf(new String("a")));
        System.out.println(MySizeOf.sizeOf(new char[1]));


    }

}

