/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

/**
* There are two ways of coding this:
* 1) Involves iterating over the lists inserting the nodes of the other lista
* when these are smaller.
* 2) Keep a reference to the tail of the new list and a pointer for each list.
* We would always insert the node of the pointer that is pointing to the smaller
* value.
* Let's solve it as approach n.2 as both solutions have the same big-Oh in time
* and memory, but n.2 is simpler to implement.
*/
Node mergeLists(Node headA, Node headB) {
    Node newHead = null;
    Node newTail = null;
    // We will use headA and headB as tracking nodes.
    while (headA != null || headB != null) {
        if (headA == null || headB != null && headA.data > headB.data) {
            Node n = appendNodeInNewList(newHead, newTail, headB.data);
            if (newHead == null) {
                newHead = n;
            }
            newTail = n;
            headB = headB.next;
        } else {
            Node n = appendNodeInNewList(newHead, newTail, headA.data);
            if (newHead == null) {
                newHead = n;
            }
            newTail = n;
            headA = headA.next;
        }
    }

    return newHead;
}

private Node appendNodeInNewList(Node head, Node tail, int data) {
    Node nodeToInsert = new Node();
    nodeToInsert.data = data;
    // handle first case
    if (head != null) {
        tail.next = nodeToInsert;
    }
    return nodeToInsert;
}
