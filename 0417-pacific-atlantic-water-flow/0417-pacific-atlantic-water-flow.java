class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m =heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic= new boolean[n][m];

        for(int i =0;i<n;i++){
            dfs(heights,pacific,i,0,heights[i][0]);
            dfs(heights,atlantic,i,m-1,heights[i][m-1]);
        }

        for(int i=0;i<m;i++){
            dfs(heights,pacific,0,i,heights[0][i]);
            dfs(heights,atlantic,n-1,i,heights[n-1][i]);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;
        
    }
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j,int prevheight){
        if(i<0 || j<0 || i>=heights.length||j>=heights[0].length ||ocean[i][j] || prevheight>heights[i][j]) return;

        ocean[i][j]=true;

        dfs(heights,ocean,i+1,j,heights[i][j]);
        dfs(heights,ocean,i,j+1,heights[i][j]);
        dfs(heights,ocean,i-1,j,heights[i][j]);
        dfs(heights,ocean,i,j-1,heights[i][j]);


    }
}