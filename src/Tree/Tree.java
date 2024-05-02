package Tree;


import java.util.ArrayList;

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
    private ArrayList<Integer> numbers = new ArrayList<>();

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

    public Node getRoot() {
        return root;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

//    public void traverseInOrder(){
//        traverseInOrder(root);
//    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
        return height(root);
    }
    public int min(){
        return leftMost(root);
    }

    public int max(){
        return rightMost(root);
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

    private int height(Node root){
        if(root == null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    private int minValue(Node root){
        if(this.root == null)
            throw  new IllegalArgumentException("No nodes in this tree.");
        if(isLeaf(root))
            return root.data;
        var left = minValue(root.leftChild);
        var right = minValue(root.rightChild);
        return Math.min(Math.min(left, right), root.data);
    }

    private int leftMost(Node root){
        if(root == null)
            throw  new IllegalArgumentException("No Node in this tree.");
        var current = root;
        Node leftmost = null;
        while(current != null){
            leftmost = current;
            current = current.leftChild;
        }
        return leftmost.data;
    }

    private int rightMost(Node root){
        if(root == null){
            throw  new IllegalArgumentException("There is no node in the tree.");
        }
        var current = root;
        Node last = null;
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last.data;
    }

    public boolean equals(Tree other){
        return  equals(root, other.root);
    }

    private boolean equals(Node first, Node last){
        if(first == null && last == null)
            return  true;
        if(first != null && last != null){
            return (first.data == last.data &&
                    equals(first.leftChild, last.leftChild) &&
                    equals(first.rightChild, last.rightChild));
        }
        return  false;
    }



}