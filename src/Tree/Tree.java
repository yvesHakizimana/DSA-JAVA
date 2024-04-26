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
}
