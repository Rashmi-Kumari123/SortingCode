## Main concept I am using that reversing chunk by chunk and using recursion to stich them.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseKGroup(head, k):
    if head is None:  return None
    count = 0  # Checking if at least k nodes remain
    temp = head
    while temp and count < k:
        temp = temp.next
        count += 1
    if count < k:
        return head  # Not enough nodes to reverse, I am returning head as it is

    # Reversing block of k nodes
    prev = None
    curr = head
    next_node = None
    count = 0
    while curr and count < k:
        next_node = curr.next
        curr.next = prev
        prev = curr
        curr = next_node
        count += 1

    # Recursively reversing next group and connecting
    if next_node:
        head.next = reverseKGroup(next_node, k)

    return prev

def createList(arr):
    if not arr:
        return None
    head = ListNode(arr[0])
    current = head
    for i in range(1, len(arr)):
        current.next = ListNode(arr[i])
        current = current.next
    return head

def printList(head):
    current = head
    values = []
    while current:
        values.append(str(current.val))
        current = current.next
    print(" -> ".join(values))

if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 7, 8]
    head = createList(arr)
    print(f"Original List: ", end="")
    printList(head)
    print(f"Reversing in groups of k = 3")
    result = reverseKGroup(head, 3)
    print(f"After reversing: ", end="")
    printList(result)
    print("\nExplanation:")
    print("  Original: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8")
    print("  Group 1 (k=3): 3 -> 2 -> 1")
    print("  Group 2 (k=3): 6 -> 5 -> 4")
    print("  Remaining: 7 -> 8 (less than k, keep as is)")
    print("  Result: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8")

