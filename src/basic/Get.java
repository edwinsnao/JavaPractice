package basic;

import java.util.Scanner;

/**
 * Created by fazhao on 16/10/1.
 */
public class Get {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = 0;
        int space = 0;
        int other = 0;
        int english = 0;
        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            char in = input[i];
            if(in>='0' && in<='9')
                num++;
            else if(in>='a'&&in<='z' || in>='A' && in<='Z')
                english++;
            else if(in == ' ')
                space++;
            else
                other++;
        }
        System.out.println("num:"+num);
        System.out.println("english:"+english);
        System.out.println("space:"+space);
        System.out.println("other:"+other);
        }
}
