## insert into Trie
set curr to root
iterate over each char in the give word
    add a new key to the child map if it doesnt exist for the curr char
    move the curr pointer to the childmap's key for the curr char
mark the curr node as a word (the last curr will be the end of the word / char sequence)

## search Trie
set curr pointer to root
iterate over each char in the given string
    if no key, return -- no solution
    move curr to the child map key for the curr char
return true if you just want to know if it exists
else you can iterate over all keys in the curr map to return all the words
    you can iterate of all chars a to z if you need a lexi sort