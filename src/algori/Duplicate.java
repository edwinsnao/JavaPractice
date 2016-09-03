package algori;

/**
 * Created by fazhao on 16/9/3.
 */
public class Duplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
//                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public static void main(String args[]){
        Duplicate main = new Duplicate();
        int[] num = new int[]{1,1,1,1,2};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println(main.removeDuplicates(num));
        }
}
