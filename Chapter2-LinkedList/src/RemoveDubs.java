
/*

Cracking the coding interview, Interview Questions 2.1

Remove Dups: Write code to remove duplicates from an
unsorted linked list.

FOLLOW UP: How would you solve this problem if a temporary 
buffer is not allowed?



Hints: #9, #40
_________________________________________________________

--Mind Dump--
* I have created an ArrayList, starting from the head node, if the node is seen before in the ArrayList, delete
the node, if not, add the node to the ArrayList.

*/

public class RemoveDubs{
    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(6);

        System.out.println("Original linked list:");
        linkedList.print();


        linkedList.removeDuplicates();

        System.out.println("Linked list after removing duplicates:");
        linkedList.print();
    }

}










