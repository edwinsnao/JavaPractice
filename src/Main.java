import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i = 0 ; i < number;i++){
            int sum = sc.nextInt();
            int[] staff = new int[sum];
            for(int j = 0; j < sum;j++){
                staff[j] = sc.nextInt();
            }
            int[] present = new int[sum - 1];
            for(int z = 0; z < sum - 1;z++){
                present[z] = sc.nextInt();
            }
            for(int h = 0 ; h < sum - 1;h++){
                for(int g = 0; g < sum;g++)
                if(present[h] == staff[g])
                    staff[g] = 0;
            }
            for (int j = 0; j < staff.length; j++) {
                if(staff[j] != 0)
                    System.out.println(staff[j]);
            }
        }
    }

}