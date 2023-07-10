class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> hash = new HashMap<String, List<String>>();

        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sSorted = new String(ch);

            if(!hash.containsKey(sSorted))
                hash.put(sSorted, new ArrayList<>());
            
            hash.get(sSorted).add(s);
        }

        for(List<String> anagramSet : hash.values())
            result.add(anagramSet);

        return result;
    }
}
