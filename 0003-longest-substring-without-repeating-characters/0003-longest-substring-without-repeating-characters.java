class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l=0,r=0;
        int sum=0;
        Map<Character,Integer> map = new HashMap<>();

        while(r<s.length()){
            if(map.containsKey(s.charAt(r))) l =Math.max(l,map.get(s.charAt(r))+1);
            map.put(s.charAt(r),r);
            sum=Math.max(sum,r-l+1);
            r++;}
            return sum;
        
    }
}