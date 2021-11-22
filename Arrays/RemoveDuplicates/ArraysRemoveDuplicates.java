package Arrays.RemoveDuplicates;

/**
 * [26. Remove Duplicates from Sorted Array - Easy](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 */
class ArraysRemoveDuplicatesMain{
    public static void main(String[] args){
        int expecteDistinctValues = 2;
        int[] expected = {1,2};
        ArraysRemoveDuplicates d = new ArraysRemoveDuplicates();
        int[] input = {1,1,2};
        int actualDistinctValues = d.removeDuplicates(input);
        if(expecteDistinctValues != actualDistinctValues){
            throw new AssertionError("number of distinct values is incorrec");
        }
        for(int i=0;i<expecteDistinctValues;i++){
            if(expected[i] != input[i]){
                throw new AssertionError();
            }
        }
        System.out.println("done");
    }
}
public class ArraysRemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // edge case
        if(nums.length == 0){
            return 0;
        }
        // two pointers
        // keep a pointer to where the latest distinct number is
        int distinct = 0;
        for(int j=1;j<nums.length;j++){
            // when we find a distinct number 
            // move it into place
            if(nums[distinct] != nums[j]){
                distinct++;
                nums[distinct] = nums[j];
            }
        }
        return distinct + 1;
    }
}
