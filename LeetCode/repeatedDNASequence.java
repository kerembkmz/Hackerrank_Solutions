class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> returnList = new ArrayList<>();

        Map<String, Integer> lettermap = new HashMap<>();
        for (int i=0; i<=s.length()-10; i++){
            String sequence = s.substring(i, i + 10);
            if (lettermap.containsKey(sequence)){
                if (lettermap.get(sequence) == 1)
                    returnList.add(sequence);
                lettermap.put(sequence, lettermap.get(sequence) + 1);
            }
            else{
                lettermap.put(sequence, 1);
            }
        }

        return returnList;
    }
}