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