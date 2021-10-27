package BinarySearch;

class BinarySearchFindInsertIndexMain {
    public static void main(String[] args){
        BinarySearchFindInsertIndex b = new BinarySearchFindInsertIndex();
        int[] nums = {1,3,5,6};
        int target = 7;
        int insertIndex = b.searchInsert(nums, target);
        System.out.println("insertIndex: " + insertIndex);
    }
}

public class BinarySearchFindInsertIndex {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }
        while(left <= right){
            int pivot = left + (right - left) / 2;
            int p = nums[pivot];
            // found target
            if(target == p){
                return pivot;
            }
            // we found where it should be inserted
            // avoid edge cases since we handled them already
            if(p < target && target < nums[pivot + 1]){
                return pivot + 1;
            }          
            if(p < target){
                left = pivot + 1;
            }
            else{
                right = pivot -1;
            }
            
        }
        return -1;
    }
}
