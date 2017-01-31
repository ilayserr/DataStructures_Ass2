
/*
Assignment number : 2
File Name : Tree.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/


public class Tree {

	TreeNode root;

	/**
	 * an empty constructor
	 */
	public Tree() {
		this.root = null;
	}

	/**
	 * finds the node with the required key and return it.
	 * 
	 * @param keyToLookUp - the key to search
	 * @return the node requested
	 */
	public TreeNode find(double keyToLookUp) {
		TreeNode it = this.root;
		if (it == null)
			return null;

		// runs until "it" has the requested key and returns it.
		while (it != null) {
			if (it.getKey() == keyToLookUp)
				return it;
			else if (it.getKey() < keyToLookUp) {
				it = it.getRight();
			} else {
				it = it.getLeft();
			}
		}
		// in case the key doesn't found
		return null;
	}

	/**
	 * insert the given node in the suitable place and update it's and the other
	 * related nodes fields.
	 * 
	 * @param newNode - the node to be entered.
	 */
	public void insert(TreeNode newNode) {
		if (find(newNode.getKey()) != null)
			return;
		TreeNode it = this.root;
		TreeNode curr = this.root;

		// in case this is the first node to be insert
		if (it == null) {
			this.root = newNode;
			this.root.setSize(this.root.getSize() + 1);
			this.root.setHeight(this.root.getHeight() + 1);
			return;
		}

		// runs until "curr" is the new father of the new node
		while (it != null) {
			curr = it;
			it.setSize(it.getSize() + 1);
			if (it.getKey() < newNode.getKey()) {
				it = it.getRight();
			} else {
				it = it.getLeft();
			}
		}

		// insert the new node in the correct position
		if (curr.getKey() > newNode.getKey()) {
			curr.setLeft(newNode);
		} else {
			curr.setRight(newNode);
		}

		// updates the fields
		newNode.setParent(curr);
		newNode.setHeight(0);
		newNode.setSize(1);
		TreeNode temp = newNode;

		// update the height field
		while ((curr != null) && (curr.getHeight() == temp.getHeight())) {
			curr.setHeight(curr.getHeight() + 1);
			temp = curr;
			curr = curr.getParent();
		}
	}

	/**
	 * deletes the given node from the tree. updates the fields of the related
	 * nodes.
	 * 
	 * @param deleteNode - the node to be deleted.
	 */
	public void delete(TreeNode deleteNode) {
		TreeNode deleted = find(deleteNode.getKey());
		TreeNode father = deleted.getParent();

		// the deleted node has no children
		if ((deleted.getRight() == null) && (deleted.getLeft() == null)) {

			// the node to be deleted is the root
			if (deleted == root)
				this.root = null;

			// the node to be deleted is a left son.
			else if (father.key > deleted.key) {
				father.left = null;
				update(father);

			// the node to be deleted is a right son.
			} else {
				father.right = null;
				update(father);
			}
		}

		// the deleted node has 1 child and it is a left son
		else if (deleted.right == null) {

			// the node to be deleted is the root
			if (deleted == root) {
				root = deleted.left;
			// the node to be deleted is a left son.
			} else if (father.key > deleted.key) {
				father.left = deleted.left;
				deleted.left.parent = father;
				update(father);
			// the node to be deleted is a right son.
			} else {
				father.right = deleted.left;
				deleted.left.parent = father;
				update(father);
			}
		// the deleted node has 1 child and it is a right son
		} else if (deleted.left == null) {

			// the node to be deleted is the root
			if (deleted == root) {
				root = deleted.right;
			// the node to be deleted is a left son.
			} else if (father.key > deleted.key) {
				father.left = deleted.right;
				deleted.right.parent = father;
				update(father);
			// the node to be deleted is a right son.
			} else {
				father.right = deleted.right;
				deleted.right.parent = father;
				update(father);
			}

		// the deleted node has 2 children
		} else {

			// get successor and saves it in "successor"
			TreeNode successor = getSuccessor(deleted);

			// the node to be deleted is the root
			if (deleted == this.root) {
				this.root.key = successor.key;
			} else

				deleted.key = successor.key;
			// the successor has a right son.
			if (successor.right != null) {

				// the successor is a left son
				if (successor == successor.parent.left) {
					successor.parent.left = successor.right;
					successor.right.parent = successor.parent;

				// the successor is a right son
				} else {
					successor.parent.right = successor.right;
					successor.right.parent = successor.parent;
				}

			// the successor has no sons.
			// the successor is a left son
			} else if (successor == successor.parent.left) {
				successor.parent.left = null;

			// the successor is a right son
			} else {
				successor.parent.right = null;
			}
			update(successor.parent);
		}
	}

	/**
	 * get the correct successor
	 * 
	 * @param node - the node to find his successor
	 * @return - the correct successor.
	 */
	private TreeNode getSuccessor(TreeNode node) {
		TreeNode curr = node.right;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	/**
	 * updates the height and size of the node requested and the other related
	 * nodes.
	 * 
	 * @param papa - the node requested to update.
	 */
	private void update(TreeNode papa) {

		// updating the size filed
		TreeNode it = papa;
		while (it != null) {
			it.size--;
			it = it.parent;
		}

		// updating the height field
		it = papa;
		while ((it != null)) {
			if (it.right != null) {
				if (it.height - it.right.height == 1)
					return;
			} else if (it.left != null) {
				if (it.height - it.left.height == 1)
					return;
			}
			it.height--;
			it = it.parent;
		}
	}

	/**
	 * a wrapper function to OSSelect
	 * 
	 * @param requiredRank - the rank requested
	 * @return the suitable node to the rank requested
	 */
	public TreeNode OSSelect(int requiredRank) {
		return (OSSelect(requiredRank, this.root));
	}

	/**
	 * a recursive function that finds the correct node according to the rank
	 * requested.
	 * 
	 * @param requiredRank - the rank requested.
	 * @param currRoot - the current root in the recursive function.
	 * @return the suitable node to the rank requested.
	 */
	public TreeNode OSSelect(int requiredRank, TreeNode currRoot) {
		if (requiredRank <= 0 || requiredRank > root.size)
			return null;
		int rank = 0;
		if (currRoot.left != (null)) {
			rank = currRoot.left.size + 1;

		// in case there is no left child
		} else
			rank = 1;
		if (requiredRank == rank)
			return currRoot;
		else if (requiredRank < rank) {
			return (OSSelect(requiredRank, currRoot.left));
		} else {
			return (OSSelect(requiredRank - rank, currRoot.right));
		}
	}

	/**
	 * computes the rank of the given node.
	 * 
	 * @param requiredNode - the given node.
	 * @return the requierdNode rank.
	 */
	public int OSRank(TreeNode requiredNode) {
		TreeNode node = find(requiredNode.key);
		int rank = 0;
		if (node.left != (null)) {
			rank = node.left.size + 1;

		// in case there is no left child
		} else
			rank = 1;
		while (node.parent != null) {
			if (node.parent.right != (null)) {
				if (node == node.parent.right) {
					if (node.parent.left != (null)) {
						rank += node.parent.left.size + 1;

					// in case there is no left child to the parent
					} else
						rank += 1;
				}
			}
			node = node.parent;
		}
		return rank;
	}

	/**
	 * checks if the tree is balanced according to the definition of "balanced"
	 * @param node - the node to check
	 * @return - true if the tree is balanced and false otherwise.
	 */
	public boolean isBalanced(TreeNode node) {
		int check = node.height;

		// computes if the tree is balanced according to the formula
		// height >= 2log(node.size) (log base 2)
		double bal = 2 * (Math.log(node.size) / Math.log(2));
		if (check <= bal)
			return true;
		else
			return false;
	}
}
