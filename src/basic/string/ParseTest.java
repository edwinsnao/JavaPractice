package basic.string;

/**
 * Created by fazhao on 2016/10/9.
 */
public class ParseTest {
    public static void main(String args[]){
        String s = String.valueOf("123");
        String s1 = String.valueOf(true);
        int i = Integer.parseInt("1");
        int i1 = Integer.valueOf("12");
        String i2 = Integer.valueOf("12").toString();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        }
}
