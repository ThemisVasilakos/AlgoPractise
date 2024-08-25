package themis.algo.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to find the indices of two numbers in an array
 * that add up to a given target.
 *
 * Given an array of integers `nums` and an integer `target`, this method
 * returns the indices of the two numbers such that they add up to the target.
 *
 * <p>Assumptions:</p>
 * <ul>
 * <li>Each input will have exactly one solution.</li>
 * <li>You may not use the same element twice.</li>
 * <li>The answer can be returned in any order.</li>
 * </ul>
 *
 * <p>Examples:</p>
 * <pre>
 * Example 1:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 *
 * Example 3:
 * Input: nums = [3, 3], target = 6
 * Output: [0, 1]
 * </pre>
 *
 * <p>Constraints:</p>
 * <ul>
 * <li>2 <= nums.length <= 10^4</li>
 * <li>-10^9 <= nums[i] <= 10^9</li>
 * <li>-10^9 <= target <= 10^9</li>
 * <li>Only one valid answer exists.</li>
 * </ul>
 */

public class TwoSum {

    /**
     * @param nums array of integers
     * @param target integer target
     * @return indices of the two numbers such that they add up to target.
     * @Implementation Solution with O(N^2) time complexity
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
     * @Implementation Solution with O(N) time complexity
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
