package themis.algo.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 */
public class TwoSum {

    /**
     * @param nums array of integers
     * @param target integer target
     * @return indices of the two numbers such that they add up to target.
     * Solution with O(N^2) time complexity
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }

        return  new int[]{};
    }

    /**
     * @param nums array of integers
     * @param target integer target
     * @return indices of the two numbers such that they add up to target.
     * Solution with O(N) time complexity
     */
    public static int[] twoSumFaster(int[] nums, int target) {
        Map<Integer,Integer> myHash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
                int complement = target-nums[i];
                if(myHash.containsKey(complement) &&  myHash.get(complement)!=i){
                    return new int[]{myHash.get(complement),i};
                }
            myHash.put(nums[i],i);
        }

        return  new int[]{};
    }

}
