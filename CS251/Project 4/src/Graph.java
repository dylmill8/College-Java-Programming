import java.io.IOException;
import java.io.File;
import java.util.Scanner;

class Node {
    int key;
    int weight;
    char color;
    Node next;

    public Node(int key, int weight) {
        this.key = key;
        this.weight = weight;
        this.next = null;
    }
}

class linkedList {
    Node head = null;
    int length = 0;

    public void addNode(Node node) {
        if (head == null) {
            node.next = head;
            head = node;
            length++;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            length++;
        }
    }

    public int getLength() {
        return length;
    }

    public void print() {
        Node node = head;
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        while (node != null) {
            System.out.print(node.weight + " ");
            node = node.next;
        }
        System.out.println();
    }
}

public class Graph {
    linkedList[] graph;
    int numEdges;

    Graph (linkedList[] array) {
        graph = array;
    } // constructor for graph with vertices

    Graph (linkedList[] array, int edges) {
        graph = array;
        numEdges = edges;
    } // constructor for graph with edges

    public static Graph readVertexWeights(String filename) throws IOException {
        Scanner input = new Scanner(new File(filename));

        String line = input.nextLine();
        int numNodes = Integer.parseInt(line); // get the number of vertices

        line = input.nextLine();
        String[] weights = line.split(" "); // get the vertex weights in order

        linkedList[] array = new linkedList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            linkedList nodes = new linkedList();
            line = input.nextLine();
            Node node = new Node(i, Integer.parseInt(weights[i])); // add the vertex to its own adjacency list
            nodes.addNode(node);

            if (!line.isEmpty()) {
                for (String value : line.split(" ")) {
                    node = new Node(Integer.parseInt(value), -1); //create new nodes with appropriate keys
                    nodes.addNode(node); // add them to the adjacency list
                }
            }
            array[i] = nodes;
        }
        Graph graph = new Graph(array);

        input.close();
        return graph;
    }

    public static Graph readEdgeWeights(String filename) throws IOException {
        Scanner input = new Scanner(new File(filename));

        String line = input.nextLine();
        String[] split = line.split(" ");
        int numEdges = Integer.parseInt(split[1]);

        linkedList[] array = new linkedList[Integer.parseInt(split[0])]; // linked list the size of the number of vertices
        for (int i = 0; i < Integer.parseInt(split[0]); i++) { // establish an adjacency list for every vertex
            linkedList nodes = new linkedList();
            nodes.addNode(new Node(i, -1)); // add the vertex to its own adjacency list
            array[i] = nodes;
        }

        for (int i = 0; i < numEdges; i++) { // iterate through all edges in the file
            line = input.nextLine();
            split = line.split(" ");
            Node node = new Node(Integer.parseInt(split[1]), Integer.parseInt(split[2])); // represent the edge as an adjacent node with its respective key and edge weight
            array[Integer.parseInt(split[0])].addNode(node); // add edge to the vertex's adjacency list
        }
        Graph graph = new Graph(array, numEdges);

        input.close();
        return graph;
    }

    public static Graph readEdgeColors(String filename) throws IOException {
        Scanner input = new Scanner(new File(filename));

        String line = input.nextLine();
        String[] split = line.split(" ");
        int numEdges = Integer.parseInt(split[1]);

        linkedList[] array = new linkedList[Integer.parseInt(split[0])]; // linked list the size of the number of vertices
        for (int i = 0; i < Integer.parseInt(split[0]); i++) { // establish an adjacency list for every vertex
            linkedList nodes = new linkedList();
            nodes.addNode(new Node(i, -1)); // add the vertex to its own adjacency list
            array[i] = nodes;
        }

        for (int i = 0; i < numEdges; i++) { // iterate through all edges in the file
            line = input.nextLine();
            split = line.split(" ");
            Node node = new Node(Integer.parseInt(split[1]), Integer.parseInt(split[2])); // represent the edge as an adjacent node with its respective key and edge weight
            node.color = split[3].charAt(0);
            array[Integer.parseInt(split[0])].addNode(node); // add edge to the vertex's adjacency list
        }
        Graph graph = new Graph(array, numEdges);

        input.close();
        return graph;
    }
}
