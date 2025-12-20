package Graphs;
// we know an undirected graph is called biparttite if nodes can be coloured blue and white st every edge has one white and oe blue end.
// 0 -> not colored, 1 and -1 ->considering to have different colors of the edge
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];
        for (int i= 0; i<n; i++){
            if (color[i] == 0){
                if (!dfs(i, graph, color, 1))
                    return false;
            }
        }return true;
    }
    private boolean dfs(int node, int[][] graph, int[] color, int currColor){
        color[node] = currColor;
        for (int neigh: graph[node]){
            if (color[neigh] == 0){
                if (!dfs(neigh, graph, color, -currColor)){
                    return false;
                }
            }else if(color[neigh] == currColor) return false;
        }return true;
    }
    
}
