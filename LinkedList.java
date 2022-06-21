class LinkedList {
    Node head;
    
    LinkedList() {
        head = null;
    }

    LinkedList(Node node) {
        head = node;
    }

    static boolean checkIfEmpty(LinkedList list) {
        return list.head == null;
    } 

    static void printLinkedList(LinkedList list) {
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    static void insertNewHead(LinkedList list, Node node) {
        node.next = list.head;
        list.head = node;
    }

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

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        appendNode(ll, new Node(1));
        appendNode(ll, new Node(2));
        appendNode(ll, new Node(3));
        printLinkedList(ll);
        insertNewHead(ll, new Node(0));
        printLinkedList(ll);
        System.out.println(checkIfEmpty(ll));
    }
}

