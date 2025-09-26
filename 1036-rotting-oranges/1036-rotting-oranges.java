class Pair{
    int i;
    int j;
    int time;
    Pair(int i, int j, int time)
{
    this.i=i;
    this.j=j;
    this.time=time;
}}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else vis[i][j]=0;





            }
        }
        int time=0;
        int cnt=0;

        int[] drow = {-1,0,+1,0};
        int[] dcol ={0,+1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek().i;
            int c = q.peek().j;
            int t = q.peek().time;
            time = Math.max(time,t);
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && ncol >=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=2 && grid[i][j]==1) return -1;
            }
        }
        return time;



        
    }
}