class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(new int[]{0,1,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int pos = curr[0];
            int speed = curr[1];
            int moves = curr[2];

            if(pos==target) return moves;

            int nextpos = pos+speed;
            int nextspeed = 2*speed;
            String A = nextpos+","+nextspeed;
            if(!vis.contains(A) && Math.abs(nextpos) < 2*target){
                vis.add(A);
                q.add(new int[]{nextpos,nextspeed,moves+1});
            }

            nextpos = pos;

            nextspeed = speed >0 ?  -1:1;
            String B = nextpos+","+nextspeed;

            if(!vis.contains(B)){
                vis.add(B);
                q.add(new int[]{nextpos,nextspeed,moves+1});
            }

        }
        return -1;
        
    }
}