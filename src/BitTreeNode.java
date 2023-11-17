
/**
 * Nodes in a binary search tree.
 */
class BitTreeNode{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  May not be null.
   */
  String key;

  /**
   * The associated value.
   */
  String value;

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BitTreeNode(String key, String value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  } // BSTNode(K,V)

} // class BSTNode<K,V>
