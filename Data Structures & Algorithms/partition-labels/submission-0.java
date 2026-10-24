class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lImap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            lImap.put(s.charAt(i), i);
        }

        int size=0, endPartition=0;

        for(int i=0; i<s.length(); i++){
            
            int endChar = lImap.get(s.charAt(i));
            endPartition = Math.max(endChar, endPartition);
            
            size++;
            if(i == endPartition){
                
                res.add(size);
                size=0;
            }

            
            
        }

        return res;
    }
}
