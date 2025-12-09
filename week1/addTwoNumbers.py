class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1, l2):
    dummy = ListNode()
    curr = dummy
    carry = 0

    while l1 or l2 or carry:
        v1 = l1.val if l1 else 0
        v2 = l2.val if l2 else 0

        val = v1 + v2 + carry  # New digit
        carry = val // 10
        val = val % 10
        curr.next = ListNode(val)

        curr = curr.next   #update pointers
        l1 = l1.next if l1 else None 
        l2 = l2.next if l2 else None
    return dummy.next

# Helper function to create linked list from list of digits
def createList(digits):
    if not digits:
        return None
    head = ListNode(digits[0])
    curr = head
    for digit in digits[1:]:
        curr.next = ListNode(digit)
        curr = curr.next
    return head

# Helper function to print linked list
def printList(head):
    result = []
    while head:
        result.append(str(head.val))
        head = head.next
    print(" -> ".join(result))

# Helper function to convert linked list to number (for display)
def listToNumber(head):
    digits = []
    while head:
        digits.append(str(head.val))
        head = head.next
    return "".join(digits[::-1])  # Reverse because numbers are stored in reverse

if __name__ == "__main__":
    # Case 1: 342 + 465 = 807
    # l1 = [2,4,3] represents 342 (stored in reverse)
    # l2 = [5,6,4] represents 465 (stored in reverse)
    print("Case 1: Add 342 + 465 = 807")
    l1 = createList([2, 4, 3])
    l2 = createList([5, 6, 4])
    print("List 1: ", end="")
    printList(l1)
    print("List 2: ", end="")
    printList(l2)
    result1 = addTwoNumbers(l1, l2)
    print("Result: ", end="")
    printList(result1)
    print(f"Verification: {listToNumber(l1)} + {listToNumber(l2)} = {listToNumber(result1)}")
    print()
    
    # Case 2: 0 + 0 = 0
    print("Case 2: Add 0 + 0 = 0")
    l3 = createList([0])
    l4 = createList([0])
    print("List 1: ", end="")
    printList(l3)
    print("List 2: ", end="")
    printList(l4)
    result2 = addTwoNumbers(l3, l4)
    print("Result: ", end="")
    printList(result2)
    print()
    
    # Case 3: 9999999 + 9999 = 10009998
    # l1 = [9,9,9,9,9,9,9] represents 9999999
    # l2 = [9,9,9,9] represents 9999
    print("Case 3: Add 9999999 + 9999 = 10009998")
    l5 = createList([9, 9, 9, 9, 9, 9, 9])
    l6 = createList([9, 9, 9, 9])
    print("List 1: ", end="")
    printList(l5)
    print("List 2: ", end="")
    printList(l6)
    result3 = addTwoNumbers(l5, l6)
    print("Result: ", end="")
    printList(result3)
    print()
    
    # Case 4: 123 + 456 = 579
    print("Case 4: Add 123 + 456 = 579")
    l7 = createList([3, 2, 1])
    l8 = createList([6, 5, 4])
    print("List 1: ", end="")
    printList(l7)
    print("List 2: ", end="")
    printList(l8)
    result4 = addTwoNumbers(l7, l8)
    print("Result: ", end="")
    printList(result4)
    print()
    
    # Case 5: Different length lists
    print("Case 5: Add 12 + 345 = 357")
    l9 = createList([2, 1])
    l10 = createList([5, 4, 3])
    print("List 1: ", end="")
    printList(l9)
    print("List 2: ", end="")
    printList(l10)
    result5 = addTwoNumbers(l9, l10)
    print("Result: ", end="")
    printList(result5)