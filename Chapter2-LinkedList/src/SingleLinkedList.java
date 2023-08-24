public class SingleLinkedList<T> {
    private Node<T> head;

    private int size;

    public SingleLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);
        if (head == null){
            head = node;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
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

    public Node<T> findKthToLast(int k) {
        if (head == null){
            return null;
        }
        else {
            Node<T> current = head;
            if (k > size){
                return null;
            }
            else {
                int neededNumberOfIteration = size-k;
                for (int i=0; i<neededNumberOfIteration; i++){
                    current = current.next;
                }
                return current;
            }
        }
    }
}
