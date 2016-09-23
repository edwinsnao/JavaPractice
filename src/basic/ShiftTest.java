package basic;

import java.util.Scanner;

/**
 * Created by fazhao on 16/9/23.
 */
public class ShiftTest {
    static int count = 0;

    public static int shift(long n) {
        count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        for (long i = input + 1; i < 1000000000; i++) {
            if (shift(input) == shift(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
