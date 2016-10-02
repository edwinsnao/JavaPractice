package basic;

import java.util.Hashtable;

/**
 * Created by fazhao on 16/10/2.
 */
public class FirstNonRepeated {
    public static Character firstNotRepeated(String str){
        Hashtable charHash = new Hashtable();
        int i,length;
        Character c;
        Object seenOnce = new Object();
        Object seenTwice = new Object();
        length = str.length();

        for (int j = 0; j < length; j++) {
            c = new Character(str.charAt(j));
            Object o = charHash.get(c);
            if(o == null){
                charHash.put(c,seenOnce);
            }else if(o == seenOnce){
                charHash.put(c,seenTwice);
            }
        }
        for (int j = 0; j < length; j++) {
            c = new Character(str.charAt(j));
            if(charHash.get(c) == seenOnce)
                return c;
        }
        return null;
    }


    public static void main(String args[]){
        String input = "aabbcceff";
        System.out.println(firstNotRepeated(input));
        }
}
