class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // A = head
        // B = head.next
        // C = head.next.next
        // A-> B-> C ->............
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
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
        // Example 1: Swap pairs in [1, 2, 3, 4]
        int[] arr1 = {1, 2, 3, 4};
        ListNode head1 = createList(arr1);
        System.out.print("Original List: ");
        printList(head1);
        ListNode result1 = swapPairs(head1);
        System.out.print("After swapping pairs: ");
        printList(result1);
        System.out.println();

        // Example 2: Swap pairs in [1, 2, 3, 4, 5]
        int[] arr2 = {1, 2, 3, 4, 5};
        ListNode head2 = createList(arr2);
        System.out.print("Original List: ");
        printList(head2);
        ListNode result2 = swapPairs(head2);
        System.out.print("After swapping pairs: ");
        printList(result2);
    }
}

