package Tree;

public class Tree {
    private class Node{
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data){
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node=" + data;
        }
    }

    private Node root;

    public Tree(){
        this.root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(root == null)
        {
            root = newNode;
            return;
        }

        var current = root;
        while(true){
            if(newNode.data > current.data){
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
            else{
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }

        }


    }

    public boolean find(int value){
        var current = root;
        if(root == null) {
            throw  new IllegalArgumentException("No Node/element found in the tree.");
        }
        while(current != null){
            if(value < current.data){
                current = current.leftChild;
            }
            else
            if(value > current.data){
                current = current.rightChild;
            }
            else return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    // Pre-order means root, left , child
    private void traversePreOrder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.data);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root){
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.data);
    }
}
