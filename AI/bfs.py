def bfs(graph, start):
    visited = set() 
    qlist = [] 

    visited.add(start)
    qlist.append(start)  

    while qlist:
        node = qlist.pop(0)
        print(node, end=" ") 
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)  
                qlist.append(neighbor)          
graph = {
    1: [3, 2],
    3: [4],
    2: [5],
    4: [5],
    5: [ ]
}

print("BFS starting from root node")
bfs(graph, 1)
