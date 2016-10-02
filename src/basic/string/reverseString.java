package basic.string;

/**
 * Created by fazhao on 16/10/2.
 */
public class reverseString {
    public static String  reverseString(String str){
        String[] chars = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >=0; i--) {
            System.out.print(chars[i]+" ");
            sb.append(chars[i]+" ");
        }
        System.out.println("");
        return sb.toString();
    }
    public static void main(String args[]){
        String input = "Do or do not, there is no try.";
        System.out.println(reverseString(input));
        }
}
