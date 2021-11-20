package Arrays.FromPermutations;

class ArraysFromPermutationsMain{
    public static void main(String[] args){
        int[] input = {0,2,1,5,3,4};
        int[] expected = {0,1,2,4,5,3};
        ArraysFromPermutations a = new ArraysFromPermutations();
        int[] actual = a.buildArray(input);
        for(int i=0;i<expected.length;i++){
            if(actual[i] != expected[i]){
                throw new AssertionError("array doesnt match!");
            }
        }
        System.out.println("done!");
    }
}
/**
 * 
 * [1920. Build Array from Permutation - Easy](https://leetcode.com/problems/build-array-from-permutation/)
 * 
 * 
 */
public class ArraysFromPermutations {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
