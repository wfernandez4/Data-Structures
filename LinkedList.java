class LinkedList {
    Node head;
    // Empty LinkedList constructor
    LinkedList() {
        head = null;
    }
    // Passing the head node to the LinkedList
    LinkedList(Node node) {
        head = node;
    }
    // Checks of the list is empty O(1)
    static boolean checkIfEmpty(LinkedList list) {
        return list.head == null;
    } 
    // Prints the LinkedList O(n)
    static void printLinkedList(LinkedList list) {
        if (list.head == null) { 
            System.out.println("Linked List is empty.");
            return;
        }
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    // Inserts a node at the beginning of the list O(1)
    static void insertNewHead(LinkedList list, Node node) {
        node.next = list.head;
        list.head = node;
    }
    // Appends a node to the end of the list O(n)
    static void appendNode(LinkedList list, Node node) {
        if (list.head == null) {
            list.head = node;
        } else {
            Node currentNode = list.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }
    // Inserts a node after the given pointer to a Node O(1)
    static void insertNode(Node node, Node newNode) {
        Node temp = node.next;
        node.next = newNode;
        newNode.next = temp;
    }
    // Deletes a Node in a LinkedList with the matching value O(n)
    static void deleteNode(LinkedList list, int key) {
        if (checkIfEmpty(list)) {
            System.out.println("List is empty.");
        } else {
            Node currentNode = list.head;
            Node previousNode = null;
            if (currentNode.data == key) {
                list.head = list.head.next;
                return;
            } else {
                while (currentNode.data != key && currentNode.next != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            
            if (currentNode.data == key) previousNode.next = currentNode.next;
            else return; 
        }
    }

    static class Node {
        int data;
        Node next;
        // Constructor for Node
        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        appendNode(ll, node1);
        appendNode(ll, node2);
        appendNode(ll, node4);
        printLinkedList(ll);
        insertNewHead(ll, node0);
        printLinkedList(ll);
        insertNode(node2, node3);
        printLinkedList(ll);
        deleteNode(ll, 3);
        printLinkedList(ll);
        deleteNode(ll, 0);
        printLinkedList(ll);
        deleteNode(ll, 4);
        printLinkedList(ll);
        deleteNode(ll, 1);
        printLinkedList(ll);
        deleteNode(ll,2);
        printLinkedList(ll);
    }
}

