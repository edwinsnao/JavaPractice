import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fazhao on 16/9/1.
 */
public class StringTest {
    public StringTest(){
        super();
    }

    public static void main(String args[]) {
        /**
         * I come from China.这句话在这里并不是作为一个字符串，所以args[0]是读取其中的第几个词
         * */
//        String input = args[0];

        Scanner scanner = new Scanner(System.in);
        /**
         * 一个词
         * */
//        String input = scanner.next();
        String input = scanner.nextLine();
//        Pattern p = Pattern.compile(" ");
//        Matcher matcher = p.matcher(input);
//        Pattern pattern = Pattern.compile(" ");
//        String[] tmp = pattern.split(input);
//        String[] tmp = input.split("\\s{1,}");
        String[] tmp = input.split(" ");
//        for (int i = 0; i < tmp.length; i++) {
//
//        }
        System.out.println(tmp.length);
        for (int i = tmp.length - 1; i >= 0; i--) {
            System.out.print(tmp[i] + " ");
        }
//        Arrays.sort(tmp);
//        for (String s:tmp){
//            System.out.print(s + " ");
//        }
        System.out.println(new StringBuffer(input).reverse().toString());

        String[] s = {"a","b","c"};
        String[][] s1 = {{"a,b","bc"}
        ,{"abc","efg"}};
        String[][][] s2={{{"abc","bcd"}},{{"efg","hig"}}};
        for (String t:s)
            System.out.println(t);
        for (String[] t:s1) {
            for(String t1 : t)
            System.out.println(t1);
        }
        for (String[][] t:s2) {
            for (String[] t1:t){
                for (String t2:t1)
                    System.out.println(t2);
            }
        }
    }
}
