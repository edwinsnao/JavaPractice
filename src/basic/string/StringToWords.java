package basic.string;

/**
 * Created by fazhao on 16/10/2.
 */
public class StringToWords {

    public static int strToInt(String str){
        int i = 0,num = 0;
        boolean isNeg = false;
        int len = str.length();
        char[] chars = str.toCharArray();
        if(chars[0] == '-') {
            isNeg = true;
            i = 1;
        }
        while (i < len){
            num *= 10;
            num += chars[i++] - '0';
        }
        if(isNeg)
            num *= -1;
        return num;
    }

    public static void main(String args[]){
        String input = "-1234567890";
        int result = strToInt(input);
        result++;
        System.out.println(result);
        System.out.println(""+strToInt(input));
        }
}
