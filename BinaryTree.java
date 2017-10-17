public class BinaryTree {
    static TreeNode root;
    public static void addNode(int key, String name) {
        // Create a new Node and initialize it
       TreeNode newNode = new TreeNode();
        // If there is no root this becomes root
       if (root == null) {
           root = newNode;
        } else {
            // Set root as the Node we will start
           // with as we traverse the tree
            TreeNode focusNode = root;
            // Future parent for our new Node
           TreeNode parent;
            while (true) {
                // root is the top parent so we start
               // there
               parent = focusNode;
                // Check if the new node should go on
              // the left side of the parent node
               if (key < focusNode.key) {
                   // Switch focus to the left child
                    focusNode = focusNode.left;
                    // If the left child has no children
                    if (focusNode == null) {
                       // then place the new node on the left of it
                       parent.left = newNode;
                       return; // All Done
                  }
                } else { // If we get here put the node on the right
                    focusNode = focusNode.right;
                   // If the right child has no children
                    if (focusNode == null) {
                       // then place the new node on the right of it
                       parent.right = newNode;
                        return; // All Done
                    }

                }

            }
        }

    }
    
}
