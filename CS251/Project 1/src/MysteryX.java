class MysteryX {
    Node head = null;
    Node tail = null;

    private class Node {
        int value;
        Node next = null;
        Node prev = null;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertFront(int value) {
        Node node = new Node(value);
        if (tail == null) {
            tail = node;
            node.next = node;
            node.prev = node;
        } else {
            node.next = head;
            node.prev = head.prev;
            tail.next = node;
            head.prev = node;
        }
        head = node;
    }

    public void insertRear(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.next = node;
            node.prev = node;
        } else {
            node.next = tail.next;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
        }
        tail = node;
    }

    public int deleteFront() {
        if (head == null) {
            return -1;
        }
        int value;
        value = head.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }
        return value;
    }

    public int deleteRear() {
        if (tail == null) {
            return -1;
        }
        int value;
        value = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = tail.next;
            tail.next.prev = tail.prev;
            tail = tail.prev;
        }
        return value;
    }

    public int getFront() {
        if (head == null) {
            return -1;
        }
       return head.value;
    }

    public int getRear() {
        if (tail == null) {
            return -1;
        }
        return tail.value;
    }

    public void print() {
        Node node = head;
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        do {
            //System.out.print(node.value + " ");
            System.out.println("value: "+node.value+" next: "+node.next.value+" prev: "+node.prev.value);
            node = node.next;
        } while (node != head);
        System.out.println();
    }

    /*
    public static void main(String[] args) {
        MysteryX x = new MysteryX();
        x.insertFront(5);
        x.insertRear(6);
        x.insertFront(7);
        x.print();
        System.out.println(x.getFront());
        System.out.println(x.getRear());
        System.out.println(x.deleteFront());
        System.out.println(x.deleteRear());
        x.print();
    }
    */
}

