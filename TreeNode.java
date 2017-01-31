
/*
Assignment number : 2
File Name : TreeNode.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/


public class TreeNode {

	double key;       	  
	TreeNode parent;
	TreeNode right;
	TreeNode left;
	int size;
	int height;
    
    /**
     * a constructor that gets only a key to be entered and set the other
     * fields to default
     * @param key
     */
    public TreeNode (double key) {
    	this.key = key;
    	this.parent = null;
    	this.right = null;
    	this.left = null;
    	this.height = 0;
    	this.size = 0;
    }

    /**
     * return the node data
     */
    public String toString () {
    	 return "	" + this.key + "	";
    }
    
    /**
     * @return the node key
     */
	public double getKey() {
		return key;
	}
	
	/**
	 * set the given key in the node
	 * @param key - the given key
	 */
	public void setKey(double key) {
		this.key = key;
	}

	/**
	 * @return the node parent
	 */
	public TreeNode getParent() {
		return parent;
	}

	/**
	 * set the node's parent
	 * @param parent - the new parent
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	/**
	 * @return the node right child
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * set the node's right child
	 * @param right - the new right child
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}

	/**
	 * @return the node left child
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * set the node's left child
	 * @param left - the new left child
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * @return the node size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * set the node's size
	 * @param size - the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the node height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * set the node's height
	 * @param height - the new node height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
