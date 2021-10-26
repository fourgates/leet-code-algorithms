package BinarySearch;

class Main{
    public static void main(String[] args){
        BinarySearchSorted bs = new BinarySearchSorted();
        int[] arr = {-1,0,3,5,9,12};
        int out = bs.search(arr, 9);
        System.out.println("index:" + out);
    }    
}

/**
 * 
 * Given an array of integers nums which is sorted in ascending order, and an integer target, 
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104 
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * 
 * 704
 * https://leetcode.com/problems/binary-search/
 */
class BinarySearchSorted {
    public int search(int[] nums, int target){
        // set an index at the top (left most index) and bottom (right most index)
        int left=0, right =nums.length -1;

        // edge case for empty array
        if(nums.length == 0){
            return -1;
        }
        // keep going until the left pointer is > or = to the right
        while(left <= right){
            System.out.println("left: " + left + " right: " + right);
            // this is the tricky part
            // find the middle of the "sub" array
            int subArraySize = (right-left);
            System.out.println("array size:" + subArraySize);
            int pivot = left + subArraySize / 2;
            System.out.println("pivot:" + pivot);
            // base case -- we found our target!
            if(nums[pivot] == target){
                return pivot;
            }
            // move the right pointer to the pivot point (omit pivot index)
            if(nums[pivot] > target){
                right = pivot -1;
            }
            // move the left pointer to the pivot point (omit pivot index)
            else{
                left = pivot + 1;
            }
            System.out.println();
        }
        return -1;
    }
}