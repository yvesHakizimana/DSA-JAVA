package LinkedLists;

public class LinkedList {
    private Node head;
    private Node tail;
    private static class Node{
        private int item;
        private Node next;

        public Node(int data){
            item = data;
            next = null;
        }
    }

    public LinkedList(){
        head =  tail =  null;
    }

    public void addLast(int item){
        var newNode = new Node(item);
        // No element in the linked list
        if(head == null) {
            head = tail = newNode;
            return;
        }
        //If there is like  more than one element in the linked list
        tail.next = newNode;
        tail = newNode;
    }

    public void deleteFirst(){
        //If the linked list is empty
        if(isEmpty())
            throw  new IllegalArgumentException("The Linked list is empty");
        //What if the linked list has only one element
        if (head == tail) {
            head = tail = null;
            return;
        }
        //Then what next // Program all edge Casess....
        var second = head.next;
        head.next = null;
        head = second;
    }

    public void deleteLast(){
        if(isEmpty())
            throw  new IllegalArgumentException("The Linked list is empty");
        if(head == tail){
            head = tail = null;
            return;
        }
        var current = head;
        while(current.next != tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void addFirst(int item){
        var newNode = new Node(item);
        //If there is no element in the linked list
        if(head == null)
            head = tail =  newNode;
        //If there is like one element in the linked list
        newNode.next = head;
        head  = newNode;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int indexOf(int item){
        var current = head;
        int index = 1;
        while(current != null){
            if(current.item == item) {
                return index;
            }
            current =  current.next;
            index++;
        }
        return -1;
    }

    public void print(){
        if(isEmpty()) throw new IllegalArgumentException("Linked list is empty");
        var current = head;
        while(current != null){
            System.out.println(current.item);
            current = current.next;

        }
    }
}
