def bfs(graph, start,goal):
    visited = set() 
    qlist = [start]

    visited.add(start)
   #qlist.append(start)  

    while qlist:
        node = qlist.pop(0)
        print (node)
       #qlist.append(node)
        if(node == goal):
            return qlist
       #print(node, end=" ") 
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)  
                qlist.append(neighbor)
        
graph = {
    1: [3, 4, 2],
    2: [6],
    3: [4],
    4: [],
    5: [4],
    6:[5]
}

print("BFS starting from root node")
bfs(graph, 1, 5)

