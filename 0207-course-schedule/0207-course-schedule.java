class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); 
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;

        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int cnt=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int next : graph.get(curr)){
                indegree[next]--;
                if(indegree[next]==0) q.add(next);
            }
        }
        return cnt==numCourses;


        
    }
}