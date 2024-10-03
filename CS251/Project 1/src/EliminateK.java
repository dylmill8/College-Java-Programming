class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class circLinkedList {
    Node head = null;
    Node tail = null;

    public void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head;
    }

    public void delNode(Node node) {
        Node current = head;
        do {
            if(current.next.value == node.value) { //delete node
                if (tail == head) { //case where there is only one element
                    head = null;
                    tail = null;
                } else {
                    if (head == current.next) { //fix head pointer after deletion
                        head = head.next;
                    } else if (tail == current.next) { //fix tail pointer after deletion
                        tail = current;
                    }
                    current.next = current.next.next;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    public int eliminateK(int k) {
        int counter = 1;
        Node node = head;
        while (head != tail) { //if head = tail then only one element left
            //this.print();
            //System.out.println("counter: " + counter + " k: " + k);
            if (counter == k) {
                Node temp = node.next;
                delNode(node);
                node = temp;
                counter = 1;
            } else {
                node = node.next;
                counter++;
            }
        }
        return head.value;
    }

    public void print() {
        Node node = head;
        //System.out.println("Head: " + head.value + " Tail: " + tail.value);
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        do {
            System.out.print(node.value + " ");
            node = node.next;
        } while (node != head);
        System.out.println();
    }
}

public class EliminateK {
    public int computeSurvivor(int n,int k)
    {
        circLinkedList CLL = new circLinkedList();
        for (int i = 1; i < (n + 1); i++) {
            Node node = new Node(i);
            CLL.addNode(node);
        }
        //CLL.print();
        return CLL.eliminateK(k);
    }

    /*
    public static void main(String[] args) {
        EliminateK eliminateK = new EliminateK();
        int output = eliminateK.computeSurvivor(5, 2);
        System.out.println("The survivor was: " + output);
    }
    */
}


