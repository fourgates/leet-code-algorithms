package TwoPointers.ReverseString;

/**
 * 344. Reverse String - Easy 
 * 
 * https://leetcode.com/problems/reverse-string/
 */
class TwoPointersReverseStringMain{
    public static void main(String[] args){
        TwoPointersReverseString t = new TwoPointersReverseString();
        char[] actual = {'h','e','l','l','o'};
        char[] expected = {'o','l','l','e','h'};
        t.reverseString(actual);;
        for (int i = 0; i < expected.length; i++) {
            if(actual[i] != expected[i]){
                throw new AssertionError("char doesnt match!");
            }
        }
    }
}
public class TwoPointersReverseString {
    public void reverseString(char[] s) {
        int left=0, right=s.length - 1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
