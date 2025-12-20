import heapq
# problem I am solving is to find the minimum time for a signal to reach all nodes from a source node k. 
# i.e. basically finding the shortest path from k to all nodes, then taking the maximum.

def networkDelayTime(times,n,k):
        adj = {i: [] for i in range(1, n + 1)}
        for u, v, w in times:
            adj[u].append((v, w))

        result = [float('inf')] * (n + 1)
        result[k] = 0  # Distance to source node is 0
        pq = [(0, k)]
        heapq.heapify(pq)
        while pq:
            d, node = heapq.heappop(pq)
            for adjNode, dist in adj[node]:
                # If a shorter path to adjNode is found, updating it
                if d + dist < result[adjNode]:
                    result[adjNode] = d + dist
                    heapq.heappush(pq, (d + dist, adjNode))

        # Finding the maximum delay among all reachable nodes
        ans = max(result[1:])  # ignoring index 0 since nodes are 1-indexed
        return -1 if ans == float('inf') else ans
