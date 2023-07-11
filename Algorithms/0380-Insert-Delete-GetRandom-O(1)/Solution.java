class RandomizedSet {
    private Set<Integer> randomizedSet;
    private List<Integer> elementsList;
    private int counter;

    public RandomizedSet() {
        this.randomizedSet = new HashSet<Integer>();
        this.elementsList = new ArrayList<Integer>();
        this.counter = 0;
    }
    
    public boolean insert(int val) {
        return !exist(val) && randomizedSet.add(val) && elementsList.add(val) && (counter++) >= 0;
    }

    public boolean remove(int val) {
        return exist(val) && randomizedSet.remove(val) && elementsList.remove(Integer.valueOf(val)) && (counter--) >= 0;
    }
    
    public int getRandom() {
        return elementsList.get((int) Math.floor(Math.random() * (counter)));
    }

    private boolean exist(int val) {
        return randomizedSet.contains(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
