/*

Cracking the coding interview, Interview Questions 2.2

Return Kth to Last: Implement an algorithm to find the kth
to last element of a singly linked list.

Hints: #8, #25, #41, #67, #126
_________________________________________________________

--Mind Dump--
* I will get the size first, and calculate size - k . Then open
up a counter, and iterate through the needed number of times.

*/
public class ReturnKthToLast {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int i = 2;
        int j = 3;
        int k = 6;

        Node<Integer> kthToLast1 = list.findKthToLast(i);

        if (kthToLast1 != null) {
            System.out.println("The " + i + "th element from the end is: " + kthToLast1.data);
        } else {
            System.out.println("Invalid input or k is out of bounds.");
        }
        Node<Integer> kthToLast2 = list.findKthToLast(j);

        if (kthToLast2 != null) {
            System.out.println("The " + j + "th element from the end is: " + kthToLast2.data);
        } else {
            System.out.println("Invalid input or k is out of bounds.");
        }

        Node<Integer> kthToLast3 = list.findKthToLast(k);

        if (kthToLast3 != null) {
            System.out.println("The " + k + "th element from the end is: " + kthToLast3.data);
        } else {
            System.out.println("Invalid input or k is out of bounds.");
        }


    }


}
