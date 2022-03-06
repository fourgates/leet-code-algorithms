package Strings.GreatestCommonDivsor;

public class StringsGreatestCommonDivsor {
    
}
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Swap the paramters when needed
        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);
        
        // Since we swap
        if (str2.length() == 0)
            return str1;

        // Check if str1 starts with str2
        if (!str1.substring(0, str2.length()).equals(str2)) {
            return "";
        }
        
        // Call the function with remaining part of str1
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
class Solution2 {
    public String gcdOfStrings(String str1, String str2) {
        String smallerString = str1.length() > str2.length() ? str2 : str1;
        String biggerString = smallerString.equals(str1) ? str2 : str1;
        int biggerSize = biggerString.length();
        int smallerSize = smallerString.length();
        String originalSmaller = new String(smallerString);
        // find a sub string of smaller string 
        int smallerStringSize = smallerString.length();
        while(smallerStringSize > 0){
            
            // if there a substring of the small in the large?
            int subStringCount = biggerString.split(smallerString, -1).length - 1;
            if(subStringCount > 0){
                // does this divide into the large evenly
                int subStringLength = smallerString.length();
                boolean dividesBiggerEvenly = subStringCount * subStringLength == biggerSize;
                if(dividesBiggerEvenly){
                    // check to see if this substring divies the smaller evenly
                    subStringCount = originalSmaller.split(smallerString, -1).length - 1;
                    if(subStringCount * subStringLength == smallerSize){
                        return smallerString;
                    }
                }              
            }
            
            // make smaller string smaller
            if(smallerString.length() - 2 >= 0){
                smallerString = smallerString.substring(0, smallerString.length() - 1);    
            }
            
            smallerStringSize--;
        }
        return "";
    }
}