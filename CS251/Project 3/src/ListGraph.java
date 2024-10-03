import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;

class Node {
    int key;
    Node next;
    public Node(int key) {
        this.key = key;
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
            System.out.print(node.key + " ");
            node = node.next;
        }
        System.out.println();
    }
}

public class ListGraph {
    linkedList[] graph;

    ListGraph (linkedList[] array) {
        graph = array;
    }

    public static ListGraph read(String filepath) throws IOException {
        System.out.println(filepath);
        InputStream istr = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(istr));

        String line = br.readLine();
        int numNodes = Integer.parseInt(line);

        linkedList[] array = new linkedList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            linkedList nodes = new linkedList();
            line = br.readLine();
            if (!line.isEmpty()) {
                for (String value : line.split(" ")) {
                    Node node = new Node(Integer.parseInt(value));
                    nodes.addNode(node);
                }
            }
            array[i] = nodes;
        }

        ListGraph graph = new ListGraph(array);

        /*
        for (linkedList list : graph.graph) {
            list.print();
        }
         */

        br.close();
        istr.close();
        return graph;
    }
}
