package BinarySearch;


/**
 * 
 * You are a product manager and currently leading a team to 
 * develop a new product. Unfortunately, the latest version of your 
 * product fails the quality check. Since each version is developed based 
 * on the previous version, all the versions after a bad version are also bad. 
 * 
 * uppose you have n versions [1, 2, ..., n] and you want to find out the 
 * first bad one, which causes all the following ones to be bad. 
 * You are given an API bool isBadVersion(version) 
 * which returns whether version is bad. 
 * 
 * Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * 
 * This is a great use case for binary search since versison are assumed in order!
 * 
 * The key is the figure out that the base case is where the is a bad version
 * that follows a good version
 * 
 * 278
 * https://leetcode.com/problems/first-bad-version/
 */
class BinarySearchFirstBadVersionMain{
    public static void main(String[] args){
        int bad = 1;
        int n = 1;
        BinarySearchFirstBadVersion b = new BinarySearchFirstBadVersion(bad);
        int out = b.firstBadVersion(n);
        System.out.println("First Bad Version: " + out);
    }
}
public class BinarySearchFirstBadVersion {
    private final int badVersion;
    public BinarySearchFirstBadVersion(int badVersion){
        this.badVersion = badVersion;
    }
    public boolean isBadVersion(int n){
        return this.badVersion == n;
    }
    public boolean isGoodVersion(int n){
        return this.badVersion != n;
    }    
    public int firstBadVersion(int n) {
        // TODO - base case n = 1
        // TODO - base case n = the first bad version
        // lets try binary search...
        int left=1, right = n;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            boolean badCheck = isBadVersion(pivot);
            // if we found a bad version we need to subset the left
            if(badCheck){
                boolean foundIt = isGoodVersion(pivot - 1);
                if(foundIt){
                    return pivot;
                }
                right = pivot -1;
            }
            // subset the right
            else{
                left = pivot + 1;
            }
        }
        return -1;
    }
}
