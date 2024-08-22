package themis.algo.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to convert a Roman numeral to an integer.
 *
 * Roman numerals are represented by seven different symbols:
 * <pre>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 *
 * For example:
 * <ul>
 * <li>2 is written as II in Roman numeral, just two ones added together.</li>
 * <li>12 is written as XII, which is simply X + II.</li>
 * <li>27 is written as XXVII, which is XX + V + II.</li>
 * </ul>
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five, we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 * <ul>
 * <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 * <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 * <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 *
 * Given a Roman numeral string, this method will convert it to an integer.
 *
 * <p>Examples:</p>
 * <pre>
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 *
 * <p>Constraints:</p>
 * <ul>
 * <li>1 <= s.length <= 15</li>
 * <li>s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').</li>
 * <li>It is guaranteed that s is a valid Roman numeral in the range [1, 3999].</li>
 * </ul>
 */
public class RomanToInteger {

    /**
     * @param s the Roman numeral string to be converted
     * @return the integer value corresponding to the given Roman numeral
     * First submitted Solution with O(N) time complexity
     */
    public static int romanToInt(String s) {

        int sum=0;

        if(s.contains("IV")){
            s=s.replace("IV","");
            sum+=4;
        }
        if(s.contains("IX")){
            s=s.replace("IX","");
            sum+=9;
        }
        if(s.contains("XL")){
            s=s.replace("XL","");
            sum+=40;
        }
        if(s.contains("XC")){
            s=s.replace("XC","");
            sum+=90;
        }
        if(s.contains("CD")){
            s=s.replace("CD","");
            sum+=400;
        }
        if(s.contains("CM")){
            s=s.replace("CM","");
            sum+=900;
        }

        for (int i = 0; i < s.length(); i++) {

           char symbol = s.charAt(i);
           switch (symbol){
               case 'I':
                   sum+=1;
                   break;
               case 'V':
                   sum+=5;
                   break;
               case 'X':
                   sum+=10;
                   break;
               case 'L':
                   sum+=50;
                   break;
               case 'C':
                   sum+=100;
                   break;
               case 'D':
                   sum+=500;
                   break;
               case 'M':
                   sum+=1000;
                   break;
               default:
                   sum+=0;
                   break;
           }


        }

        return sum;
    }

    /**
     * @param s the Roman numeral string to be converted
     * @return the integer value corresponding to the given Roman numeral
     * Optimal Solution with O(N) time complexity
     */
    public static int romanToIntOptimal(String s) {

        Map<Character,Integer> myMap = new HashMap<>();
        myMap.put('I',1);
        myMap.put('V',5);
        myMap.put('X',10);
        myMap.put('L',50);
        myMap.put('C',100);
        myMap.put('D',500);
        myMap.put('M',1000);

        int sum=0;

        for (int i = 0; i < s.length(); i++) {
            if((i < s.length()-1) && (myMap.get(s.charAt(i)) < myMap.get(s.charAt(i+1)))){
                sum-=myMap.get(s.charAt(i));
            }else{
                sum+=myMap.get(s.charAt(i));
            }
        }

        return sum;
    }

}
