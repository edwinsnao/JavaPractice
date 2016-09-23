package basic;

import java.util.Scanner;

/**
 * Created by fazhao on 16/9/23.
 */
public class ShuWeiHe {

    public static int sheweihe(String s){
        int sum=0;
        for(int i =0;i<s.length();i++)
            sum+=Integer.parseInt(s.substring(i,i+1));
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input1 = scanner.nextLong();
        long input2 = scanner.nextLong();
        long target = scanner.nextLong();
        long min = 0;
        for (long i = input1; i <= input2 ; i++) {
            if(i == input1)
                min = Math.abs(sheweihe(String.valueOf(i)) - target);
            else
                if(Math.abs(sheweihe(String.valueOf(i)) - target) < min)
                    min = Math.abs(sheweihe(String.valueOf(i)) - target);
        }
        System.out.println(min);
    }
}
