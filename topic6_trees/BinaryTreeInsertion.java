/* Node is defined as :
class Node
    int data;
    Node left;
    Node right;

    */

static Node Insert(Node root,int value) {
      if (root == null) {
          Node newTree = new Node();
          newTree.data = value;
          return newTree;
      }
   insertNodeRecursive(root, value);
   return root;
}

static void insertNodeRecursive(Node root, int value) {
   if (value > root.data) {
       if (root.right == null) {
          Node newNode = new Node();
          newNode.data = value;
          root.right = newNode;
       } else {
          insertNodeRecursive(root.right, value);
       }
   } else if (value < root.data) {
       // it shouldn't be a case that value == root.data. In that case we will not insert new nodes.
       // Note: this logic below could be extracted and refactored to its own method to avoid the code
       // duplication above.
       if (root.left == null) {
          Node newNode = new Node();
          newNode.data = value;
          root.left = newNode;
       } else {
          insertNodeRecursive(root.left, value);
       }
   }
}
