package themis.algo.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Determines if any value appears at least twice in the given integer array `nums`.
 * Returns {@code true} if any value appears at least twice in the array, and {@code false} if every element is distinct.
 *
 * <p>For example:
 * <ul>
 *   <li>Example 1: Input: nums = [1, 2, 3, 1], Output: true
 *   (Explanation: The value 1 appears twice.)</li>
 *   <li>Example 2: Input: nums = [1, 2, 3, 4], Output: false
 *   (Explanation: All elements are distinct.)</li>
 *   <li>Example 3: Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2], Output: true
 *   (Explanation: Multiple values appear more than once.)</li>
 * </ul>
 *
 * <p>Constraints:
 * <ul>
 *   <li>1 <= nums.length <= 10<sup>5</sup></li>
 *   <li>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></li>
 * </ul>
 */
public class ContainsDuplicate {

    /**
     * @param nums the integer array to check for duplicate values
     * @return {@code true} if any value appears at least twice in the array, otherwise {@code false}
     * <p>Submitted Solution with O(N) time complexity</p>
     */
    public static boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> myMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (myMap.containsKey(nums[i])){
                return true;
            }
            myMap.put(nums[i],i);
        }

        return false;
    }

}
