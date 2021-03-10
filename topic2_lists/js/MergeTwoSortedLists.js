// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?h_r=internal-search

// TBD

function mergeLists(head1, head2) {
  let it1 = head1, it2 = head2;
  let merged = null;
  // get first node
  if (it1 && it2) {
      if (it1.data < it2.data) {
          merged = it1;
          it1 = it1.next;
      }
      else {
          merged = it2;
          it2 = it2.next;
      }

      while (it1 && it2) {
        if (it1.data < it2.data) {
          merged.next = it1;
          it1 = it1.next;
        }
        else {
          merged.next = it2;
          it2 = it2.next;
        }
      }
  }
  else {
      // one of them is null
      merged = it1 ? it1 : it2;
  }
  return merged;
}
