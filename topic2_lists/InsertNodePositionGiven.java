/*
  Insert Node at a given position in a linked list
  head can be NULL
  First element in the linked list is at position 0
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
Node InsertNth(Node head, int data, int position) {
   Node toInsert = new Node();
    toInsert.data = data;
    if (head == null) {
      return toInsert;
    }
    if (position == 0) {
      toInsert.next = head;
      return toInsert;
    }
    int index = 0;
    Node tracker = head;

    // No asumimos que la posición que nos dan nunca será mayor
    // que el número de elementos en la lista + 1. Si es así, añadiríamos
    // el elemento al final de la lista.
    while (tracker.next != null && index != position - 1) {
      tracker = tracker.next;
      index++;
    }

    insertInBetween(tracker, toInsert);
    return head;
}

private static void insertInBetween(Node current, Node toInsert) {
    Node tmp = current.next;
    current.next = toInsert;
    toInsert.next = tmp;
}
