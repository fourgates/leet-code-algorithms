package TwoPointers.TwoSumsII;

import Utils.PrintUtils;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
class TwoPointersTwoSumsIIMain{
    public static void main(String[] args){
        TwoPointersTwoSumsII t = new TwoPointersTwoSumsII();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] out = t.twoSum(nums, target);
        PrintUtils.printArray(out);
    }
}
public class TwoPointersTwoSumsII {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length -1;
        while(left < right){
            int c = numbers[left] + numbers[right];
            if(c == target){
                return new int[]{left + 1, right + 1};
            }
            if(c > target){
                right--;
            }
            else{
                left++;
            }
        }
        return null;
    }
}
