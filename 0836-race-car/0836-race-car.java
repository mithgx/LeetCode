class Solution {
    public int racecar(int target) {

        Queue<int[]> q =new LinkedList<>();
        Set<String> vis =  new HashSet<>();
        q.offer(new int[]{0,1,0});
        vis.add("0,1");

        while(!q.isEmpty()){
            int[] curr  = q.poll();
            int pos=curr[0];
            int speed=curr[1];
            int moves = curr[2];

            if(pos==target) return moves;

            //accelerate

            int nextpos = pos+speed;
            int nextspeed= speed*2;
            String next = nextpos+","+nextspeed;

            if(!vis.contains(next) && Math.abs(nextpos)<=2*target){
                q.offer(new int[]{nextpos,nextspeed,moves+1});
                vis.add(next);
            }

            //reverse

            nextpos = pos;
            nextspeed = speed>0 ? -1 : 1;
            String B = nextpos+","+nextspeed;
            if(!vis.contains(B)){
                q.offer(new int[]{nextpos,nextspeed,moves+1});
                vis.add(B);
            }
        }
        return -1;
        
    }
}