package Backtracking.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingLetterCasePermutation {
    
}
// pseduo code 1
//  if he current string is equal to the original string length, add the curr string to out
//  else
//      if the curr char is a digit
//          concat it with the curr string and backtrack with the next char
//      if its an alphanumeric
//          first add the uppercase to the curr string
//          call backtrack with the next char
//          
//          next add the lowercase to the curr string
//          call backtrack with the next char
//      
// base case - if the current string's length is equal to n which is the max string length add the string to our output
// else
//  iterate over the characters in the original string
//      check to see if the lowercase is in current string
//      if it is not, we will add it to the current string
//          if it is, 
//              check to see if the uppercase is in the current string
//              if uppercase is not, add that to the current string
//      call backtrack with the current string
//      backtrack step, remove the current character we are working with

class Solution {
    List<String> out = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        if(s == null){
            return out;
        }
        char[] chars = s.toCharArray();
        backtrack(chars, "", 0);
        return out;
    }
    private void backtrack(char[] chars, String curr, int i){
        if(curr.length() == chars.length){
            out.add(new String(curr));
        }
        else{
            boolean charIsDigit = !Character.isAlphabetic(chars[i]);
            if(charIsDigit){
                curr = curr + chars[i];
                backtrack(chars, curr, i+1);
            }
            else{
                String upper = curr + Character.toUpperCase(chars[i]);
                backtrack(chars, upper, i+1);
                
                String lower = curr + Character.toLowerCase(chars[i]);
                backtrack(chars, lower, i+1);
            }
        }
    }
}