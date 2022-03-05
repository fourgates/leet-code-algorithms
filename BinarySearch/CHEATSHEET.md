## Psedo code
set left to a start position
set right to the length of array
init a mid night
while left is less than right
    calculate mid (left + right) / 2
    if you found what you are looking for, return it
    decrement the right pointer if the curr mid value >= to what you are looking for
        right = mid
    else increment the left pointer
        left = mid + 1
if you are just looking for an index or starting point return left