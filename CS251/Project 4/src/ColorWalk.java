class colorQueue {
    int[][] Q;
    int size;
    int[][] position; // holds the positions of the edges in the queue

    colorQueue (Graph G) {
        Q = new int[3 * G.graph.length][3];
        position = new int[G.graph.length][3];
        for (int i = 0; i < G.graph.length; i++) {
            position[i][0] = -1; // initialize positions to -1 (not in queue)
            position[i][1] = -1;
            position[i][2] = -1;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int[] edge) { // edge is in the form (vertex, cost)
        Q[size] = edge; // insert edge at the bottom of the heap
        position[edge[0]][edge[2]] = size; // store the position of the vertex in the queue

        int index = size;
        int parent = (index - 1) / 2;
        while (Q[parent][1] > edge[1] && index != 0) { // loop while the edge is not at the root or is larger than the parent
            Q[index] = Q[parent]; // swap the parent and child
            Q[parent] = edge;

            position[Q[parent][0]][Q[parent][2]] = parent; // update the positions in the queue
            position[Q[index][0]][Q[index][2]] = index;

            index = parent; // update the index and parent
            parent = (index - 1) / 2;
        }
        size++; // increase the size of the Q after the new edge is added
    }

    public int[] pop() {
        int[] ret = Q[0];
        Q[0] = Q[size - 1];
        Q[size - 1] = null;
        size--;

        if (Q[0] != null) {
            position[Q[0][0]][Q[0][2]] = 0;
        }
        position[ret[0]][ret[2]] = -1; // set the position to -1 to indicate it is no longer in the queue

        if (size <= 2) { // if the queue has 0, 1, or 2 items just swap the 2 items or return
            if (size == 2 && Q[0][1] > Q[1][1]) {
                int[] temp = Q[0];
                Q[0] = Q[1];
                Q[1] = temp;

                position[Q[0][0]][Q[0][2]] = 0;
                position[Q[1][0]][Q[1][2]] = 1;
            }
            return ret;
        }

        int index = 0;
        int Lchild = 1;
        int Rchild = 2;

        while (Q[index][1] > Q[Lchild][1] || Q[index][1] > Q[Rchild][1]) { // while the parent is less than one of its children
            int[] temp = Q[index];
            if (Q[Lchild][1] < Q[Rchild][1]) { // swap with the left-child
                Q[index] = Q[Lchild];
                Q[Lchild] = temp;

                position[Q[Lchild][0]][Q[Lchild][2]] = Lchild;
                position[Q[index][0]][Q[index][2]] = index;

                index = Lchild;
            } else { // swap with the right-child
                Q[index] = Q[Rchild];
                Q[Rchild] = temp;

                position[Q[Rchild][0]][Q[Rchild][2]] = Rchild;
                position[Q[index][0]][Q[index][2]] = index;

                index = Rchild;
            }

            Lchild = 2 * index + 1; // update the children
            Rchild = 2 * index + 2;

            if (Lchild > (size - 1)) { // if the Lchild is out of bounds then we can exit the while loop
                break;
            }
            if (Rchild > (size - 1)) { // if the Rchild is out of boudn then set it to eqaul the Lchild (does not alter the swapping of the next iteration)
                Rchild = Lchild;
            }
        }
        return ret;
    }

    public void set(int key, int cost, int color) {
        Q[position[key][color]][1] = cost; // update the max value of the edge with the new cost
        int index = position[key][color];
        int parent = (index - 1) / 2;
        while (Q[parent][1] > cost && index != 0) { // loop while the edge is not at the root or is larger than the parent
            int[] temp = Q[index];
            Q[index] = Q[parent]; // swap the parent and child
            Q[parent] = temp;

            position[Q[parent][0]][Q[parent][2]] = parent; // update the positions in the queue
            position[Q[index][0]][Q[index][2]] = index;

            index = parent; // update the index and parent
            parent = (index - 1) / 2;
        }
    }
}

public class ColorWalk {
    static WalkPair[] path;
    static WalkPair[] currentPath;

    public static class WalkPair {
        char startColor;
        int walkWeight;
    }

    public static WalkPair[] colorWalk(Graph G, int start) {
        path = new WalkPair[G.graph.length];
        for (int i = 0; i < path.length; i ++) {
            if (i == start) {
                WalkPair pair = new WalkPair();
                pair.startColor = '-';
                pair.walkWeight = 0;
                path[i] = pair;
            } else {
                WalkPair pair = new WalkPair();
                pair.startColor = '-';
                pair.walkWeight = -1;
                path[i] = pair;
            }
        }

        for (int j = 0; j < 3; j++) { // go through the graph starting with the first edge being red, then green, and finally blue
            currentPath = new WalkPair[G.graph.length];
            for (int i = 0; i < currentPath.length; i ++) {
                if (i == start) {
                    WalkPair pair = new WalkPair();
                    pair.startColor = '-';
                    pair.walkWeight = 0;
                    currentPath[i] = pair;
                } else {
                    WalkPair pair = new WalkPair();
                    pair.startColor = '-';
                    pair.walkWeight = -1;
                    currentPath[i] = pair;
                }
            }
            colorQueue Q = new colorQueue(G);
            for (int i = 0; i < G.graph.length; i++) {
                if (i == start) {
                    if (j == 0) { // if the first edge is red then insert the source as a blue node
                        Q.insert(new int[]{i, 0, 2});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 0});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 1});
                    } else if (j == 1) { // if the first edge is green then insert the source as a red node
                        Q.insert(new int[]{i, 0, 0});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 1});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 2});
                    } else { // if the first node is blue then insert the source as a green node
                        Q.insert(new int[]{i, 0, 1});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 2});
                        Q.insert(new int[]{i, Integer.MAX_VALUE, 0});
                    }
                } else {
                    Q.insert(new int[]{i, Integer.MAX_VALUE, 0}); // insert red vertex
                    Q.insert(new int[]{i, Integer.MAX_VALUE, 1}); // insert green vertex
                    Q.insert(new int[]{i, Integer.MAX_VALUE, 2}); // insert blue vertex
                }
            }

            while (!Q.isEmpty()) {
                int[] edge = Q.pop();
                if (edge[1] == Integer.MAX_VALUE) {
                    break;
                }
                char color;
                if (edge[2] == 2) {
                    color = 'R';
                } else if (edge[2] == 0) {
                    color = 'G';
                } else { color = 'B'; }

                if (edge[0] != start && (currentPath[edge[0]].walkWeight == -1 || currentPath[edge[0]].walkWeight > edge[1])) { // update the path distance if the vertex is not the source and it is less than the current known path
                    currentPath[edge[0]].walkWeight = edge[1];
                    if (j == 0) {
                        currentPath[edge[0]].startColor = 'R';
                    } else if (j == 1) {
                        currentPath[edge[0]].startColor = 'G';
                    } else { currentPath[edge[0]].startColor = 'B'; }
                }

                Node current = G.graph[edge[0]].head.next;
                while (current != null) { // go through adjacent edges
                    if (current.color == color) { // if the adjacent node has a valid color edge
                        int position = Q.position[current.key][((edge[2] + 1) % 3)];
                        if (position != -1 && ((edge[1] + current.weight) < Q.Q[position][1])) { // if the weight of the parent vertex plus the edge weight is less than the known weight of the vertex then update the edge in the queue
                            Q.set(current.key, edge[1] + current.weight, ((edge[2] + 1) % 3));
                        }
                    }
                    current = current.next;
                }
            }

            for (int i  = 0; i < path.length; i++) { // update the best path array if any of the newly discovered paths are shorter
                if ((currentPath[i].walkWeight != -1 && currentPath[i].walkWeight < path[i].walkWeight) || path[i].walkWeight == -1) {
                    path[i] = currentPath[i];
                }
            }
        }
        return path;
    }
}
