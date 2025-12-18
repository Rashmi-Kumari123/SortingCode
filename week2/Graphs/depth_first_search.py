graph = {
  'A' : ['B','G'],
  'B' : ['C', 'D', 'E'],
  'C' : [],
  'D' : [],
  'E' : ['F'],
  'F' : [],
  'G' : ['H'],
  'H' : ['I'],
  'I' : [],
}

def dfs(graph, node):
    visited = set()
    stack = []
    visited.add(node)
    stack.append(node) 
    while stack:
        s = stack.pop()
        print(s, end = ' ')
        # Reverse iterate through the edge list so that results match recursive version..I mean jo recently node visit kr rahe usi ke children ko pahle le
        for n in reversed(graph[s]):
            if n not in visited:
                visited.add(n)
                stack.append(n)
def main():
    dfs(graph, 'A')

main()