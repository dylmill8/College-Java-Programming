import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {

        /* TESTING */

        // QueuedStack
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        QueuedStack<Integer> QS = new QueuedStack<>(q);

        // check for EmptyStackException on pop() with no elements
        try { QS.pop(); } catch (EmptyStackException e) { 
            System.out.println("EmptyStackException"); }

        // check for EmptyStackException on peek() with no elements
        try { QS.peek(); } catch (EmptyStackException e) { 
            System.out.println("EmptyStackException"); }
        
        // check for empty QueuedStack on QS with no elements
        System.out.println(QS.empty());
        
        // pushing, popping, and peeking elements in the QueueStack
        QS.push(5);
        QS.push(11);
        QS.push(8);
        System.out.printf("%d, %d, %d, %b, %d\n", 
        QS.pop(), QS.peek(), QS.pop(), QS.empty(), QS.pop());



        // StackifiedQueue
        java.util.Stack<Integer> s1 = new java.util.Stack<>();
        java.util.Stack<Integer> s2 = new java.util.Stack<>();
        StackifiedQueue<Integer> SQ = new StackifiedQueue<>(s1, s2);

        // check for null on poll(), peek(), and isEmpty() with no elements
        System.out.printf("%s, %s, %b\n",
        SQ.poll(), SQ.peek(), SQ.isEmpty());
        
        // pushing, popping, and peeking elements in the QueueStack
        SQ.add(5);
        SQ.add(11);
        SQ.add(8);
        System.out.printf("%d, %d, %d, %b, %d\n", 
        SQ.poll(), SQ.peek(), SQ.poll(), SQ.isEmpty(), SQ.poll());



        // NumLinkedList
        NumLinkedList NLL = new NumLinkedList();

        // check for adding nodes to NumLinkedList
        NLL.add(1);
        NLL.add(2);
        NLL.add(3);
        NLL.add(4);
        NLL.add(5);
        NumLinkedList.print(NLL);

        // checking size() and isSorted()
        System.out.printf("%d, %b\n", NLL.size(), NLL.isSorted());

        // checking duplicate() and merge() which retains sorted order
        NumLinkedList NLL2 = NumLinkedList.duplicate(NLL);
        NumLinkedList.print(NLL2);
        NumLinkedList NLL3 = NumLinkedList.merge(NLL, NLL2);
        NumLinkedList.print(NLL3);
        System.out.printf("%d, %b\n", NLL3.size(), NLL3.isSorted());

        // checking reverse() and isSorted() on a descending list
        NLL3.reverse();
        NumLinkedList.print(NLL3);
        System.out.printf("%d, %b\n", NLL3.size(), NLL3.isSorted());
    }

    /* implements a stack using a single queue given as input */
    public static class QueuedStack<T> {
        java.util.Queue<T> q;

        public QueuedStack(java.util.Queue<T> q) {
            this.q = q;
        }

        public T push(T element) {
            q.add(element);
            return element;
        }

        public T pop() {
            if (q.size() < 1) { throw new EmptyStackException(); }
            int len = q.size() - 1;
            for (int i = 0; i < len; i++) {
                q.add(q.remove());
            }
            return q.remove();
        }

        public T peek() {
            if (q.size() < 1) { throw new EmptyStackException(); }
            int len = q.size() - 1;
            for (int i = 0; i < len; i++) {
                q.add(q.remove());
            }
            T ret = q.remove();
            q.add(ret);
            return ret;
        }

        public boolean empty() {
            if (q.size() < 1) { return true; }
            return false;
        }

    }

    /* implements a queue using two stacks given as input */
    public static class StackifiedQueue<T> {
        java.util.Stack<T> s1;
        java.util.Stack<T> s2;

        public StackifiedQueue(java.util.Stack<T> s1, java.util.Stack<T> s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public boolean add(T element) {
            s1.push(element);
            return true;
        }

        public T poll() {
            if (s1.size() < 1) { return null; }
            while (s1.size() > 1) {
                s2.push(s1.pop());

            }
            T ret = s1.pop();
            while (s2.size() > 0) {
                s1.push(s2.pop());
            }
            return ret;
        }

        public T peek() {
            if (s1.size() < 1) { return null; }
            while (s1.size() > 1) {
                s2.push(s1.pop());

            }
            T ret = s1.pop();
            s2.push(ret);
            while (s2.size() > 0) {
                s1.push(s2.pop());
            }  
            return ret;
        }

        public boolean isEmpty() {
            if (s1.size() < 1) { return true; }
            return false;
        }

    }
    
    /* IntegerNode implements a node objects with a value and next pointer */
    public static class IntegerNode {
        int element;
        IntegerNode nextNode = null;

        public void setElement(int val) { this.element = val; }
        public int getElement() { return this.element; }
        public void setNext(IntegerNode node) { this.nextNode = node; }
        public IntegerNode getNext() { return this.nextNode; }

    }

    /* NumLinkedList implements a linked list of node objects that can be 
       added to, checked for size, checked for sorted order, reversed, merged
       with another list, duplicated, and printed in order */
    public static class NumLinkedList {
        IntegerNode head = null;

        public int size() {
            int count = 0;
            IntegerNode temp = this.head;
            while (temp != null) {
                count++;
                temp = temp.getNext();
            }
            return count;
        }

        public void add(int val) {
            IntegerNode node = new IntegerNode();
            node.setElement(val);
            if (head == null) { 
                head = node; 
                return;
            }
            IntegerNode temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }

        public boolean isSorted() {
            IntegerNode temp = this.head;
            while (temp.getNext() != null) {
                if (temp.getElement() > temp.getNext().getElement()) { 
                    return false; 
                }
                temp = temp.getNext();
            }
            return true;
        }

        public void reverse() {
            /* 
             * steps:
             * head points to p1
             * p1 equals head
             * head equals p2
             * p2 equals p2.next 
             */
            if (this.head == null) { return; }
            IntegerNode p1 = null;
            IntegerNode p2 = this.head.getNext();
            while (this.head != null) {
                this.head.setNext(p1);
                p1 = this.head;
                this.head = p2;
                if (p2 != null) { p2 = p2.getNext(); }
            }
            this.head = p1;
        }

        public static NumLinkedList merge(NumLinkedList L1, NumLinkedList L2) {
            NumLinkedList NLL = new NumLinkedList();
            IntegerNode p1 = L1.head;
            IntegerNode p2 = L2.head;
            while (p1 != null && p2 != null) {
                if (p1.getElement() <= p2.getElement()) {
                    NLL.add(p1.getElement());
                    p1 = p1.getNext();
                } else {
                    NLL.add(p2.getElement());
                    p2 = p2.getNext();
                }
            }

            while (p1 != null) { // add rest of L1
                NLL.add(p1.getElement());
                p1 = p1.getNext();
            }
            
            while (p2 != null) { // add rest of L2
                NLL.add(p2.getElement());
                p2 = p2.getNext();
            }

            return NLL;
        }

        public static NumLinkedList duplicate(NumLinkedList L) {
            NumLinkedList NLL = new NumLinkedList();
            IntegerNode p1 = L.head;
            while (p1 != null) {
                NLL.add(p1.getElement());
                p1 = p1.getNext();
            }
            return NLL;
        }

        public static void print(NumLinkedList L) {
            IntegerNode node = L.head;
            while (node != null) {
                System.out.print(node.getElement() + " ");
                node = node.getNext();
            }
            System.out.println();
        }

    }
}