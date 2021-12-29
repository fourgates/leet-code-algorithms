# Quick Union

- quick union is where you store the parent node of each node in the index value. 
- when you union two sets you simply update one node, where in quick find you update `n` numbe of nodes that pointed to that parent
- this is a `O(n)` complexity for all operations, but is generally faster than quick find!