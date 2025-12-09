//count the number of elements in a circular Linked list
// package week1;
class Node {
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
public class countNoOfNodes {
    public static int CountNodes(Node head){
        if (head == null)
            return 0;
        Node temp = head;
        int count = 1;
        while (temp.next != head){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args) {
        // Case 1: Creating a circular linked list with 5 nodes
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = head1; // pointing to head from last address
        
        int count1 = CountNodes(head1);
        System.out.println("Case 1 - Circular list with 5 nodes:");
        System.out.println("Number of nodes: " + count1);
        System.out.println();
        
        // Case 2: Single node circular list
        Node head2 = new Node(10);
        head2.next = head2; // Points to itself
        
        int count2 = CountNodes(head2);
        System.out.println("Case 2 - Single node circular list:");
        System.out.println("Number of nodes: " + count2);
        System.out.println();
        
        // Case 3: Empty list (null)
        Node head3 = null;
        int count3 = CountNodes(head3);
        System.out.println("Case 3 - Empty list (null):");
        System.out.println("Number of nodes: " + count3);
        System.out.println();
    }
}


