from ast import main

class LinkedList:

    def __init__(self, node):
        self.head = node
    
    def isListEmpty(self):
        return self.head == None

    def printLinkedList(self):
        if self.head == None:
            return True
        return False

class Node:
    def __init__(self, n):
        self.data = n
        self.next = None; 
    

if __name__ == '__main__':
    node1 = Node(1)
    list = LinkedList(node1)
    print(list.printLinkedList())


