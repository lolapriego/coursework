// SpaniardsToSv. Please report an issue if you have any questions.

// HackerRank documentation.
/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  
  class Node {
     int data;
     Node next;
  }
*/

/**
* Our solution. Please note that there could always be more than one.
*
*/
Node Insert(Node head,int data) {
    Node tail = new Node();
    tail.data = data;
    if (head == null) {
        return tail;
    }

    Node trackingNode = head;

    while (trackingNode.next != null) {
        trackingNode = trackingNode.next;
    }
    trackingNode.next = tail;
    return head;
}
