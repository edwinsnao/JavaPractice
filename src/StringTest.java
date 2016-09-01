import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fazhao on 16/9/1.
 */
public class StringTest {
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
    }
}
