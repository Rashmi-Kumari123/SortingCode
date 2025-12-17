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


# Example 1: Course Prerequisites
# Courses: 0=Math, 1=Physics, 2=Chemistry, 3=Biology, 4=CS
# Prerequisites: Math before Physics, Physics before CS, Chemistry before Biology
V = 5
edges = [[0, 1], [1, 4], [2, 3]]  # Math->Physics, Physics->CS, Chemistry->Biology
result = topSort(V, edges)
print("Example 1: Course Prerequisites")
print(f"Input: V={V}, edges={edges}")
print(f"Topological Order: {result}")
print()

# Example 2: Task Scheduling
# Tasks: 0=Design, 1=Code, 2=Test, 3=Deploy, 4=Monitor
# Dependencies: Design before Code, Code before Test, Test before Deploy, Deploy before Monitor
V = 5
edges = [[0, 1], [1, 2], [2, 3], [3, 4]]  # Design->Code->Test->Deploy->Monitor
result = topSort(V, edges)
print("Example 2: Task Scheduling")
print(f"Input: V={V}, edges={edges}")
print(f"Topological Order: {result}")

