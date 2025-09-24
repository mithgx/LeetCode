class Solution {
    public int minPathSum(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int[] rows:dp) Arrays.fill(rows,-1);


        return cost(grid,dp,n-1,m-1);
    }



    public int cost(int[][] grid,int[][] dp,int i, int j){
        int n=grid.length;
        int m = grid[0].length;

        // if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=cost(grid,dp,i-1,j);
        int down=cost(grid,dp,i,j-1);

        dp[i][j]=grid[i][j]+Math.min(up,down);


        // return grid[i][j]+Math.min(cost(grid,i+1,j),cost(grid,i,j+1));
        return dp[i][j];
        // return min;


        
    }
}

