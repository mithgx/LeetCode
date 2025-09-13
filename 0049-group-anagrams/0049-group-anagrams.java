class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();


        for(String x: strs){
            char[] s = x.toCharArray();
            Arrays.sort(s);
            String b=new String(s);

            if(!map.containsKey(b)) map.put(b,new ArrayList<>());
            map.get(b).add(x);
        }

        return new ArrayList<>(map.values());
        
    }
}