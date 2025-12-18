
from collections import deque
graph = {
  'A' : ['B','C'],
  'B' : ['D', 'E', 'F'],
  'C' : ['G'],
  'D' : [],
  'E' : [],
  'F' : ['H'],
  'G' : ['I'],
  'H' : [],
  'I' : []
}

def bfs(graph, node):
    visited = set()
    queue = deque()
    visited.add(node)
    queue.append(node)
    while queue:
        s = queue.popleft() # popleft is O(1)
        print(s, end = ' ')

        for n in graph[s]:
            if n not in visited: # here visited is a set, so this lookup is O(1).
                visited.add(n)
                queue.append(n)
def main():
    bfs(graph, 'A')
main()
