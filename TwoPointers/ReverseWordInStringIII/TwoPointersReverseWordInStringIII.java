package TwoPointers.ReverseWordInStringIII;

/**
 * [557. Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
 */
class TwoPointersReverseWordInStringIIIMain{
    public static void main(String[] args){
        TwoPointersReverseWordInStringIII t = new TwoPointersReverseWordInStringIII();
        String input = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        String actual = t.reverseWords(input);
        if(!actual.equals(expected)){
            throw new AssertionError("Strings dont match!");
        }
    }
}
public class TwoPointersReverseWordInStringIII {
    public String reverseWords(String s) {
        String[] splitWords = s.split(" ");
        String out = "";
        
        for(int i=0;i<splitWords.length;i++){
            String sub = splitWords[i];
            if(i <splitWords.length - 1){
                out += reverse(sub) + " ";
            }
            else{
                out += reverse(sub);
            }
        }
        return out;
    }
    private String reverse(String sub){
        StringBuilder sb = new StringBuilder(sub);
        int left = 0, right = sub.length() - 1;
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}
