package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * leeCode link: https://leetcode-cn.com/problems/two-sum/
 */

public class twoSum {

    //解法一：暴力解法，直接两遍循环查询，效率较低
    //解法二：hash碰撞法
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                //值作为key，数组下标作为值
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9)[0]);
    }
}
