/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/
/**
* The list has less than 100 items. Therefore, we can keep the reference to each
* of the nodes - as it will not be memory expensive.
* If we see that reference (that node) while we iterate over the list,
* it means that there is a cycle.
*/
public class Solution {
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
* Another option would be to move two pointers. One should be twice faster.
* If there are any cycles, this should never end, but it will meet the other
* pointer. This idea is much more creative.
**/
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
}
