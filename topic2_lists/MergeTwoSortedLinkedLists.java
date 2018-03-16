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
* Hay dos formas de hacerlo que se me vengan a la cabeza.
* 1) involucra iterar sobre una de las listas insertando los nodos de la otra lista
* cuando sean menores.
* 2) consiste en tener una referencia a la cola de la nueva lista y un puntero por cada
* lista. Siempre insertaremos el nodo del puntero que sea menor.
* Vamos a resolverlo como el n.2, ya que las dos son iguales en tiempo y memoria, pero
* la segunda es mas sencilla.
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
