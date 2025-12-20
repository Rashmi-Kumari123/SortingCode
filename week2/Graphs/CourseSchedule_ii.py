from collections import deque
# Problem I am solving:find an order to take courses such that all prerequisites are satisfied
# st edge (vi, vj) -> means task vi must be taken before vj.
# i.e basically finding a topological ordering of a directed graph.
def findOrder(numCourses, prerequisites):
    graph = [[] for _ in range(numCourses)]
    indegree = [0]* numCourses
    for crs, prereq in prerequisites:
        graph[prereq].append(crs)
        indegree[crs] += 1
    q = deque()
    for crs in range(numCourses):
        if indegree[crs] == 0:
            q.append(crs)
    topo_order = []
    while q:
        curr = q.popleft()
        topo_order.append(curr)
        for neigh in graph[curr]:
            indegree[neigh] -= 1
            if indegree[neigh] == 0:
                q.append(neigh)

    return topo_order if len(topo_order) == numCourses else []
