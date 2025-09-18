class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int maxfreq=0,l=0,max=0;

        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(r)-'A']);
            int window = r-l+1;
            if(window-maxfreq> k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            window = r-l+1;
            max=Math.max(maxfreq,window);
        }
        return max;

        
    }
}