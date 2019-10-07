package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

import java.util.LinkedList;

public class DetectCycleLinkedList extends abstractAlgo {
    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    /**
     * check if LinkedList has a cycle by let 2 car: slow and fast run
     * if 2 car meet again then the cycle exists
     * @param head
     * @return
     */
    public boolean detectCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
