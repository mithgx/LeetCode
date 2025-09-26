class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] time = new int[n][m];
        for(int [] t : time){
            Arrays.fill(t,Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++ ){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) dfs(grid,time,i,j,0);

            }
        }

        int timereq=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(time[i][j]==Integer.MAX_VALUE) return -1;
                    timereq=Math.max(timereq,time[i][j]);
                }
            }
        }
        return timereq;
        
    }

    private void dfs(int[][] grid, int[][] time,int i , int j , int currtime){        int n = grid.length;
    int m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m ||grid[i][j]==0 ||currtime>=time[i][j]) return;
        time[i][j]=currtime;
        dfs(grid,time,i+1,j,currtime+1);
        dfs(grid,time,i,j+1,currtime+1);
        dfs(grid,time,i-1,j,currtime+1);
        dfs(grid,time,i,j-1,currtime+1);

    }
}