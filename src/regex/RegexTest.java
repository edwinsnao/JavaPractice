package regex;

/**
 * Created by fazhao on 2016/10/24.
 */
public class RegexTest {
    public static void main(String args[]){
        String test = "ABC";
        String test1 = "A";
        String test2 = "B";
        String test3 = "C";
        String test4 = "AB";
        String test5 = "ABCA";
        String test6 = "ABCABCABC";
        /**
        * []是匹配任意一个字符
         * 1、[0-3]，表示找到这一个位置上的字符只能是0到3这四个数字，与(abc|bcd|cde)的作用比较类似，但圆括号可以匹配多个连续的字符，而一对方括号只能匹配单个字符
         * ()是必须是String里面的字符
        * */
        System.out.println(test1.matches("[ABC]"));
        System.out.println(test1.matches("(ABC)"));
        System.out.println(test2.matches("[ABC]"));
        System.out.println(test2.matches("(ABC)"));
        System.out.println(test3.matches("[ABC]"));
        System.out.println(test3.matches("(ABC)"));
        System.out.println(test4.matches("[ABC]"));
        System.out.println(test4.matches("(ABC)"));
        System.out.println(test.matches("(ABC)"));
        System.out.println(test5.matches("(ABC)"));
        System.out.println(test6.matches("(ABC)"));
    }
}
