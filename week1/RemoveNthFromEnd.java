class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // Helper method to create a linked list from array
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

    // Helper method to print linked list
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
        // Example 1: Remove 2nd node from end from [1, 2, 3, 4, 5]
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(arr1);
        System.out.print("Original List: ");
        printList(head1);
        System.out.println("Removing 2nd node from end");
        ListNode result1 = removeNthFromEnd(head1, 2);
        System.out.print("List after removal: ");
        printList(result1);
        System.out.println();

        // Example 2: Remove 1st node from end from [1, 2]
        int[] arr2 = {1, 2};
        ListNode head2 = createList(arr2);
        System.out.print("Original List: ");
        printList(head2);
        System.out.println("Removing 1st node from end");
        ListNode result2 = removeNthFromEnd(head2, 1);
        System.out.print("List after removal: ");
        printList(result2);
    }
}
