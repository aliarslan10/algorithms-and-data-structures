package linkedlists.doublelinkedlist;

public class DoubleLinkedListImplementation {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList();
        myLinkedList.add("Ali");
        myLinkedList.add("Arslan");
        myLinkedList.add("Hello");
        myLinkedList.print();
        myLinkedList.removeLastAdded();
        myLinkedList.print();
    }
}

class Node {
    Object value;
    Node next;
    Node previous;

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class MyLinkedList<T> {

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public void add(Object value) {
        Node newNode = new Node(value, null);
        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        }
        head = newNode;
    }

    public void removeLastAdded() {
        head = head.next;
        head.previous = null;
    }

    public void print() {
        Node headNode = head;
        while (headNode != null) {
            System.out.println((T) headNode.value);
            headNode = headNode.next;
        }
    }
}
