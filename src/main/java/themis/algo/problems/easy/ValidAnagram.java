package themis.algo.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Determines if string `t` is an anagram of string `s`.
 * An Anagram is a word or phrase formed by rearranging the letters of another word or phrase,
 * typically using all the original letters exactly once.
 *
 * <p>For example:
 * <ul>
 *   <li>Example 1: Input: s = "anagram", t = "nagaram", Output: true
 *   (Explanation: "nagaram" is an anagram of "anagram".)</li>
 *   <li>Example 2: Input: s = "rat", t = "car", Output: false
 *   (Explanation: "car" is not an anagram of "rat".)</li>
 * </ul>
 *
 * <p>Constraints:
 * <ul>
 *   <li>1 <= s.length, t.length <= 5 * 10<sup>4</sup></li>
 *   <li>`s` and `t` consist of lowercase English letters.</li>
 * </ul>
 *
 * <p>Follow-up: How would you adapt your solution if the inputs contain Unicode characters?
 */
public class ValidAnagram {

    /**
     * @param s the original string to be compared
     * @param t the string to check if it is an anagram of `s`
     * @return {@code true} if `t` is an anagram of `s`, otherwise {@code false}
     * @Implementation with O(N^2) time complexity and not care about unicode
     */
    public static boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> myMap= new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            myMap.put(s.charAt(i),(myMap.getOrDefault(s.charAt(i),0)+1));
            myMap.put(t.charAt(i),(myMap.getOrDefault(t.charAt(i),0)-1));

        }

        for (int i = 0; i < s.length(); i++) {
            if(myMap.get(s.charAt(i))!=0){
                return false;
            }
        }

        return true;
    }

}
