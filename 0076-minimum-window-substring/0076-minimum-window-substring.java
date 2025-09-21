class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()) return "";
        int[] freq= new int[256];
        int l=0;
        int cnt=0;
        int min = Integer.MAX_VALUE;   
        int sindex=-1;

        for(char c : t.toCharArray()){
            freq[c]++;
            }

        for(int r =0;r<s.length();r++){
            if(freq[s.charAt(r)] >0) cnt++;
            freq[s.charAt(r)]--;

            while(cnt==t.length()){
                if(r-l+1 < min){
                    min = r-l+1;
                    sindex=l;
                }

                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] >0) cnt--;
                l++;
            }
            }
        if(sindex==-1) return "";
        return s.substring(sindex,sindex+min);    
    }
}