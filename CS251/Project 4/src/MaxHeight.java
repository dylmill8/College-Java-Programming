class Queue {
    int[][] Q;
    int size;
    int[] position; // holds the positions of the edges in the queue

    Queue (Graph G) {
        Q = new int[G.numEdges][2];
        position = new int[G.graph.length];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1; // initialize positions to -1 (not in queue)
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int[] edge) { // edge is in the form (vertex, cost)
        Q[size] = edge; // insert edge at the bottom of the heap
        position[edge[0]] = size; // store the position of the vertex in the queue

        int index = size;
        int parent = (index - 1) / 2;
        while (Q[parent][1] < edge[1] && index != 0) { // loop while the edge is not at the root or is larger than the parent
            Q[index] = Q[parent]; // swap the parent and child
            Q[parent] = edge;

            position[Q[parent][0]] = parent; // update the positions in the queue
            position[Q[index][0]] = index;

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
            position[Q[0][0]] = 0;
        }
        position[ret[0]] = -1; // set the position to -1 to indicate it is no longer in the queue

        if (size <= 2) { // if the queue has 0, 1, or 2 items just swap the 2 items or return
            if (size == 2 && Q[0][1] < Q[1][1]) {
                int[] temp = Q[0];
                Q[0] = Q[1];
                Q[1] = temp;

                position[Q[0][0]] = 0;
                position[Q[1][0]] = 1;
            }
            return ret;
        }

        int index = 0;
        int Lchild = 1;
        int Rchild = 2;

        while (Q[index][1] < Q[Lchild][1] || Q[index][1] < Q[Rchild][1]) { // while the parent is less than one of its children
            int[] temp = Q[index];
            if (Q[Lchild][1] > Q[Rchild][1]) { // swap with the left-child
                Q[index] = Q[Lchild];
                Q[Lchild] = temp;

                position[Q[Lchild][0]] = Lchild;
                position[Q[index][0]] = index;

                index = Lchild;
            } else { // swap with the right-child
                Q[index] = Q[Rchild];
                Q[Rchild] = temp;

                position[Q[Rchild][0]] = Rchild;
                position[Q[index][0]] = index;

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

    public void set(int key, int cost) {
        Q[position[key]][1] = cost; // update the max value of the edge with the new cost
        int index = position[key];
        int parent = (index - 1) / 2;
        while (Q[parent][1] < cost && index != 0) { // loop while the edge is not at the root or is larger than the parent
            int[] temp = Q[index];
            Q[index] = Q[parent]; // swap the parent and child
            Q[parent] = temp;

            position[Q[parent][0]] = parent; // update the positions in the queue
            position[Q[index][0]] = index;

            index = parent; // update the index and parent
            parent = (index - 1) / 2;
        }
    }
}

public class MaxHeight {
    static boolean[] visited;
    static int[] costToAdd;
    static int maxWeight;

    public static int maxHeight(Graph G) {
        visited = new boolean[G.graph.length];
        costToAdd = new int[G.graph.length];
        maxWeight = Integer.MAX_VALUE;
        for (int i = 0; i < costToAdd.length; i++) {
            costToAdd[i] = Integer.MIN_VALUE;
        }
        Queue Q = new Queue(G);

        costToAdd[0] = 0;
        Q.insert(new int[] {0, 0});

        while (!Q.isEmpty()) {
            int[] edge = Q.pop();
            visited[edge[0]] = true;
            if (edge[1] < maxWeight && edge[1] != 0) { // update the minimum value on the maximum spanning tree
                maxWeight = edge[1];
            }

            Node current = G.graph[edge[0]].head.next;
            while (current != null) { // go through adjacent edges
                if (!visited[current.key] && current.weight > costToAdd[current.key]) { // if the edge is not to a visited node and the edge has a greater weight than any previous discovered edges
                    if (Q.position[current.key] != -1) { // if the edge is in the queue
                        Q.set(current.key, current.weight);
                    } else {
                        Q.insert(new int[] {current.key, current.weight});
                    }
                    costToAdd[current.key] = current.weight; // update the new cost
                }
                current = current.next;
            }
        }
        return maxWeight;
    }
}
