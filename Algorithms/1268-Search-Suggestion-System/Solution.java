class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        List<List<String>> out = new ArrayList<>();

        int left = 0, right = products.length - 1;

        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            while(left <= right && (products[left].length() <= i || products[left].charAt(i) != c))
                left++;
            
            while(left <= right && (products[left].length() <= i || products[right].charAt(i) != c))
                right--;
            
            List<String> it = new ArrayList<>();

            int rem = right - left + 1, rng = Math.min(3, rem);

            for(int j = 0; j < rng; j++)
                it.add(products[left + j]);
            
            out.add(it);
        }

        return out;
    }
}
