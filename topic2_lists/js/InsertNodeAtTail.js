// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem

function insertNodeAtTail(head, data) {
  let it = head;
  
  // go till the last node
  while (it && it.next) {
      it = it.next;
  }
  
  let node = new SinglyLinkedListNode(data);
  
  if (it) it.next = node;
  else head = node;
  
  return head;
}
