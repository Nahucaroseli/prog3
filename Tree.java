package ejer7;

public class Tree {
	
	private Integer value;
	private Tree left;
	private Tree right;
	
	public Tree(int value){
		this.value = value;
		this.left = null;
		this.right = null;	
	}
	
	public void add(int newValue) {
		if(this.value > newValue) {
			if(this.left == null) {
				this.left = new Tree(newValue);
			}else {
				this.left.add(newValue);
			}
			
		}else if(this.value<newValue) {
			if(this.right == null) {
				this.right = new Tree(newValue);
			}else {
				this.right.add(newValue);
			}
		}
	}
	
	public Integer getRoot() {
		return this.value;
	}
	
	
	public boolean hasElem(int newValue) {
		if(this.value == newValue) {
			return true;
		}else if(this.left != null){
			return left.hasElem(newValue);
		}else if(this.right != null){
			return right.hasElem(newValue);
		}else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(this.left !=null) {
			return false;
		}
		return true;
	}
	
	public void printPreorder(Tree node) {
	
		if (node == null) {
			return;
		}
		
		System.out.print(node.value + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	} 
	void printPostorder(Tree node) {
	
		if (node == null) {
			return;
		}
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.value + " ");
	} 
	
	void printInorder(Tree node) {
	
		if (node == null) {
			return;
		}	
		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	}
	
	
	
	public boolean delete(Tree node,int newValue) {
		if(node == null) {
			return false;
		}else if(newValue < node.value) {
			return node.left.delete(node.left,newValue);
		}else if(newValue > this.value){
			return node.right.delete(node.right,newValue);
		}else {
				if(node.left == null && node.right == null) {
					node.value = null;
				}else if(node.left == null) {
					Tree temp = node;
					node = node.right;
					temp = null;	
				}else if(node.right == null) {
					Tree temp = node;
					node = node.left;
					temp = null;
				}
		}
		return false;
	}
	
	public Integer getMaxElem() {
		Integer value = 0;
		while(this.right != null) {
			value = right.value;
		}
		return value;
	}
	
	
}
