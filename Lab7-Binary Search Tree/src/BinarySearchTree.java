/*
 * Mark Hudak
 * Lab 7
 * 10/02/2020
 * CSE 274 
 */
public class BinarySearchTree<T extends Comparable> {

	BinaryNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean insert(T data) {

		if (isEmpty()) {
			root = new BinaryNode<T>(data);
			return true;
		}
		return recursiveInsert(root, data);
	}

	private boolean recursiveInsert(BinaryNode<T> node, T newData) {
		/* if (n.data.equals(newData)) return false;
		 * if (node.data.compareTo(newData) > 0 ) {
		 *     if ( node.left != null) return add(node.left, newData);
		 *     else {
		 *          node.left = new BinaryNode(newData);
		 *          return true;
		 *          }
		 *          } else {
		 *        if (node.right != null) return add(node.right, newData);
		 *          else {
		 *            node.right = new BinaryNode(newData);
		 *            return true;
		 *            }
		 *            }
		 */
		if (node.data.compareTo(newData) == 0) {
			return false;
		} else if (node.data.compareTo(newData) > 0) {
			if (node.left == null) {
				node.left = new BinaryNode(newData);
				return true;
			} else
				return recursiveInsert(node.left, newData);
		} else {
			if (node.right == null) {
				node.right = new BinaryNode(newData);
				return true;
			} else
				return recursiveInsert(node.right, newData);
		}
	}

	// Returns the in-order traversal of the tree rooted at this node
	// Space separate; all on one line
	public String inOrder() {		
		return inOrderRecursive(root).trim();
	}

	private String inOrderRecursive(BinaryNode node) {
		String result = "";
		if (node != null) {
			result += inOrderRecursive(node.left);
			result += node.data.toString() + " "; // handling the node
			result += inOrderRecursive(node.right);
			
		}
		return result;
	}
	
	// Prints the pre-order traversal of the tree rooted at this node
	// Space separated. all on one line
	public String preOrderTraversal() {
		return preOrderRecursive(root).trim();
	}
		
		private String preOrderRecursive(BinaryNode node) {
			String result = "";
			if (node != null) {
				result += node.data.toString() + " "; // handling the node
				result += preOrderRecursive(node.left);
				result += preOrderRecursive(node.right);
			}
			return result;
		}

	// returns the height of the tree. If the tree has only
	// one node, its height is 0
	int getHeight() {
		return getHeightRecursive(root) - 1;
		//return -1;
	}
	private int getHeightRecursive( BinaryNode node) {
		if (node == null) return 0;
		return 1 + Math.max(getHeightRecursive(node.left),  getHeightRecursive(node.right));
	}

	// Returns the number of leaves in the tree rooted at this node
	int numberOfLeaves() {
		
		return numberOfLeavesRecursive(root);
	}
	
	private int numberOfLeavesRecursive(BinaryNode node) {
		
		if(node == null) return 0;
		else if (node.isLeaf()) return 1;
		else return numberOfLeavesRecursive(node.left) + numberOfLeavesRecursive(node.right);
		
		
	}

	public boolean isEmpty() {
		return root == null;
	}

	// Print all the nodes in the tree rooted at this node,
	// using post-order traversal: left subtree, right subtree, then root data
	public String postOrderTraversal() {
		return postOrderRecursive(root).trim();
	}
		
		private String postOrderRecursive(BinaryNode node) {
			String result = "";
			if (node != null) {
				result += postOrderRecursive(node.right);
				result += node.data.toString() + " "; // handling the node
				result += postOrderRecursive(node.left);
			}
			return result;
		}
	// Returns the number of nodes in the binary tree
	// that is rooted at this node. Write recursively.
	int nodeCount() {
		int count = 0; 
		return nodeCountRecursive(root);
	}

	int nodeCountRecursive(BinaryNode<T> node) {
		if (node == null) return 0;
		return 1 + nodeCountRecursive(node.left) + nodeCountRecursive(node.right);
	}
	
	// Return true if a value is in the tree, and false otherwise
	boolean find(T key) {

		return findRecursive(root, key);
	}
	
	private boolean findRecursive(BinaryNode<T> node, T key){ 
		if (node == null) return false;
		else if (node.data.equals(key)) return true;
		else if (node.data.compareTo(key) > 0) return findRecursive(node.left, key);
		else return findRecursive(node.right, key);
	}

	private class BinaryNode<T> {
		private T data;
		private BinaryNode left, right;

		public BinaryNode(T newData) {
			this.data = newData;
			this.left = null;
			this.right = null;
		}

		// Returns true if this node is a leaf, and false otherwise
		boolean isLeaf() {
			return (left == null && right == null);
		}
	}
	
}
