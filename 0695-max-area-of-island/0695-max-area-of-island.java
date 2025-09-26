class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max=Integer.MIN_VALUE;
        int [][] vis= new int[n][m];int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1)  area =Math.max(area, dfs(grid,vis,i,j));

            }
        }

        return area;       
    }
    private int dfs(int[][] grid,int[][] vis,int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0||j<0||i>=n||j>=m||vis[i][j]==1||grid[i][j]==0) return 0;
        vis[i][j]=1;
        return 1+dfs(grid,vis,i+1,j)+dfs(grid,vis,i-1,j)+dfs(grid,vis,i,j+1)+dfs(grid,vis,i,j-1);
       
    }
}