package Tree_structure;

class Node {
    int data;
    Node left = null;
    Node right = null;
}

class Tree {

    public Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void inorder(Node node) { //Left -> Root -> Right
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data+ " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) { //Root -> Left -> Right
        if (node != null) {
            System.out.print(node.data+ " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) { // Left -> Right -> Root
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data+" ");
        }
    }
}


public class TreeMain {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
        System.out.print("inorder : ");
        t.inorder(t.getRoot());
        System.out.println("\n");
        System.out.print("preorder : ");
        t.preorder(t.getRoot());
        System.out.println("\n");
        System.out.print("postorder : ");
        t.postorder(t.getRoot());
    }
}
