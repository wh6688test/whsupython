import collections

Node = collections.namedtuple('Node', ['left', 'right', 'value'])

def contains(root, value):
    if not root:
       return False
    if root.value == value:
       return True 
    if root.value > value:
      return contains(root.left, value)
    if root.value < value:
      return contains(root.right, value)


n1 = Node(value=1, left=None, right=None)
n3 = Node(value=3, left=None, right=None)
n2 = Node(value=2, left=n1, right=n3)
n4 = Node(value=2, left=n1, right=None)

print(contains(n2, 3))
print(contains(n1, 3))
print(contains(n3, 3))
print(contains(n4, 3))
print(contains(n4, 2))
print(contains(n4, 1))
