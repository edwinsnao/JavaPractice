package basic.string;

/**
 * Created by fazhao on 16/10/2.
 */
public class removeChars {
    public static String removeChars(String str,String remove){
        char[] s = str.toCharArray();
        char[] r = remove.toCharArray();
        boolean[] flags = new boolean[128];
        int len = s.length;
        int src,dst;

        for (int i = 0; i < r.length; i++) {
            flags[r[i]] = true;
        }

        src = 0;
        dst = 0;
        while(src < len){
            if(!flags[s[src]]){
                s[dst++] = s[src];
            }
            src++;
        }
        return new String(s,0,dst);
    }

    public static void main(String args[]){
        String s = "hello wolrd";
//        String r = "llo ";
        String r = "llo";
        System.out.println(removeChars(s,r));
        }
}
