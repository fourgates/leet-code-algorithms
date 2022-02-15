    algo
        create ds to memo
        establish base case
        establish recursive function

pseduo code 3 bottom-down

 create a base case(s) - sometimes there is more than one!
 calculate the resursive relation (e.g. dp(n) = dp(n-1) + dp(n-2))
 return the recursive relation

pseduo code 3 bottom-down (with memo)

 create a ds to store values
 create a base case(s) - sometimes there is more than one!
 if we already calculated this value (memo) return it!
 calculate the resursive relation (e.g. dp(n) = dp(n-1) + dp(n-2))
 store this value for the current iteration
 return the recursive relation


 // DP
//
// 1. DS to store or compute result
// 2. Recursive relation to transition between states
// 3. Base Case - which case does not require DP?

// base case, if you are on the last step you can only take one step!
//            if you are on the second to last step you can either take one step of two\
//
// pesduo code 1 - top down - need space for recursion
//
//  base case - if the current step is 1 return 1
//  base case - if the current step is 2 return 2
//      return climbing the n-1 step and the n-2 step
//
//
// pseduo code 2 - bottom down - O(n) space
//
//  if n is equal to 1 return 1
//  create an array of integers from 0 to n
//  base case - update the first index to 1 and the second index to 2 (base conditions)
//  iterate over each number (starting at 2 bc we filled in the first two)
//      relation step - the current step is equal to the previous step plus the one before that!
//  return the last step!
// (n^2) without memorization!
// O(n) with memo, you calculate each value once!


// you can either rob the house or not rob the house...
// base case?
//  take the max between robbing the current house and current house + 2 or robbing the next house
//
//  if the current index great than or equal to the number of houses return 0, you cannot rob anymore house
//  recursively calculate the max 
//      between robbing the current house, skipping the next, and robbing the next
//      of robbing the next house
//  
//
// pseduo code 3 bottom-down
//
//  create a base case(s) - sometimes there is more than one!
//  calculate the resursive relation (e.g. dp(n) = dp(n-1) + dp(n-2))
//  return the recursive relation

// pseduo code 3 bottom-down (with memo)
//
//  create a ds to store values
//  create a base case(s) - sometimes there is more than one!
//  if we already calculated this value (memo) return it!
//  calculate the resursive relation (e.g. dp(n) = dp(n-1) + dp(n-2))
//  store this value for the current iteration
//  return the recursive relation