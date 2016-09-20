package basic;

/**
 * Created by fazhao on 16/9/20.
 */
public class ChangTest {
    static String str1 = new String("abc");
    static String str = new String("abc");
    public static void main(String[] args) {

        String str2 = "abc";

        char[] ch = {'a', 'b', 'c'};

        change(str, ch);

        System.out.print(str + " ");

        System.out.print(ch);

        System.out.println(str1);
        System.out.println(str2);

    }
        public static void change (String str,char[] ch){
//            str1 = "gbc";
            str = "gbc";
//            str1 = "hello";
//            System.out.println(str1);
            System.out.println(str);
            ch[0] = 'g';
        }
}
