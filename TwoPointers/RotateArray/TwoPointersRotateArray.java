package TwoPointers.RotateArray;

class TwoPointersRotateArrayMain{

    public static void main(String[] args){
        TwoPointersRotateArray2 t = new TwoPointersRotateArray2();
        int[] nums = {1,2};
        int k = 3;
        t.rotate(nums, k);
        System.out.println("nums" + nums);
    }
}
// new thoughts
//
// nums = "----->-->"; k =3
// result = "-->----->";

// reverse "----->-->" we can get "<--<-----"
// reverse "<--" we can get "--><-----"
// reverse "<-----" we can get "-->----->"
// this visualization help me figure it out :)

// the problem comes down to really just move k elements from the end of the array to the front
// you can accomplish this in 3 steps
// 1. reverse the array to the subset of items is not on the correct side
// 2. reverse the left side of the array
// 3. reverse the right side of the array
class TwoPointersRotateArray2 {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2){
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}