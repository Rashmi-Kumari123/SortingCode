# As we know, a connected component is a set of nodes where every node is reachable from every other node and 
# I am using DFS to traverse and count these components.
def countComponents(n, edges):
    if n == 1:
        return 1
    components = 0
    graph = {node : [] for node in range(n)}
    for nd1, nd2 in edges:
        graph[nd1].append(nd2)
        graph[nd2].append(nd2)

    visited = set()
    def dfs(node):
        for neigh in graph[node]:
            if neigh not in visited:
                visited.add(neigh)
                dfs(neigh)
    for node in graph:
        if node in visited:
            continue
        else:
            visited.add(node)
            components += 1
            dfs(node)
    return components


    
