
package week1;
class ListNode{
    int val;
    ListNode next;
    ListNode(int d){
        val = d;
        next = null;
    }
}
public class ReverseLinkedList {
    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; // Return the new head
    }
    
    // Helper method to print linked list
    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val);
            if (temp.next != null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ReverseLinkedList rvLL = new ReverseLinkedList();
        
        // Case 1: Reverse a linked list with multiple nodes
        System.out.println("Case 1: Reverse linked list [1 -> 2 -> 3 -> 4 -> 5]");
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        
        System.out.print("Original: ");
        printList(head1);
        
        ListNode reversed1 = rvLL.reverseLL(head1);
        System.out.print("Reversed: ");
        printList(reversed1);
        System.out.println();
        
        // Case 2: Reverse a linked list with 2 nodes
        System.out.println("Case 2: Reverse linked list [10 -> 20]");
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        
        System.out.print("Original: ");
        printList(head2);
        
        ListNode reversed2 = rvLL.reverseLL(head2);
        System.out.print("Reversed: ");
        printList(reversed2);
        System.out.println();
        
        // Case 3: Single node
        System.out.println("Case 3: Reverse single node [100]");
        ListNode head3 = new ListNode(100);
        
        System.out.print("Original: ");
        printList(head3);
        
        ListNode reversed3 = rvLL.reverseLL(head3);
        System.out.print("Reversed: ");
        printList(reversed3);
        System.out.println();
        
        // Case 4: Empty list (null)
        System.out.println("Case 4: Reverse empty list (null)");
        ListNode head4 = null;
        
        System.out.print("Original: null");
        System.out.println();
        
        ListNode reversed4 = rvLL.reverseLL(head4);
        if (reversed4 == null){
            System.out.println("Reversed: null");
        } else {
            printList(reversed4);
        }
        System.out.println();
        
        // Case 5: Reverse a longer list
        System.out.println("Case 5: Reverse linked list [5 -> 4 -> 3 -> 2 -> 1]");
        ListNode head5 = new ListNode(5);
        head5.next = new ListNode(4);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(2);
        head5.next.next.next.next = new ListNode(1);
        
        System.out.print("Original: ");
        printList(head5);
        
        ListNode reversed5 = rvLL.reverseLL(head5);
        System.out.print("Reversed: ");
        printList(reversed5);
    }
}
