package algori.exception;

import java.util.Scanner;

/**
 * Created by fazhao on 2016/10/26.
 */
public class YouDaoTest {
    public static void main(String args[]) {
        int sum = 10;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 1)
            System.out.println("10");
        else {
            int[] a = new int[number];
            double nums = Math.pow(10, number);
            for (int i = 10; i < nums; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[j] = -1;
                }
                boolean isSame = true;
                int tmp = 0;
                int cur = i;
                a[tmp++] = cur % 10;
                while (cur / 10 != 0) {
                    cur = cur / 10;
                    a[tmp++] = cur % 10;
                }
//                if(i == 998)
//                    for (int j = 0; j < a.length; j++) {
//                        System.out.println(""+a[j]);
//                    }
                for (int j = 0; j < a.length - 1; j++) {
                    if (a[j] != a[j + 1])
                        isSame = false;
                }
                if (!isSame)
                    sum++;
                else
                    System.out.println(""+i);
            }
            System.out.println("" + sum);
//            sum = (int) (Math.pow(10,number) - (number - 1) * 9);
//            System.out.println(""+sum);
        }
    }
}
