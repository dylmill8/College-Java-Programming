public class DirectedCheck {
    static boolean[] marked;
    static int sink;

    static boolean DFS(ListGraph G, int v, boolean[] path) {
        marked[v] = true;   // Mark the current node as visited
        path[v] = true; // Add the current node to the path
        Node current = G.graph[v].head;
        if (current == null) { sink++; }    //  If the node has no neighbors, it is a sink
        boolean ret = true; // Return true if the DFS was successful (default)
        while (current != null) {   // Iterate through neighbors
            if (ret && !path[current.key]) {    // If the DFS hasn't already found a cycle and the current node is not in the path
                if (!marked[current.key]) { // Recur only if the node hasn't already been checked so we don't revisit nodes and maintain the O(n + m) runtime
                    ret = DFS(G, current.key, path);
                }
            } else {
                return false;   // Return false if cycle found (node is revisited within a path)
            }

            current = current.next;
        }
        path[v] = false;    // Take the current node out of the path when returning to a previous recursive call
        return ret;
    }

    public static int[] computeInDegrees(ListGraph a) {
        int[] friends = new int[a.graph.length];    // Create a variable to hold the count of in-edges to each vertex

        for (int i = 0; i < friends.length; i++) {  // Iterates through all nodes in a
            Node adjacent = a.graph[i].head;
            while (adjacent != null) {  // Iterates through all edges
                friends[adjacent.key]++;    // Increments the count of the respective nodes by 1
                adjacent = adjacent.next;
            }
        }
        return friends;
    }

    public static int[] dagCheck(ListGraph a) {
        sink = 0;
        marked = new boolean[a.graph.length];
        for (int i = 0; i < a.graph.length; i++) {  // Iterate through every node in the graph
            boolean[] path = new boolean[a.graph.length];   // Reset the path each iteration
            if (!marked[i]) {   // Only call DFS on unvisited nodes so each node is only called in DFS once either from the for loop or from a neighbor recurring on it
                boolean DFS = DFS(a, i, path);
                if (!DFS) {
                    return new int[]{-1, -1};   // If there was a cycle found return (-1, -1)
                }
            }
        }

        int source = 0;
        int[] vertices = computeInDegrees(a);    // Compute the in-degree of every vertex in O(n + m)
        for (int inDegree : vertices) {  // Count the number of sources (0 in degree) in O(n)
            if (inDegree == 0) { source++; }
        }

        return new int[]{source, sink};
    }
}
