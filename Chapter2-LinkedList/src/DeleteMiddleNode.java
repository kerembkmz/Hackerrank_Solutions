
/*

Cracking the coding interview, Interview Questions 2.3

Delete Middle Node: Implement an algorithm to delete a
node in the middle (i.e., any node but the first and last
node, not necessarily the exact middle) of a singly linked
list, given only access to that node.


Example:

input: the node c from the linked list a->b->c->d->e->f
output: nothing is returned, but the new linked list looks
like a-.b->d->e->f

Hints: #72
_________________________________________________________

--Mind Dump--
* Simple delete implementation from the linked list.

*/
public class DeleteMiddleNode {
    public static void main(String[] args) {
        SingleLinkedList<Character> list = new SingleLinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');

        list.print();

        list.removeMiddle('c');

        list.print();
    }
}
