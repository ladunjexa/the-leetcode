# Intuition & Approach
The given code implements a data structure called **RandomizedSet**, which maintains a set of unique integers. It supports three main operations: inserting an element, removing an element, and getting a random element from the set.

The class utilizes two primary data structures: a *HashSet* named `randomizedSet` and an *ArrayList* named `elementsList`. The `randomizedSet` stores the unique integers, while the `elementsList` maintains the order of insertion and enables efficient random access.

To insert an element into the set, the `insert` method is called with the value to be inserted. This method checks if the element already exists in the set by calling the private `exist` method. If the element doesn't exist, it adds the element to both the `randomizedSet` and `elementsList` using their respective add methods. Additionally, the `counter` variable is incremented to keep track of the number of elements in the set. *The method returns `true` if the element was successfully inserted*.

The `remove` method is responsible for removing an element from the set. It first checks if the element exists in the set using the `exist` method. If the element is found, it removes the element from both the `randomizedSet` and `elementsList` using their respective remove methods. The `counter` variable is decremented to reflect the updated number of elements. *The method returns `true` if the element was successfully removed*.

The `getRandom` method returns a random element from the set. It achieves this by generating a random index within the range of the current number of elements (`counter`). The `elementsList` is then accessed using this random index, and *the corresponding element is returned*.

The `exist` method simply checks if an element exists in the `randomizedSet` by calling its `contains` method.

# Complexity
- Time complexity: $$O(1)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
this implementation provides constant time complexity for insertion, removal, and getting a random element (`O(1)`). The *HashSet* and *ArrayList* operations used in the implementation have efficient lookup and modification time complexities, enabling the `RandomizedSet` to maintain its functionality effectively.

The space complexity of the given `RandomizedSet` implementation is `O(n)`, where `n` is the number of elements stored in the set.
The space usage is primarily attributed to two data structures: the *HashSet* (`randomizedSet`) and the *ArrayList* (*elementsList*).
The *HashSet* `randomizedSet` stores the unique elements inserted into the set. In the worst case, if all elements are unique, the *HashSet* would require `O(n)` space to store them.
The *ArrayList* *elementsList* maintains the order of insertion and allows for efficient random access. It stores the elements in the same order as they are inserted. Hence, it also requires `O(n)` space to store all the elements.
Additionally, there are a few integer variables (*counter*) used to keep track of the number of elements, which require constant space.
Therefore, considering the space requirements of the *HashSet*, *ArrayList*, and integer variables, the overall space complexity is `O(n)`.

# Code
```Java []

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
```
```Java []
class RandomizedSet {
    private Set<Integer> randomizedSet; // Set to store unique integers
    private List<Integer> elementsList; // List to maintain insertion order
    private int counter; // Counter to keep track of number of elements

    public RandomizedSet() {
        this.randomizedSet = new HashSet<Integer>(); // Initialize the set
        this.elementsList = new ArrayList<Integer>(); // Initialize the list
        this.counter = 0; // Initialize counter to 0
    }
    
    public boolean insert(int val) {
        return !exist(val) && randomizedSet.add(val) && elementsList.add(val) && (counter++) >= 0;
        // Insert an element if it doesn't exist, update set, list, and counter
    }

    public boolean remove(int val) {
        return exist(val) && randomizedSet.remove(val) && elementsList.remove(Integer.valueOf(val)) && (counter--) >= 0;
        // Remove an element if it exists, update set, list, and counter
    }
    
    public int getRandom() {
        return elementsList.get((int) Math.floor(Math.random() * (counter)));
        // Get a random element from the list
    }

    private boolean exist(int val) {
        return randomizedSet.contains(val); // Check if an element exists in the set
    }
}
```
