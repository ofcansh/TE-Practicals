def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()

    visited.add(start)  
    print(start, end=" ")  

    for neighbor in graph[start]:  
        if neighbor not in visited:  
            dfs(graph, neighbor, visited)

graph = {
    1: [3, 4, 2],
    2: [5, 6],
    3: [4],
    4: [5],
    5: [6],
    6: []
}

print("DFS starting from root node")
dfs(graph, 1)