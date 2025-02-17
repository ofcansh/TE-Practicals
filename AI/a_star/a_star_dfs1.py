def dfs_all_paths(start, goal, graph, path=None, visited=None, total_weight=0):
    if path is None:
        path = []
    if visited is None:
        visited = set()

    path.append(start)

    if start == goal:
        return [(path, total_weight)]
    
    all_paths = []
    
    for neighbor, weight in graph.get(start, []):
        if neighbor not in visited:
            new_paths = dfs_all_paths(
                neighbor, goal, graph, path.copy(), visited.copy(), total_weight + weight
            )
            all_paths.extend(new_paths)
    
    return all_paths

graph = {
    'A': [('B', 3), ('F', 2)],
    'B': [('G', 4), ('C', 2)],
    'C': [('D', 3)],
    'D': [('E', 5)],
    'E': [ ],
    'F': [('G', 5)],
    'G': [('E', 4), ('C', 3)],
}

start = 'A'
goal = 'E'
paths = dfs_all_paths(start, goal, graph)

for path, weight in paths:
    print(f"Path: {path}, Weight: {weight}")
