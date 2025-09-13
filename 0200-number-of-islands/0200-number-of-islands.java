class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(vis,grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;        
    }

    public void dfs(int[][] vis, char[][] grid,int i,int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m || vis[i][j]==1 ||grid[i][j]=='0' ) return ;
        vis[i][j]=1;

        dfs(vis,grid,i+1,j);
        dfs(vis,grid,i,j+1);
        dfs(vis,grid,i-1,j);
        dfs(vis,grid,i,j-1);


    }
}