/* What are LinkedLists good for?
 * LinkedLists are good because of their efficient insertion and deletion times.
 * If we have a pointer to a Node in a LinkedList, we can effectively insert and delete elements in O(1) time.
 * LinkedLists have uses for stacks, queues, and other abstract data structures. Can represent trees and graphs.
 * Other characteristics:
 * Dynamic memory allocation, sparse matrices, manipulation of polynomials, performing arithmetic operations on long integers, finding paths in networks.
 * Applications:
 * Music players, browsing between web pages, image viewers, switching between two applications (circular), version control (doubly linked).
 * Disadvantages:
 * Uses more memory for pointers, searching for elements is costly (lookup in arrays is O(1)), reverse traversing in singly LinkedLists is not possible,
 * data is not stored in contiguous locations in memory, random access is not allowed.
  */

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
    // Iteratively counts the nodes in a LinkedList O(n)
    static void countNodes(LinkedList list) {
        if (checkIfEmpty(list)) System.out.println("The LinkedList is empty.");
        else {
            Node currentNode = list.head;
            int count = 1;
            while (currentNode.next != null) {
                count++;
                currentNode = currentNode.next;
            }
            System.out.println("LinkedList length is: " + count);
        }
    }
    // Helper function for the main recursive method
    // This will handles cases where recursion is not needed
    static void recursivelyCountNodes(LinkedList list) {
        int count = 0;
        if (list.head == null) {
            System.out.println("The LinkedList is empty.");
        } else {
            Node traverseNode = list.head;
            count = recursionCountNodes(list, traverseNode, count);
        }
        System.out.println("LinkedList length is: " + count);
    }
    // Recursive method for counting the Nodes in a Linkedlist O(n)
    static int recursionCountNodes(LinkedList list, Node traversingNode, int count) {
        if (traversingNode == null) { // Base case
            return 0;
        } else { // Recursive case
            return 1 + recursionCountNodes(list, traversingNode.next, count++);
        }
    }
    // Inserts a node at the beginning of the list O(1)
    static void insertNewHead(LinkedList list, Node node) {
        node.next = list.head;
        list.head = node;
    }
    // Appends a node to the end of the list O(n)
    // O(1) time if we keep a pointer to the tail
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
    
    // Helper function for the recursive version of Node deletion
    // This will handle cases where recursion is not needed
    static void deleteNodeRecursively(LinkedList list, int key) {
        if (list.head.data == key) {
            list.head = list.head.next;
        } else if (list.head == null) {
            System.out.println("LinkedList is empty.");
        } else {
            Node prevNode = new Node();
            deleteNodeRecursion(list, key, prevNode, list.head);
        }

    }
    // Recursive function for Node deletion 
    // Time complexity: O(n)
    // Space complexity: O(n)
    static void deleteNodeRecursion(LinkedList list, int key, Node prevNode, Node traversingNode) {
        if (traversingNode == null) { // Base case 1 (It is important to handle this case first)
            return;
        } else if (traversingNode.data == key) { // Base case 2
            prevNode.next = traversingNode.next;
        } else { // Recursive case
            deleteNodeRecursion(list, key, traversingNode, traversingNode.next);
        }
    }

    static class Node {
        int data;
        Node next;

        // Constructor for a Node with a passed value
        Node(int n) {
            data = n;
            next = null;
        }
        // Constructor for an empty Node
        Node() {
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        appendNode(ll, node1);
        appendNode(ll, node2);
        appendNode(ll, node3);
        printLinkedList(ll);
        deleteNodeRecursively(ll, 2);
        printLinkedList(ll);
        countNodes(ll);
        recursivelyCountNodes(ll);
    }
}

