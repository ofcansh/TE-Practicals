def bfs(graph, start, goal):
    visited = set() 
    qlist = [(start, [start])]  # Store the current path along with the node

    visited.add(start)

    while qlist:
        node, path = qlist.pop(0)  # Get the current node and the path taken to reach it
        print(node)  # Print the current node

        if node == goal:
            return path  # Return the path if the goal is found

        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)  
                qlist.append((neighbor, path + [neighbor]))  # Append the neighbor and the updated path

    return None  # Return None if the goal is unreachable

graph = {
    1: [3, 4, 2],
    2: [6],
    3: [4],
    4: [],
    5: [4],
    6: [5]
}

print("BFS starting from root node")
result = bfs(graph, 1, 5)

if result is None:
    print("Goal node is unreachable.")
else:
    print("Path to goal node:", result)