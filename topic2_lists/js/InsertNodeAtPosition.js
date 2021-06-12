// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

function insertNodeAtPosition(head, data, position) {
  let i = 0;
  let it = head;
  let node = new SinglyLinkedListNode(data);
  
  if (position == 0) {
      node.next = head;
      head = node;
      return head;
  }
  
  while (it) {
      if (i == position - 1) {
          node.next = it.next;
          it.next = node;
      }
      it = it.next;
      i++;
  }
  
  return head;
}
