package TwoPointers.MoveZeroes;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 */
class TwoPointersMoveZerosMain{
    public static void main(String[] args){
        TwoPointersMoveZeros t = new TwoPointersMoveZeros();
        int[] nums = {0,1,0,3,12};
        t.moveZeroes(nums);
        printArray(nums);
    }
    private static void printArray(int[] nums){
        System.out.println("Out: ");
        System.out.print("[");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
            if(i < nums.length - 1){
                System.out.print(","); 
            }
        }
        System.out.print("]");
        System.out.println();
    }
    
}
public class TwoPointersMoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] == 0){
                shiftLeft(nums, left, right);
                nums[right] = 0;
                right--;
            }
            else{
                left++;
            }
        }
    }
    private void shiftLeft(int[] nums, int start, int finish){
        // shift every element once to the left
        while(finish > start){
            nums[start] = nums[start + 1];
            start++;
        }
    }
}
