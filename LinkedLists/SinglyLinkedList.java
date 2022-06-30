import java.util.HashSet;
import java.util.List;
import java.math.*;

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

    // LinkedList constructor with no arguments
    LinkedList() {
        head = null;
    }

    // LinkedList constructor with head node argument
    LinkedList(Node node) {
        head = node;
    }

    // Checks of the list is empty
    static boolean checkIfEmpty(LinkedList list) {
        return list.head == null;
    } 

    // Return the LinkedList with a new head according to the index
    static LinkedList chopLinkedList(LinkedList list, int index) {
        Node currentNode = list.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        list.head = currentNode;
        return list;
    }

    // Prints the LinkedList
    static void printLinkedList(LinkedList list) {
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Prints the LinkedList with a given node
    static void printNodes(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Inserts a node at the beginning of the list
    static void insertNewHead(LinkedList list, Node node) {
        node.next = list.head;
        list.head = node;
    }

    // Appends a node to the end of the list
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
   
    // Iteratively counts the nodes in a LinkedList
    static int countNodes(LinkedList list) {
        if (checkIfEmpty(list)) return 0;
            Node currentNode = list.head;
            int count = 1;
            while (currentNode.next != null) {
                count++;
                currentNode = currentNode.next;
            }
            return count;
    }

    // Helper function for the main recursive method
    static void recursivelyCountNodes(LinkedList list) {
        Node traverseNode = list.head;
        int count = recursionCountNodes(list, traverseNode);
        System.out.println("LinkedList length is: " + count);
    }

    // Recursive method for counting the Nodes in a Linkedlist
    static int recursionCountNodes(LinkedList list, Node traversingNode) {
        if (traversingNode == null) { // Base case
            return 0;
        } else { // Recursive case
            return 1 + recursionCountNodes(list, traversingNode.next);
        }
    }

    // Inserts a node after the given pointer to a Node
    static void insertNode(Node node, Node newNode) {
        Node temp = node.next;
        node.next = newNode;
        newNode.next = temp;
    }
    
    // Deletes a Node in a LinkedList with the matching value
    static void deleteNode(LinkedList list, int key) {
        if (checkIfEmpty(list)) {
            System.out.println("The LinkedList is empty.");
        } else if (list.head.data == key) {
            list.head = list.head.next;
            System.out.println("List is now empty.");
        } else {
            Node previousNode = list.head;
            Node currentNode = list.head.next;
            while (currentNode != null) {
                if (currentNode.data == key) {
                    previousNode.next = currentNode.next;
                    System.out.println("Node with value " + key + " deleted.");
                    return;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
    }
    
    // Helper function for the recursive version of Node deletion
    // This will handle cases where recursion is not needed
    static void deleteNodeRecursively(LinkedList list, int key) {
        if (checkIfEmpty(list)) {
            System.out.println("LinkedList is empty.");
        } else if (list.head.data == key) {
            list.head = list.head.next;
        } else {
            Node prevNode = null;
            deleteNodeRecursion(key, prevNode, list.head);
        }

    }
    
    // Recursive function for Node deletion 
    static void deleteNodeRecursion(int key, Node prevNode, Node traversingNode) {
        if (traversingNode == null) { // Base case 1 (It is important to handle this case first)
            return;
        } else if (traversingNode.data == key) { // Base case 2
            prevNode.next = traversingNode.next;
        } else { // Recursive case
            deleteNodeRecursion(key, traversingNode, traversingNode.next);
        }
    }

    // Check if the LinkedList contains a loop using a reference table
    static boolean containsLoop(LinkedList list) {
        if (checkIfEmpty(list)) return false;
        HashSet<Node> set = new HashSet<Node>();
        Node currentNode = list.head;
        while (currentNode != null) {
            if (set.contains(currentNode)) return true;
            set.add(currentNode);
            currentNode = currentNode.next;    
        }
        return false;
    }

    // Check if the LinkedList contains a loop
    static boolean containsLoopFlagged(LinkedList list) {
        if (checkIfEmpty(list)) return false;
        Node currentNode = list.head;
        currentNode.visited = true;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.visited == true) return true;
            currentNode.visited = true;
        }
        return false;
    }

    // This method uses a reference table to remove duplicates
    static void removeDuplicatesRef(LinkedList list) {
        if (checkIfEmpty(list)) return;
        HashSet<Integer> set = new HashSet<>();
        Node prevNode = null;
        Node currentNode = list.head;
        while (currentNode != null) {
            if (!set.contains(currentNode.data)) {   
                set.add(currentNode.data);
                prevNode = currentNode;
            } else {
                prevNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
        
    }

    // This method contains two pointers and does not use a reference table
    static void removeDuplicates(LinkedList list) {
        Node current = list.head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // Print the kth to last element if the size of the list is known
    // The kth to last element is ((size-k)+1)th in the list
    static void kthToLastElement(LinkedList list, int k, int size) {
        Node runner = list.head;
        int n = (size-k)+1;
        for (int i = 1; i < n; i++) {
            runner = runner.next;
        }
        System.out.println("The " + k + "st/rd/th " + "to last element is " + runner.data);
    }

    // Print the kth to last element if the size of the list is unknown
    static void kthToLastElement(LinkedList list, int k) {
        if (checkIfEmpty(list)) {
            System.out.println("The LinkedList is empty.");
        } else {
            Node currentNode = list.head;
            while (currentNode != null) {
               Node runner = currentNode;
               int count = 0;
               while (runner.next != null) {
                    runner = runner.next;
                    count++;
               }
               if (count == k) {
                System.out.println("The " + k + "st/rd/th " + "to last element is " + currentNode.data);
                return;
               }
               currentNode = currentNode.next;
            }
            System.out.println("The element does not exist in the LinkedList.");
        }
    }

    // Find the kth to last element recursively (returns the node value, not the actual node)
    // Time complexity: O(n)
    // Space complexity: O(n)
    static int findKthRec1(Node head, int k) {
        if (head == null) {
            return 0;
        } else {
            int pos = findKthRec1(head.next, k) + 1;
            if (pos == k) {
                System.out.println("The " + k + "th to last element has a value of " + head.data);
            }
            return pos;
        }
    }

    // Find the kth to last element recursively (returns the actual node)
    // Set class of index to keep a static reference to variable since we can only return one type
    // of vlaue for the recursive function
    // Time complexity: O(n)
    // Space complexity: O(n)
    static class Index {
        int index = 0;
        Index(int i) {
            index = i;
        }
     }

    static Node findKthRec2(Node head, int k) {
        Index i = new Index(0);
        return findKthRec2(head, k, i);
    }

    static Node findKthRec2(Node head, int k, Index i) {
        if (head == null) {
            return null;
        } else {
            Node node = findKthRec2(head.next, k, i);
            i.index++;
            if (i.index == k) {
                return head;
            }
            return node;
        }
    }
   
    // Delete the middle node given ONLY the refernece to that particular node
    // Time complexity: O(n)
    // Space complexity: 
    static void deleteMiddleNode(Node node) {
        Node next;
        while (node != null) {
            next = node.next;
            if (next == null) {
                break;
            } else {
                node.data = next.data;
                if (next.next == null) {
                    node.next = null;
                    break;
                } else {
                    node = next;
                }
            }
        }
    }

    // ?????
    static Node partition(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
       

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterStart.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    
    }

    // For each next element in list1, find the matching next element in list2
    // Assume that there is always an intersection between the two lists.
    // Time complexity: O(n*m)
    static Node mergePoint1(LinkedList list1, LinkedList list2) {
        Node runner1 = list1.head;
        while (runner1 != null) {
            Node runner2 = list2.head;
            while (runner2 != null) {
                if (runner1.next == runner2.next) {
                    return runner1.next;
                }
                runner2 = runner2.next;
            }
            runner1 = runner1.next;
        }
        return null;
    }


    // Determine which of the lists are longer and cut off the longer list.
    // Afterwards, iterate through both at the same time until intersection is found.
    // Assume that there is always an intersection between the two lists.
    // Time complexity O(m+n)
    static Node mergePoint2(LinkedList list1, LinkedList list2) {
        int length1 = countNodes(list1);
        int length2 = countNodes(list2);
        int difference = Math.abs(length1-length2);
        if (length1 > length2) {
            list1 = chopLinkedList(list1, difference);
        } else {
            list2 = chopLinkedList(list2, difference);
        }

        Node runner1 = list1.head;
        Node runner2 = list2.head;
        while (runner1.next !=  runner2.next) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return runner1.next;
    }


    // Determine where the intersection between two lists are by using flags
    // Assume that there is always an intersection between any two given lists
    // This will require a modification to the data structure
    // Time complexity O(m+n)
    // Space complexity O(1)
    static Node mergePoint3(LinkedList list1, LinkedList list2) {
        Node runner1 = list1.head;
        Node runner2 = list2.head;
        while (runner1 != null) {
            runner1.visited = true;
            runner1 = runner1.next;
        }
        while (runner2.next != null) {
            if (runner2.next.visited == true) {
                return runner2.next;
            } else {
                runner2 = runner2.next;
            }
        }
        return null;
    }


    // Determine where the intersection between two lists are by
    // creating a loop in the first list and using a slow and a fast pointer
    // Assume that there is always an intersection between any two given lists
    // Time complexcity ()
    static Node mergePoint4(LinkedList list1, LinkedList list2) {
        Node curr = list1.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = list1.head;
        Node fast = list1.head;
        Node slow = list1.head;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        } 
        fast = list2.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    // Determine where the intersection between two lists are by using two pointers
    // moving at the same speed. When either of the pointers reach the end, restart
    // it at the end of the other list. They will eventually meet at the intersection 
    // point.
    // Assume that there is always an intersection between any two given lists
    static Node mergePoint5(LinkedList list1, LinkedList list2) {
        Node runner1 = list1.head;
        Node runner2 = list2.head;
        while (runner1 != runner2) {
            if (runner1.next == null) {
                runner1 = list2.head;
                runner2 = runner2.next;
            } else if (runner2.next == null) {
                runner2 = list1.head;
                runner1 = runner1.next;
            }  else {
                runner1 = runner1.next;
                runner2 = runner2.next;
            }
        }
        return runner1;

    }

    static class Node {
        int data;
        Node next;
        Boolean visited;

        // Constructor for a Node with a passed value
        Node(int n) {
            data = n;
            next = null;
            visited = false;
        }
        // Constructor for an empty Node
        Node() {
        }

    }

    public static void main(String[] args) {
        LinkedList l2 = new LinkedList();
        LinkedList l1 = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        
        appendNode(l1, node6);
        appendNode(l1, node5);
        appendNode(l1, node4);
        appendNode(l1, node3);
        appendNode(l1, node2);
        appendNode(l1, node1);
        printLinkedList(l1);

        printNodes(partition(node6, 3));


    }
}

