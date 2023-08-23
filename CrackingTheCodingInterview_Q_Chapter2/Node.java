import java.util.*;



/*

Cracking the coding interview, Interview Questions 2.1

Remove Dups: Write code to remove duplicatesfrom an 
unsorted linked list.

FOLLOW UP: How would you solve this problem if a temporary 
buffer is not allowed?



Hints: #9, #40
_________________________________________________________

--Mind Dump--

* 





*/

public class InterviewTemplate{
	public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(1);
        linked.add(4);
        linked.add(5);
        linked.add(2);
        linked.add(6);

        System.out.println("Original linked list:");
        linkedList.print();

        
        removeDuplicates(linkedList);

        System.out.println("Linked list after removing duplicates:");
        linkedList.print();
    }
    public static void removeDuplicates(DoubleLinkedList linkedList) {
    	Node<T> current = head;
    	ArrayList<T> seenValues = new ArrayList<T>();

    	while (current != null) {
            if (seenValues.contains(current.data) {
                linkedList.remove(current.data;
            } else {
                seenValues.add(current.data;
            }
            current = current.getNext();
        }
    }
}

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> prev;

	public Node(T data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

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

}










