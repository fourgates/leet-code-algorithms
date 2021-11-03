package Utils;

public class PrintUtils {
    public static void printArray(int[] nums){
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
