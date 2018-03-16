/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/
/**
* Como la lista es menor de 100 items, nos podemos permitir guardar referencia a cada uno de los nodos.
* Si volvemos a ver esa referencia (ese nodo) mientras que iteramos sobre la lista, significa que hay un ciclo.
*/
boolean hasCycle(Node head) {
    if (head == null) {
        return false;
    }
    Set<Node> nodeTrackingList = new HashSet<Node>();
    while (head != null) {
        if (nodeTrackingList.contains(head)) {
            return true;
        }
        nodeTrackingList.add(head);
        head = head.next;
    }
    return false;
}

/**
* Otra opción sería mover dos punteros. Uno al doble de velocidad. Si hay
* algún ciclo, éste nunca terminaría sino que se llegaría a encontrar con el
* primero. Esta idea es mucho mas creativa */
boolean hasCycleOption2(Node head) {
  if (head == null) {
      return false;
  }

  Node trackerSlow = head;
  Node trackerFast = head.next;

  while (trackerFast != null && trackerFast != trackerSlow) {
      if (trackerFast.next == null) {
          return false;
      }
      trackerFast = trackerFast.next.next;
      trackerSlow = trackerSlow.next;
  }
  return trackerFast == trackerSlow;
}
