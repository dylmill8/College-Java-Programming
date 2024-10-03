public class UndirectedCheck {
    static boolean[] marked;

    static boolean DFS(ListGraph G, int v, int parent) {
        marked[v] = true;
        Node current = G.graph[v].head;
        boolean ret = true; // Return true if the DFS was successful (default)
        while (current != null) {   // Iterate through neighbors
            if (current.key != parent) {    // Ignore the parent vertex when checking for cycles
                if (ret && !marked[current.key]) {  // If the DFS has not found a cycle and the neighbor is unvisited
                    ret = DFS(G, current.key, v);
                    current = current.next;
                } else {
                    return false;   // Return false if cycle found
                }
            } else { current = current.next; }
        }
        return ret;
    }

    public static boolean treeCheck(ListGraph a) {
        marked = new boolean[a.graph.length];
        boolean ret = DFS(a, 0, -1);
        for (Boolean vertex : marked) {
            if (!vertex) { return false; }  // Check for unreachable vertices
        }
        return ret;
    }

    public static int countTriangles(MatrixGraph a) {
        int count = 0;
        for (int i = 0; i < a.graph.length; i++) {  // Iterate through all vertices in a
            for (int j = 0; j < a.graph[i].length; j++) {   // Iterate through all neighbors
                if (a.graph[i][j] == 1) {
                    for (int k = 0; k < a.graph[j].length; k++) {   // Iterate through all neighbors again
                        if (a.graph[j][k] == 1 && a.graph[k][i] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count / 6;   // Divide by 6 to account for duplicate edges when counting
    }

    public static double vertexClusterCoeff(ListGraph a, int u) {
        int[] friends = new int[a.graph.length];    // Create a variable to hold the count of in-edges to each vertex

        Node current = a.graph[u].head;
        while (current != null) {   // Iterates through the neighbors of vertex u
            Node adjacent = a.graph[current.key].head;
            while (adjacent != null) {  // Iterates through the adjacency list
                friends[adjacent.key]++;    // Increments the count of the respective nodes by 1
                adjacent = adjacent.next;
            }
            current = current.next;
        }

        double sum = 0;
        current = a.graph[u].head;
        int degree = 1;
        while (current != null) {   // Iterates through the neighbors of vertex u
            sum += friends[current.key];    // Adds the number of in-edges to the sum
            current = current.next;
            degree++;
        }

        if (sum == 0) { return 0; }
        return sum / ((degree - 1) * (degree - 2));
    }

    public static double graphClusterCoeff(ListGraph a) {
        double sum = 0;
        for (int i = 0; i < a.graph.length; i++) {
            sum += vertexClusterCoeff(a, i);
        }
        return sum / a.graph.length;
    }
}
