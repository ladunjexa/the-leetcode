class LRUCache {

    private Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;  
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
            
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            if(cache.size() == capacity)
                cache.remove(cache.keySet().toArray(new Integer[1])[0]);
        } else
            cache.remove(key);
        
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
