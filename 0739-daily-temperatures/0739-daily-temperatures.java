class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;

        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            int ele = temp[i];
            while(!st.isEmpty() && temp[i] > temp[st.peek()]){
                int idx = st.pop();
                arr[idx] = i-idx;
            } 
            st.push(i);
        }
        return  arr;
        
    }
}