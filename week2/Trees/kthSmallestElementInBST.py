class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
def kthSmallest(self, root, k):
        self.count = 0
        self.result = None

        def inorder(node):
            if not node or self.result is not None:
                return

            # Left subtree
            inorder(node.left)

            # Visit current node
            self.count += 1
            if self.count == k:
                self.result = node.val
                return

            # Right subtree
            inorder(node.right)

        inorder(root)
        return self.result