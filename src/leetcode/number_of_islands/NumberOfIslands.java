package leetcode.number_of_islands;

public class NumberOfIslands{
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    islands++;
                    visitTile(i, j, grid);
                }
            }
        }
        return islands;
    }
    public void visitTile(int i, int j, char[][] grid){
        grid[i][j] = '0';
        if(i > 0 && grid[i - 1][j] == '1'){
            visitTile(i - 1, j, grid);
        }
        if(i < grid.length - 1 && grid[i + 1][j] == '1'){
            visitTile(i + 1, j, grid);
        }
        if(j > 0 && grid[i][j - 1] == '1'){
            visitTile(i, j - 1, grid);
        }
        if(j < grid[i].length - 1 && grid[i][j + 1] == '1'){
            visitTile(i, j + 1, grid);
        }
    }
}