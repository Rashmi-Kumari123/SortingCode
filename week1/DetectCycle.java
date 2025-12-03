package week1;

class ListNode{
    int val;
    ListNode next;
    ListNode(int d){
        val = d;
        next = null;
    }
}

public class DetectCycle {
    public boolean hasCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle dc = new DetectCycle();
        
        System.out.println("Case 1: Linked list with cycle");
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; //  4 -> 2 (having cycle)
        
        boolean result1 = dc.hasCycle(head1);
        System.out.println("Has cycle? " + result1);
        System.out.println();
        
        System.out.println("Case 2: Linked list without cycle");
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        
        head2.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = null; // No cycle
        
        boolean result2 = dc.hasCycle(head2);
        System.out.println("Has cycle? " + result2);
        System.out.println();
    
        System.out.println("Case 3: Single node");
        ListNode head3 = new ListNode(1);
        head3.next = null;
        
        boolean result3 = dc.hasCycle(head3);
        System.out.println("Has cycle? " + result3);
        System.out.println();
        
        System.out.println("Case 4: Single node pointing to itself");
        ListNode head4 = new ListNode(1);
        head4.next = head4; // Points to itself
        
        boolean result4 = dc.hasCycle(head4);
        System.out.println("Has cycle? " + result4);
        System.out.println();
        
        
        System.out.println("Case 5: Empty list (null)");
        ListNode head5 = null;
        
        boolean result5 = dc.hasCycle(head5);
        System.out.println("Has cycle? " + result5);
        System.out.println();
        
       
        System.out.println("Case 6: Two nodes with cycle");
        ListNode head6 = new ListNode(1);
        ListNode node62 = new ListNode(2);
        head6.next = node62;
        node62.next = head6; // 2 -> 1 cycle is found
        
        boolean result6 = dc.hasCycle(head6);
        System.out.println("Has cycle? " + result6);
        
    }
}
