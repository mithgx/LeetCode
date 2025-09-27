class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree =new int[n];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
       
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int cnt=0;
        int[] arr = new int[n];
        while(!q.isEmpty()){
            int curr= q.poll();
            arr[cnt++]=curr;

            for(int x : graph.get(curr)){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        if(cnt==n) return arr;
        return new int[0];
        
    }
        
    }
