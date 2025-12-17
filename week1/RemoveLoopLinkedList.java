class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveLoopLinkedList {
    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) return;

        //Detecting loop using Floyd's cycle detection
        ListNode slow = head, fast = head;
        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        // If no loop exists, return
        if (!hasLoop) {
            System.out.println("No loop detected in the linked list");
            return;
        }

        //Find the start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Find the last node of the loop and remove it
        ListNode loopStart = slow;
        ListNode current = loopStart;
        while (current.next != loopStart) {
            current = current.next;
        }
        current.next = null;

        System.out.println("Loop removed successfully");
    }

    // creating helper method to create a linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to create a loop in linked list
    // Creates a loop from last node to node at position 'loopPos'
    public static void createLoop(ListNode head, int loopPos) {
        if (head == null) return;
        
        ListNode loopNode = head;
        ListNode lastNode = head;
        
        // Find the node where loop should start
        for (int i = 0; i < loopPos && loopNode != null; i++) {
            loopNode = loopNode.next;
        }
        
        // Find the last node
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        
        // Create the loop
        lastNode.next = loopNode;
    }

    // Helper method to print linked list (handles loops by limiting iterations)
    public static void printList(ListNode head, int maxNodes) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < maxNodes) {
            System.out.print(current.val);
            if (current.next != null && count < maxNodes - 1) {
                System.out.print(" -> ");
            }
            current = current.next;
            count++;
        }
        if (count >= maxNodes) {
            System.out.print(" -> (loop detected)");
        }
        System.out.println();
    }

    // Helper method to verify loop is removed
    public static void printListWithoutLoop(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: Create a linked list with a loop
        System.out.println("Example: Remove Loop from Linked List");
        System.out.println("=====================================");
        
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createList(arr);
        
        // Create a loop from node 5 to node 2 (position 1)
        createLoop(head, 1);
        
        System.out.print("Linked List with Loop: ");
        printList(head, 10);
        
        // Remove the loop
        removeLoop(head);
        
        System.out.print("Linked List after removing loop: ");
        printListWithoutLoop(head);
    }
}

