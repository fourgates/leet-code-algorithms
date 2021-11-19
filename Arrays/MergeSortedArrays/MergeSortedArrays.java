package Arrays.MergeSortedArrays;

import java.util.Arrays;

class MergeSortedArraysMain{
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        MergeSortedArrays msa = new MergeSortedArrays();
        msa.merge(nums1, m, nums2, n);;

        int[] expected = {1,2,2,3,5,6};
        for(int i=0;i<expected.length;i++){
            if(nums1[i] != expected[i]){
                throw new AssertionError("Array didnt get merged properly!");
            }
        }
        System.out.println("done");
    }
}

/**
 * 88. Merge Sorted Array - easy
 * 
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 */
public class MergeSortedArrays {
    // given
    //
    // two int []
    // non-decreasing order
    // n and m (size of arrays)
    //
    // TODO
    // 
    // merge two arrays into nums1
    // nums1 is big enough to accommodate this
    // num1 is pasdded with 0 to accomodate this
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
