package linkedlists.linkedlist.findMaxNegativeEvenNumber;

public class OurLinkedList {

    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(70, null);
        LinkedList node2 = new LinkedList(-2, node1);
        LinkedList node3 = new LinkedList(9, node2);
        LinkedList node4 = new LinkedList(-32, node3);
        LinkedList node5 = new LinkedList(7, node4);
        LinkedList node6 = new LinkedList(-1, node5);
        LinkedList node7 = new LinkedList(5, node6);
        System.out.println(LinkedList.findMaxNegativeEvenNumber(node7));
    }
}

/**
 * Given a linkedlists.linkedlist.findMaxEvenNumber.Node as a linked list!
 * Write a simple method that returns a linkedlists.linkedlist.findMaxEvenNumber.Node with a maximum value less than 0 and even!
 *
 * linkedlists.linkedlist.findMaxEvenNumber.Node: 5 -> -1 -> 7 -> -32 -> 9 -> -2 -> 70
 */

interface Node {
    int getValue();
    Node getNext();
    boolean hasNext();
}

class LinkedList implements Node {

    Node next;
    int value;

    LinkedList(int value, Node next) {
        this.next = next;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return this.getNext() != null;
    }

    public static int findMaxNegativeEvenNumber(Node head) {
        Node current = head;
        int max = 0;
        while(current != null) {

            if (current.getValue() < 0 && current.getValue() % 2 == 0) {
                if (max == 0) {
                    max = current.getValue();
                }

                if (max < current.getValue()) {
                    max = current.getValue();
                }
            }

            current = current.hasNext() ? current.getNext() : null;
        }
        return max;
    }
}