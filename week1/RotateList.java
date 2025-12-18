class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//  Algorithm that I am using is this:
    // firstly find the length and tail node to know where the list ends
    // Make the list circular - connect tail to head so that we can easily find new positions
    // Find the new tail node - it's at position (len - k) from original head
    // Break the circle at new tail - set new tail's next to null, new head is its next

public class RotateList {
    private static ListNode findNthNode(ListNode head, int k) {
        int count = 1;
        while (head != null) {
            if (count == k) return head;  // Finding the k-th node
            head = head.next;
            count++;
        }
        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        if (k % len == 0) return head; // remain as it is
        k = k % len;
        tail.next = head;// doing this so that easily find the new head and tail positions when list turns circular
        ListNode newLastNode = findNthNode(head, len - k);// Finding the new tail node (at position len - k from original head)
        head = newLastNode.next;  // New head is the node after new tail
        newLastNode.next = null;  // Break the circle to make it a normal list again
        return head;
    }

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
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Ex-> 1: Rotate [1, 2, 3, 4, 5] to the right by 2
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(arr1);
        System.out.print("Original List: ");
        printList(head1);
        System.out.println("Rotating right by 2");
        ListNode result1 = rotateRight(head1, 2);
        System.out.print("After rotation: ");
        printList(result1);
        System.out.println();

        // Ex ->2: Rotate [0, 1, 2] to the right by 4
        int[] arr2 = {0, 1, 2};
        ListNode head2 = createList(arr2);
        System.out.print("Original List: ");
        printList(head2);
        System.out.println("Rotating right by 4 (4 % 3 = 1)");
        ListNode result2 = rotateRight(head2, 4);
        System.out.print("After rotation: ");
        printList(result2);
    }
}

