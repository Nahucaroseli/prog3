package ejer7;

import java.util.ArrayList;

public class Tree {
	
	private Integer value;
	private Tree left;
	private Tree right;
	
	public Tree(int value){
		this.value = value;
		this.left = null;
		this.right = null;	

	}
	
	public int getHeight() {
		if(!this.isEmpty()) {
			if(this.left!=null && this.right==null) {
				int aux =left.getHeight()+ 1;
				return aux;
			}else if(this.left==null && this.right!=null){
				int aux=right.getHeight()+1;
				return aux;
			}else if(this.left==null && this.right==null) {
				return 0;

			}else if(this.left!=null && this.right!=null) {
				int aux = left.getHeight();
				int tmp = right.getHeight();
				if(aux>tmp) {
					return aux+1;
				}else {
					return tmp+1;
				}
			}
		}
		return -1;
	}
	
	 public ArrayList<Integer> getLongestBranch(){
	        if(this.left==null && this.right==null){
	        	ArrayList<Integer>hoja=new ArrayList<>();
	            hoja.add(this.value);
	            return hoja;
	        }
	        ArrayList<Integer>leftBranch=new ArrayList<>();
	        ArrayList<Integer>rightBranch=new ArrayList<>();
	        if(this.left!=null){
	            leftBranch.add(this.value);
	            leftBranch.addAll(getLongestBranch());
	        }else if(this.right!=null){
	        	rightBranch.add(this.value);
	        	rightBranch.addAll(getLongestBranch());
	        }
	        if(leftBranch.size()>=rightBranch.size()){
	            return leftBranch;
	        }else{
	            return rightBranch;
	        }
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
		if(this.left ==null && this.right==null && this.value==null) {
			return true;
		}
		return false;
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
	
	
	
	private void leaf() {
		this.value = null;
	}
	
	private boolean leafwithChild() {
		if(this.left != null) {
			this.value = left.value;
			this.left = null;
			return true;
			
		}else if(this.right != null) {
			this.value = right.value;
			this.right = null;
			return true;
		}
		return false;
	}
	
	private boolean leaftwithChilds() {
		if(this.isEmpty()) {
			return false;
		}else if(this.right != null){
			Integer aux = this.right.getMaxLeft();
			this.value = aux;
			aux = null;
			return true;
		}
		return false;
	}
	
	private Integer getMaxLeft() {
		Integer value = null;
		while(this.left != null) {
			value = this.left.value;
		}
		return value;
	}
	
	public boolean delete(Integer value) {
		if(this.isEmpty()) {
			return false;
		}else if(this.value<value) {
			return this.right.delete(value);
		}else if(this.value>value) {
			return this.left.delete(value);
		}else if(this.value.equals(value)) {
			if(this.left== null && this.right== null) {
				this.leaf();
				return true;
			}
	
		}else if(this.left!= null || this.right != null) {
			return this.leafwithChild();
		}else if(this.left!= null && this.right != null) {
			return this.leaftwithChilds();
		}
		return false;	
	}
	
	public Integer getMaxElem() {
		if(this.right != null) {
			return right.getMaxElem();
		}else {
			return this.value;
		}
	}

	private void getFrontera(ArrayList aux) {
		
		if(this.left== null && this.right== null) {
			aux.add(this.value);
		}else if(this.left!=null && this.right==null) {
			
			this.left.getFrontera(aux);
		}else if(this.right!= null && this.left==null) {
			
			right.getFrontera(aux);
		}else if(this.left!= null && this.right!= null) {
			left.getFrontera(aux);
			right.getFrontera(aux);
		}
	}
	
	public ArrayList getFrontera() {
		ArrayList aux = new ArrayList();
		this.getFrontera(aux);
		return aux;
	}
	
}
