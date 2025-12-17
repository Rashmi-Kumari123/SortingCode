class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class mergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
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
        // Example 1: Merge [1, 2, 4] and [1, 3, 4]
        System.out.println("Example 1: Merge Two Sorted Lists");
        System.out.println("==================================");
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);
        ListNode merged1 = mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        printList(merged1);
        System.out.println();

        // Example 2: Merge [2, 5, 7] and [1, 3, 6, 8]
        System.out.println("Example 2: Merge Two Sorted Lists");
        System.out.println("==================================");
        int[] arr3 = {2, 5, 7};
        int[] arr4 = {1, 3, 6, 8};
        ListNode list3 = createList(arr3);
        ListNode list4 = createList(arr4);
        System.out.print("List 1: ");
        printList(list3);
        System.out.print("List 2: ");
        printList(list4);
        ListNode merged2 = mergeTwoLists(list3, list4);
        System.out.print("Merged List: ");
        printList(merged2);
    }
}
