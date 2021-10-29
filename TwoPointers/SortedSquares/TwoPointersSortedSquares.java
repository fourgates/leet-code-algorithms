package TwoPointers.SortedSquares;

class TwoPointersSortedSquaresMain {
    public static void main(String[] args){
        TwoPointersSortedSquares t = new TwoPointersSortedSquares();
        int[] nums = {-4,-1,0,3,10};
        int[] out = t.sortedSquares(nums);
    
        for(int i=0;i<out.length; i++){
            System.out.println(nums[i]);
        }
    }
}

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * 
 * Squaring each element and sorting the new array is very trivial, 
 * could you find an O(n) solution using a different approach?
 * 
 * 977
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class TwoPointersSortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left=0, right = nums.length -1;
        int[] out = new int[nums.length];
        int fillingIndex = nums.length - 1;
        while(left <= right){
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if(b >= a){
                out[fillingIndex] = b;
                fillingIndex--;
                right--;
            }
            else{
                out[fillingIndex] = a;
                fillingIndex--;
                left++;
            }
        }
        return out;
    }
}
