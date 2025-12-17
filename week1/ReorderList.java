class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Finding the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of LL
        ListNode prev = null, curr = slow.next;
        slow.next = null; // Break the list into two halves
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Merging the two halves using pointer
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
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
        // Example 1: [1, 2, 3, 4]
        System.out.println("Example 1: Reorder List");
        System.out.println("=======================");
        int[] arr1 = {1, 2, 3, 4};
        ListNode head1 = createList(arr1);
        System.out.print("Original List: ");
        printList(head1);
        reorderList(head1);
        System.out.print("Reordered List: ");
        printList(head1);
        System.out.println();

        // Example 2: [1, 2, 3, 4, 5]
        System.out.println("Example 2: Reorder List");
        System.out.println("=======================");
        int[] arr2 = {1, 2, 3, 4, 5};
        ListNode head2 = createList(arr2);
        System.out.print("Original List: ");
        printList(head2);
        reorderList(head2);
        System.out.print("Reordered List: ");
        printList(head2);
    }
}

