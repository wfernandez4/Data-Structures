/* Why use Trees?
 *  Trees are useful to store information that naturally occurs as a hierarchy. A file system on a computer can be represented well by a tree.
 *  Binary search trees improve upon search time compared to Linked Lists, but it is still slower than the indexed array.
 *  They provide better insertion/deletion run times compared to arrays, but worse compared to Linked Lists.
 *  Similar to Linked Lists, the number of nodes do not have a limit. Arrays must copy themselves over to accommodate more elements. 
 *  Use trees to:
 *  Handle hierarchal data, make information easy to search, modify sorted lists of data, and form decision-making maps.
 * 
 *  Characteristics:
 *  The maximum number of nodes at level j of a binary tree is 2^j
 *  The maximum number of nodes in a binary tree if height h is at most 2^h-1
 *  In a binary tree with N nodes, the minimum number of levels is Log(N+1)
 *  A binary tree with n leaves has at least | Log(n) | + 1
 *  Binary trees with nodes with only 0 or 2 children have a total of leaves equal to the number of nodes with 2 children + 1
 *  In a non empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1
 * 
 *  See also:
 *  Full binary tree, complete binary tree, perfect binary tree, degenerate binary tree, skewed binary tree, balanced binary tree
 *  
 *  This class has the most basic binary tree.
 * 
 */


 

class BinaryTree {
    Node root;

    BinaryTree(Node node) {
        root = node;
    }

    BinaryTree() {

    }

    // Helper function for traversal methods
    // This function takes input from the user for what type of traversal they want 

    static void traversalHelper(BinaryTree tree, String mode) {
        if (tree.root == null) {
            System.out.print("The tree is empty.");
            return;
        } else {
            Node traversingNode = tree.root;
            if (mode == "preorder") {
                preOrderTraversalRecursion(traversingNode);
                System.out.println("");
            } else if (mode == "inorder") {
                inOrderTraversalRecursion(traversingNode);
                System.out.println("");
            } else if (mode == "postorder") {
                postOrderTraversalRecursion(traversingNode);
                System.out.println("");
            } else {
                System.out.println("Please choose out of the three modes of traversal: preorder, inorder, or postorder");
            }
        }
    }


    static void preOrderTraversalRecursion(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversalRecursion(root.leftChild);
        preOrderTraversalRecursion(root.rightChild);
    }

    static void inOrderTraversalRecursion(Node root) {
        if (root == null) return;
        inOrderTraversalRecursion(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversalRecursion(root.rightChild);
    }

    static void postOrderTraversalRecursion(Node root) {
        if (root == null) return;
        postOrderTraversalRecursion(root.leftChild);
        postOrderTraversalRecursion(root.rightChild);
        System.out.print(root.data + " ");
    }

    static void appendNode(BinaryTree tree, Node newNode) {
        if (tree.root == null) {
            tree.root = node;
            return;
        }
        recursiveAppendNode(tree.root, newNode);
    }

    static void recursiveAppendNode(Node root, Node newNode) {
        // Base case
        if (root == null) {
            return;
        }

        // Recursive Case
        if (newNode.data > root.data) {
            recursiveAppendNode(root.rightChild, newNode);
            root.rightChild = newNode;
        } else {

        }
    }



    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int n, Node left, Node right) {
            leftChild = left;
            rightChild = right;
        }

        Node(int n) {
            data = n;
        }

        Node() {

        }

        
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        BinaryTree tree = new BinaryTree(root);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.leftChild = node1;
        root.rightChild = node2;
        node2.leftChild = node3;
        node2.rightChild = node4;
        node1.leftChild = node5;
        node1.rightChild = node6;
        traversalHelper(tree, "preorder");
        traversalHelper(tree, "inorder");
        traversalHelper(tree, "postorder");
        System.out.println();



    }
    

}