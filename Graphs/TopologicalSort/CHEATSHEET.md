## Pseduo Code
    edge case 
        no nodes
    edge case 
        no edges
    create array of in-degree courses
    for each edge
        increment its degree
    create a queue of zero degree coures (this is where you will start)
    for each node
        queue any node that zero degree
    edge caes 
        no zero degree - you cannot do a topoloical sort w.o it return empty array not possible
    while zero degree is not empty
        get node
        add node to result
        for each edge
            decrement the degree for each node that have an edge to the curr node
            queue any nodes that are now zero degrees
    for each degree
        if there exists a non zero degree this is impossible
    return result