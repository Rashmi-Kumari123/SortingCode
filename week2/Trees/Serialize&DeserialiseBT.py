from collections import deque
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""

        q = deque([root])
        res = []

        while q:
            node = q.popleft()
            if not node:
                res.append("n")
                continue
            res.append(str(node.val))
            q.append(node.left)
            q.append(node.right)

        return " ".join(res)
        

def deserialize(self, data):
    """Decodes your encoded data to tree.
    :type data: str
    :rtype: TreeNode
    """
    if not data:
        return None

    values = data.split()
    root = TreeNode(int(values[0]))
    q = deque([root])
    i = 1

    while q and i < len(values):
        parent = q.popleft()

        # left child
        if values[i] != "n":
            left = TreeNode(int(values[i]))
            parent.left = left
            q.append(left)
        i += 1

        # right child
        if i < len(values) and values[i] != "n":
            right = TreeNode(int(values[i]))
            parent.right = right
            q.append(right)
        i += 1

    return root