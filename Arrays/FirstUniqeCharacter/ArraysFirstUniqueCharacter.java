package Arrays.FirstUniqeCharacter;

import java.util.HashMap;
import java.util.Map;

public class ArraysFirstUniqueCharacter {
    
}
class Solution {
    public int firstUniqChar(String s) {
        return useFastArray(s);
        //return useMap(s);
    }
    public int useMap(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            Integer count = charCount.get(c);
            if(charCount.get(c) == null){
                count = 0;
            }
            charCount.put(c, ++count);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(charCount.get(c) == 1){
                return i;
            }
        }
        return -1;        
    }
    public int useFastArray(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }    
}