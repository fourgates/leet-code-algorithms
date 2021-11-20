package Design.ParkingSystem;

public class DesignParkingSystem {
    // given
    // 
    // parking lot has 3 kinds of spaces, bug, medium, and small2
    //
    // constructor gives the number of available slots for each type
    // 
    // addCar checks if a space is avaialble
    // 1 - big
    // 2 - medium
    // 3 - small
    // a car can only park in a space of its type
    //
    // return true and mark space removed if there is room
    // else return false
    //
    // questions
    // constraints on the number of spaces?
    // multi threaded? (synchronized)
    private final boolean[] big;
    private final boolean[] medium;
    private final boolean[] small;

    /**
     * [1603. Design Parking System - Easy](https://leetcode.com/problems/design-parking-system/)
     * 
     * @param big
     * @param medium
     * @param small
     */
    public DesignParkingSystem(int big, int medium, int small) {
        this.big = new boolean[big];
        this.medium = new boolean[medium];
        this.small = new boolean[small];
    }
    
    public boolean addCar(int carType) {
        boolean[] spaces = getSpaces(carType);
        for(int i=0;i<spaces.length;i++){
            if(!spaces[i]){
                spaces[i] = true;
                return true;
            }
        }
        return false;
    }
    private boolean[] getSpaces(int carType){
        if(1 == carType){
            return this.big;
        }
        else if(2 == carType){
            return this.medium;
        }
        else{
            return this.small;
        }
        //throw new RuntimeException("Car type not supported: " + int);
    }    
}
