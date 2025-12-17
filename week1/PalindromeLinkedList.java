
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse 2nd half
        ListNode secondHalf = reverse(slow);

        // Compare both halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
        // Example 1: Palindrome list [1, 2, 2, 1]
        System.out.println("Example 1: Palindrome Linked List");
        System.out.println("==================================");
        int[] arr1 = {1, 2, 2, 1};
        ListNode head1 = createList(arr1);
        System.out.print("List: ");
        printList(head1);
        boolean result1 = isPalindrome(head1);
        System.out.println("Is Palindrome: " + result1);
        System.out.println();

        // Example 2: Non-palindrome list [1, 2, 3, 4]
        System.out.println("Example 2: Non-Palindrome Linked List");
        System.out.println("======================================");
        int[] arr2 = {1, 2, 3, 4};
        ListNode head2 = createList(arr2);
        System.out.print("List: ");
        printList(head2);
        boolean result2 = isPalindrome(head2);
        System.out.println("Is Palindrome: " + result2);
        System.out.println();

        // Bonus Example 3: Single element (palindrome)
        System.out.println("Example 3: Single Element");
        System.out.println("=========================");
        int[] arr3 = {5};
        ListNode head3 = createList(arr3);
        System.out.print("List: ");
        printList(head3);
        boolean result3 = isPalindrome(head3);
        System.out.println("Is Palindrome: " + result3);
        System.out.println();

        // Example 4: Odd length palindrome [1, 2, 3, 2, 1]
        System.out.println("Example 4: Odd Length Palindrome");
        System.out.println("=================================");
        int[] arr4 = {1, 2, 3, 2, 1};
        ListNode head4 = createList(arr4);
        System.out.print("List: ");
        printList(head4);
        boolean result4 = isPalindrome(head4);
        System.out.println("Is Palindrome: " + result4);
    }
}
