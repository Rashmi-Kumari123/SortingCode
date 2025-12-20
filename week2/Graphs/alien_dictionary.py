from collections import deque
# Problem I am solving is : given a sorted list of words in an alien language and I need to find the character ordering.
# This is essentially building a directed graph where edges represent 'comes before' relationships, then finding a topological ordering.
def find_alien_order(words):
    graph = [[] for i in range(26)]
    indegree = [0] * 26
    present = [False]*26
    for word in words:
        for ch in word:
            present[ord(ch) - ord('a')] = True
    
    for i in range(len(words)-1):
        w1, w2 = words[i], words[i+1]
        minlen = min(len(w1), len(w2))
        found = False
        for j in range(minlen):
            c1, c2 = w1[j], w2[j]
            if c1 != c2:
                u, v = ord(c1) - ord('a'), ord(c2) - ord('a')
                graph[u].append(v)
                indegree[v] += 1
                found = True
                break
        if not found and len(w1) > len(w2):
            return " "
    q = deque()
    alien_order = []
    for i in range(26):
        if present[i] and indegree[i] == 0:
            q.append(i)
    while q:
        curr = q.popleft()
        alien_order.append(curr + ord('a'))
        for neigh in graph[curr]:
            indegree[neigh] -= 1
            if indegree[neigh] == 0:
                q.append(neigh)
    count_present = sum(present)
    if len(alien_order) != count_present:
        return " "
    return "".join(alien_order)

