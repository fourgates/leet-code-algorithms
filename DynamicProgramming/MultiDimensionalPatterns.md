# Multidimensional DP

Most easy problems are one dimensional. They only require one state variable. But more complex ones can have 2 or up to 5 for more complicated problems. 

Here are some common things to look for when defining state variables. 

- There is usually some type of index. If there is an array of string this is pretty much obvious. But it can also represent an up to mark. 

`dp(4)` might solve for `nums[0,1,2,3,4]`

- Sometimes there is a 2nd index! This can occur when you are a start and an end and is commonly used as `i` and `j`. 

`dp(1,3)` might solve a problem for `num = [1,2,3]`

- Constraints. Sometimes you are told you can only use `k` elements or break something up into `k` groups, etc

- Variables that describe the status of a current state. 

e.g.
"true if currently holding a key, false if nott"

"currently holding k packages", etc

- Tuples or bitmasks used to indicate things being visited or used. 

e.g.

A bitmask where the ith bit indicated the ith city has been visted. 

** Mutable datastructures CANNOT be used. only immutables like numbers and string can be hased and therefore memorized **