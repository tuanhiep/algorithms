package tuanhiep.usa.algo.cracking;

public class DetectCycleLinkedList {
    public static void main(String[] args) {

    }

    /**
     * check if LinkedList has a cycle by let 2 car: slow and fast run
     * if 2 car meet again then the cycle exists
     *
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
