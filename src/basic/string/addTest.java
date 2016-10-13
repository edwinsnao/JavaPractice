package basic.string;

/**
 * Created by fazhao on 2016/10/13.
 */
public class addTest {
    public static void main(String args[]){
        byte a = 1;
        byte b = 123;
        System.out.println(String.valueOf(a+=b));
        a = (byte) (a+b);
        a+=b;
        long d = a;
        System.out.println(d);
        System.out.println((long)a);
        System.out.println(a);
        System.out.println(String.valueOf(a+=b));
    }
}
