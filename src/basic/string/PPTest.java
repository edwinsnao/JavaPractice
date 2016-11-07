package basic.string;

import java.util.Scanner;

/**
 * Created by fazhao on 2016/11/6.
 */
public class PPTest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] r = input.split(";");
        int[] age = new int[r.length];
        for (int i = 0; i < r.length; i++) {
//            System.out.println(r[i]);
            String[] tmp = r[i].split(":");
            age[i] = Integer.parseInt(tmp[1]);
            System.out.println(age[i]);
        }
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]+" ");
        }
        int[] times = new int[age.length];
        for (int i = 0; i <times.length ; i++) {
            times[i] = 1;
        }
        for (int i = 0; i < age.length; i++) {
            for (int j = i+1; j < age.length; j++) {
                if(age[i]>age[j]){
                    int tmp = age[i];
                    age[i] = age[j];
                    age[j] = tmp;
                }
            }

        }
        for (int i = 0; i < age.length - 1; i++) {
            for (int j = i + 1; j < age.length; j++) {
                if(age[j] == age[i]){
                    for (int k = i; k < age.length -1; k++) {
                        age[k] = age[k+1];
                        age[age.length - 1] = 9999;
                        times[i] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < age.length; i++) {
            if(age[i] == 9999)
                continue;
            System.out.println(age[i]+":"+times[i]);
        }
    }
}
