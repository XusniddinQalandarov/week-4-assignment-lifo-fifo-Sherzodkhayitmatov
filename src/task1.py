class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.head = None

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def pop(self):
        if self.head is None:
            return None

        data = self.head.data
        self.head = self.head.next
        return data

    def top(self):
        if self.head is None:
            return None

        return self.head.data

    def is_empty(self):
        return self.head is None
