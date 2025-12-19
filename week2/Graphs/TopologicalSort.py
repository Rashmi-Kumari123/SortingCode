from collections import deque
## Topological Sort (using BFS) kahn's Algo
def topSort(V, edges):
    adj = [[] for i in range(V)]
    for u, v in edges:
        adj[u].append(v)
    indegree = [0] * V
    for u in range(V):
        for v in adj[u]:
            indegree[v] += 1
    q = deque()
    for i in range(V):
        if indegree[i] == 0:
            q.append(i)
    topo = []
    while q:
        node = q.popleft()
        topo.append(node)
        for neigh in adj[node]:
            indegree[neigh] -= 1
            if indegree[neigh] == 0:
                q.append(neigh)
    return topo
    
V = 5
edges = [[0, 1], [1, 4], [2, 3]] 
result = topSort(V, edges)
print(f"Input: V={V}, edges={edges}")
print(f"Topological Order: {result}")
print()

V = 5
edges = [[0, 1], [1, 2], [2, 3], [3, 4]]  
result = topSort(V, edges)
print(f"Input: V={V}, edges={edges}")
print(f"Topological Order: {result}")

