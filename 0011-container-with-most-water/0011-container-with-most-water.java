class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0,r=n-1,ln=Integer.MIN_VALUE;

        

        while(l<r){
            int prod = Math.min(height[l],height[r]) * (r-l);
            ln = Math.max(prod,ln);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return ln;
    }
}