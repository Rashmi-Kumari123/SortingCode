package Graphs;
// As we know, an island is a group of connected '1's surrounded by '0's and I am using  DFS to find and mark all connected land cells
public class CheckNumOfIsland {
    public int numIslands(char[][] grid){
        int islandCnt = 0;
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == '1'){
                    islandCnt += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return islandCnt;
    }
    public void dfs(char[][] grid, int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0'){
            return;
        }grid[row][col] = '0'; //marking that cell as visited
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
    
}
