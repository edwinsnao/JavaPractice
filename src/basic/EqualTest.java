package basic;

/**
 * Created by fazhao on 16/9/19.
 */
public class EqualTest {
    public static void main(String args[]) {
        int a = 1;
        int b = 1;
        Integer a1 = 1024;
        Integer b1 = 1024;
//        String s = "1";
//        String s2 = "2";
        final String s = "1";
        final String s2 = "2";
        String s3 = "12";
        String s4 = "1"+"2";
        Integer a2 = 1;
        Integer b2 = 1;
        System.out.println(a == b);
        System.out.println(a1 == b1);
        System.out.println(a2 == b2);
        System.out.println("String");
        System.out.println(s+s2 == s3);
        System.out.println((s+s2).equals(s3));
        System.out.println(s+s2 == s4);
        System.out.println((s+s2).equals(s4));
        System.out.println(s3.equals(s4));
        System.out.println(s3==s4);
    }
}
