import java.util.ArrayList;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void remove(T data){
        Node<T> currentNode = head;
        while (currentNode.data != null){
            if (currentNode.data.equals(data)){
                if (currentNode == head && currentNode == tail){
                    head = null;
                    tail = null;
                }
                else if(currentNode == head){
                    head = currentNode.next;
                    head.prev = null;
                }
                else if(currentNode == tail){
                    tail = currentNode.prev;
                    tail.next = null;
                }
                else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        Node<T> current = head;
        ArrayList<T> seenValues = new ArrayList<T>();

        while (current != null) {
            if (seenValues.contains(current.data)) {
                remove(current.data);
            }
            else {
                seenValues.add(current.data);
            }
            current = current.next;
        }
    }

}