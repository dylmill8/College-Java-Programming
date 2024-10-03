import javax.xml.transform.dom.DOMLocator;

public class SumTwoNumbers {

    public Node num1_list; //Head of first number list
    public Node num2_list; //Head of second number list

    public class Node {
        int key;
        Node previous,next;
        public Node(int key) {
            this.key = key;
            this.previous = null;
            this.next = null;
        }
    }

    public class dblLinkedList {
        Node head = null;
        Node tail = null;

        public void addNode(Node node) {
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.previous = tail;
            }
            tail = node;
        }

        public void print() {
            Node node = head;
            //System.out.println("Head: " + head.value + " Tail: " + tail.value);
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

    public class linkedList {
        Node head = null;

        public void addNode(Node node) {
            node.next = head;
            head = node;
        }

        public void print() {
            Node node = head;
            //System.out.println("Head: " + head.value + " Tail: " + tail.value);
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

    public Node add(String num1, String num2) {
        dblLinkedList DLL1 = new dblLinkedList(); //List 1
        dblLinkedList DLL2 = new dblLinkedList(); //List 2
        for (int i = 0; i < num1.length(); i++) { //Create List 1 from num1
            int digit = Integer.parseInt(String.valueOf(num1.charAt(i)));
            Node node = new Node(digit);
            DLL1.addNode(node);
        }
        for (int i = 0; i < num2.length(); i++) { //Create list 2 from num2
            int digit = Integer.parseInt(String.valueOf(num2.charAt(i)));
            Node node = new Node(digit);
            DLL2.addNode(node);
        }
        num1_list = DLL1.head; //Store head of List 1 in class variable
        num2_list = DLL2.head; //Store head of List 2 in class variable
        //DLL1.print();
        //DLL2.print();

        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        Node current1 = DLL1.tail;
        Node current2 = DLL2.tail;
        linkedList LL = new linkedList();
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            if (current1 == null) {
                val1 = 0;
            } else {
                val1 = current1.key;
            }
            if (current2 == null) {
                val2 = 0;
            } else {
                val2 = current2.key;
            }

            //System.out.println("val1: " + val1 + " val2: " + val2 + " carry: " + carry);
            Node node = new Node((val1 + val2 + carry) % 10);
            LL.addNode(node);

            if (val1 + val2 + carry < 10) { //calculate the carry for the next iteration
                carry = 0;
            } else {
                carry = 1;
            }

            if (current1 != null) {
                current1 = current1.previous;
            }
            if (current2 != null) {
                current2 = current2.previous;
            }
        }
        //LL.print();
        return LL.head;
    }

    /*
    public static void main(String[] args) {
        SumTwoNumbers sum = new SumTwoNumbers();
        Node test1 = sum.add("856", "99");
        Node test2 = sum.add("123", "456");
    }
    */
}
