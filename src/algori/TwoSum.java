package algori;

import com.sun.tools.internal.ws.processor.model.java.JavaException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by fazhao on 16/9/3.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
            for (int i = 0; i < nums.length; i++) {
                int result = target - nums[i];
                if(map.containsKey(result) && map.get(result)!=i)
                    return new int[]{i,map.get(result)};
            }
        throw new IllegalArgumentException("No solution!");
    }
//    public static int[] twoSum(int[] nums,int target){
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[i]+nums[j] == target)
//                    return new int[]{i,j};
//            }
//        }
//        throw new IllegalArgumentException("No solution!");
//    }

    public static void main(String args[]){
        int[] nums = {2,7,11,15};
        int target = 9;

//        int[] tmp = new int[]{1,2};
//        System.out.println(Arrays.toString(tmp));
        /**
        * Arrays.toString()否则输出的是数组的地址，而for输出的是元素值
        * */
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

}
