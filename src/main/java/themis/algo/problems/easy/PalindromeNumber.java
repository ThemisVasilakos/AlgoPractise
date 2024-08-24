package themis.algo.problems.easy;

/**
 * Determines if the given integer is a palindrome. A palindrome is a number that
 * reads the same backward as forward.
 *
 * <p>For example:
 * <ul>
 *   <li>Input: x = 121, Output: true (Explanation: 121 reads as 121 from left to right and from right to left)</li>
 *   <li>Input: x = -121, Output: false (Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome)</li>
 *   <li>Input: x = 10, Output: false (Explanation: Reads 01 from right to left. Therefore it is not a palindrome)</li>
 * </ul>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code -2^31 <= x <= 2^31 - 1}</li>
 * </ul>
 *
 * <p>Follow-up: Could you solve this problem without converting the integer to a string?
 */
public class PalindromeNumber {

    /**
     * @param x the integer to check for being a palindrome
     * @return {@code true} if the given integer is a palindrome, otherwise {@code false}
     * Solution with O(N) time complexity by converting to the integer to String
     */
    public static boolean isPalindrome(int x) {

        String numberStr = String.valueOf(x);
        for (int i = 0; i < numberStr.length(); i++) {
            if(numberStr.charAt(i)!=numberStr.charAt(numberStr.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * @param x the integer to check for being a palindrome
     * @return {@code true} if the given integer is a palindrome, otherwise {@code false}
     * Solution with O(N) time complexity without conversion to String
     */
    public static boolean isPalindromeNoStr(int x) {

        if(x<0){
            return false;
        }

        int reversedX=0;
        int tmp=x;

        while (tmp!=0) {
            int digit = (int) (tmp%10);
            reversedX = reversedX * 10 + digit;
            tmp /= 10;
        }

        return (reversedX==x);
    }

}
