public class MaxWeight {
    static boolean[] visited;

    public static int[] recursiveChain(Graph G, int v) {
        visited[v] = true;
        int[] pathWeight = new int[3];
        Node current = G.graph[v].head.next;
        while (current != null) {
            if (!visited[current.key]) {
                pathWeight = recursiveChain(G, current.key);
            }
            current = current.next;
        }

        int maxOut = Math.max(pathWeight[1], pathWeight[2]);
        pathWeight[2] = pathWeight[1]; // out2(u) = out1(v)
        pathWeight[1] = pathWeight[0]; // out1(u) = in(v)
        pathWeight[0] = G.graph[v].head.weight + maxOut; // in(u) = weight(u) + max{out1(v), out2(v)}

        return pathWeight;
    }

    public static int[] recursiveTree(Graph G, int v) {
        visited[v] = true;
        int[] pathWeight = new int[4];
        Node current = G.graph[v].head.next;
        while (current != null) {
            if (!visited[current.key]) {
                int[] subtreeWeight = recursiveTree(G, current.key);
                pathWeight[0] = Math.max(Math.max(Math.max(Math.max(pathWeight[0], subtreeWeight[0]), pathWeight[1] + Math.max(subtreeWeight[2], subtreeWeight[3])), pathWeight[2] + Math.max(subtreeWeight[1], subtreeWeight[2])), pathWeight[3] + subtreeWeight[1]); // L2
                pathWeight[1] = Math.max(pathWeight[1], G.graph[v].head.weight + Math.max(subtreeWeight[2], subtreeWeight[3])); // L1.in(u) = max {L1.in(u), w(u) + max {L1.out1(vi), L1.out2(vi)}}
                pathWeight[2] = Math.max(pathWeight[2], subtreeWeight[1]); // L1.out1(u) = max {L1.out1(u), L1.in(vi)}
                pathWeight[3] = Math.max(pathWeight[3], subtreeWeight[2]); // L1.out2(u) = max {L1.out2(u), L1.out1(vi)}
            }
            current = current.next;
        }

        if (pathWeight[1] == 0) { // base case
            pathWeight[1] = G.graph[v].head.weight; // (L2, L1.in, L1.out1, L1.out2) = (0, w(v), 0, 0)
        }

        return pathWeight;
    }

    public static int maxWeightChain(Graph G) {
        int v = -1;
        for (int i = 0; i < G.graph.length; i++) { // find one of the leaves
            if (G.graph[i].getLength() == 2) { // if there are only 2 adjacent nodes (itself included) then it is one of the leaves
                v = i;
                break;
            }
        }

        visited = new boolean[G.graph.length];
        int[] maxPaths = recursiveChain(G, v);
        int max = Math.max(maxPaths[0], maxPaths[1]);
        max = Math.max(max, maxPaths[2]);
        return max;
    }

    public static int maxWeightTree(Graph G) {
        visited = new boolean[G.graph.length];
        int[] maxPaths = recursiveTree(G, 0);
        int max = Math.max(Math.max(Math.max(maxPaths[0], maxPaths[1]), maxPaths[2]), maxPaths[3]);
        return max;
    }
}
