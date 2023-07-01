## Approach: Depth First Search

### Intuition
Because we need to bring everyone to node `0`, we can model the graph as a tree rooted at node `0` (the problem statement hints at this by stating that the network forms a tree structure). We can imagine that in order to move from any node to the root, all edges must be directed from a child to its parent. If there is an edge from a parent node to its child node, no node in the subtree of the child can reach the root node. This edge must be flipped.

Let's take a visual example to understand this.

![img](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/Figures/1466/1466-2.png)

**So, our task is to count the number of edges in a tree rooted at node '0' that are directed from the parent node to a child node.**

We must traverse the entire tree to determine the number of such edges that are directed from the parent to the child node. To traverse the tree, we can use a graph traversal algorithm such as depth-first search (DFS).

In DFS, we use a recursive function to explore nodes as far as possible along each branch. Upon reaching the end of a branch, we backtrack to the previous node `a` and continue exploring the next branches.

Once we encounter an unvisited node, we will take one of its neighbor nodes (if exists) as the next node on this branch. Recursively call the function to take the next node `a` as the 'starting node' and solve the subproblem.

The caveat is that our edges are directed. To count the number of edges that are directed from a parent to its child node, we must traverse the entire tree. If there is an edge from a child to its parent node, we will be unable to reach the child from the parent.

To traverse the entire tree, we must find a way to get from node `0` to all of the nodes in any case. This is possible if the edges are treated as undirected. We add an opposite edge from node `b` to node `a` for every given edge in `connections` from node `a` to node `b`. Let us refer to the edge we added as an "artificial" edge and the edge present in `connections` as an "original" edge.

If we use an "artificial" edge to move from the parent node to the child node, we know that the original edge is directed from the child node to the parent node. We don't need to flip the "original" edge.

If we use an "original" edge to move from the parent node to the child node, it means we need to flip this edge. Whenever we encounter such an edge, we will increment our answer variable by `1`.

We can distinguish between an "original" and an "artificial" edge in many different ways (assigning booleans, specific numbers, etc.). In this article, we will associate an extra value with each edge - `1` for "original" edges and `0` for "artificial" edges.

We also set an answer variable `count = 0` to count the number of edges that must be flipped. Now we start a DFS from node `0` and work our way down the tree (from parent to child). If we come across an "original" edge during the traversal, that is, an edge labeled with a `1`, we increase the `count` by one. We don't modify `count` if we come across an "artificial" edge. We can combine these two operations and perform `count += sign` where `sign` is either `0` or `1` indicating an "artificial" or "original" edge.

We have our answer in `count` at the end of the traversal.

### Algorithm
1. Create an integer variable `count` to count the number of edges that must be flipped. We initialize it with `0`.
2. Create an adjacency list `adj` that contains a list of pairs of integers such that `adj[node]` contains all the neighbors of `node` in the form of `(neighbor, sign)` where `neighbor` is the neighboring node of node `a` and `sign` denotes the direction of the edge i.e., whether its an "original" or "artificial" edge.
3. Start a `DFS` traversal.
   1. We use a function `DFS` to perform the traversal. For each call, pass `node, parent, adj` as the parameters. We start with node `0` and parent as `-1`.
   2. Iterate over all the children of the `node` (nodes that share an edge) using `adj[node]`. For every `child, sign` in `adj[node]`, check if `child` is equal to `parent`. If `child` is equal to `parent`, we will not visit it again.
   3. If `child` is not equal to `parent`, we perform `count += sign` and recursively call the `DFS` with `node = child` and `parent = node`. At the end of the `DFS` traversal, we have the total edges that are required to be flipped in `count`.
4. Return `count`.

### Implementation

#### Java

```java
class Solution {
    int count = 0;

    public void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            return;
        }
        for (List<Integer> nei : adj.get(node)) {
            int child = nei.get(0);
            int sign = nei.get(1);
            if (child != parent) {
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[0], 0));
        }
        dfs(0, -1, adj);
        return count;
    }
}
```

#### C++

```cpp
class Solution {
public:
    int count = 0;
    void dfs(int node, int parent, vector<vector<pair<int, int>>>& adj) {
        for (auto& [child, sign] : adj[node]) {
            if (child != parent) {
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& connection : connections) {
            adj[connection[0]].push_back({connection[1], 1});
            adj[connection[1]].push_back({connection[0], 0});
        }
        dfs(0, -1, adj);
        return count;
    }
};
```
