# Pseduo code

```
 foreach row
     foreach col
         queue up the neccessary rows

 you may need to keep track of visited nodes
 while the queue is not empty
     get the current cell and visit all its neighbors
     do a bounds check 
     mark the cell visited
     queue up the neighbor
```

## Complexity
- `O(N * M)`

## Space
- `O(N * M)`