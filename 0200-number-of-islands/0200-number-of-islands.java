class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt=0;

        int[][] vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                dfs(grid,vis,i,j);
                cnt++;}
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid,int[][] vis, int i , int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0|| i>=n ||j>=m || grid[i][j]=='0'||vis[i][j]==1) return;

        vis[i][j]=1;
        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i,j+1);
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i,j-1);
    }
}