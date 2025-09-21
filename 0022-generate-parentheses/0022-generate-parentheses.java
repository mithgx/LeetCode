class Solution {
    public List<String> generateParenthesis(int n) {
        

        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    private void backtrack(List<String> res , String a, int open , int close, int n){


        if(open==n && close == n){
            res.add(a);
            return;
        }
        if(open<n) backtrack(res,a+"(",open+1,close,n);
        if(close<open) backtrack(res,a+")",open,close+1,n);
    }
}