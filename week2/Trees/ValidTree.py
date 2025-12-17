def validTree(n, edges):
    if not n:
        return True
    adj = {i: [] for i in range(n)}
    for n1, n2 in edges:
        adj[n1].append(n2)
        adj[n2].append(n1)
    visit = set()
    def dfs(i, prev):
        if i in visit:
            return False
        visit.add(i)
        for j in adj[i]:
            if j == prev:
                continue
            if not dfs(j, i):
                return False
        return True
    return dfs(0, -1) and n == len(visit)


n = 4
edges = [[0, 1], [1, 2], [2, 3]]
result = validTree(n, edges)
print(f"Input: n={n}, edges={edges}")
print(f"Output: {result}")

n = 5
edges = [[0,1], [1,4], [0,2], [0,3]]
result = validTree(n, edges)
print(f"Input: n={n}, edges={edges}")
print(f"Output: {result}")

#with cycle (triangle)
n = 3
edges = [[0, 1], [1, 2], [2, 0]]
result = validTree(n, edges)
print(f"Input: n={n}, edges={edges}")
print(f"Output: {result}")

