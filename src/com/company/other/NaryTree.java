package com.company.other;

import java.util.List;


public class NaryTree<T> {

	public NaryTreeNode<T> root;
	
	public NaryTree(){
		root = null;
	}
	public NaryTreeNode<T> searchElement(NaryTreeNode<T> head,T data){
		NaryTreeNode<T> node = head;
		if(node.data == data){
			return node;
		}
		else{
			List<NaryTreeNode<T>> children = node.children;
			NaryTreeNode<T> searchedNode;
			 
			for(int i =0; i < children.size(); i++){
				searchedNode = searchElement(children.get(i),data);
				if(searchedNode != null){
					return searchedNode;
				}
			}
		}
		return null;
	}
	
	public NaryTreeNode<T> search(T data){
		
		NaryTreeNode<T> node = searchElement(root,data);
		return node;
	}
	public void addElementToTree(T parent,T data){
		
		NaryTreeNode<T> node = new NaryTreeNode<T>(data);
		if(root == null){
			root = node;
		}
		else{
			NaryTreeNode<T> searchNode = search(parent);
			searchNode.children.add(node);
		}
	}
	private void printTree(NaryTreeNode<T> head){
		NaryTreeNode<T> node = head;
		if(node == null){
			return;
		}
		else{
			 System.out.println(node.data);
			 List<NaryTreeNode<T>> nodeChildren = node.children;
			 for(NaryTreeNode<T> child : nodeChildren){
				 
				 printTree(child);
			 }
		}
	}
	public void printNaryTree(){
		printTree(root);
	}
	
	private void maxBreadthOfTree(NaryTreeNode<T> head,int index,int[] max ){
		if(head == null){
			return ;
		}
		if(index>=0){
			if(index > max[0]){
				max[0] = index;
			}
		}
		else{
			if(index < max[1])
			{
				max[1] = index;
			}
		}
		NaryTreeNode<T> node = head;
		List<NaryTreeNode<T>> nodeChildren = node.children;
		int childrenSize = node.getChildrenSize();
		int count;
		int flag = 0;
		int flag1 = 0;
		int flagEven = 0;
		int flagOdd = 0;
		int increment;
		int value;
		boolean isSizeEven = (childrenSize%2 == 0) ? true: false ;
		if(isSizeEven){
			count = childrenSize/2;
			
			value = count;
			
			for(NaryTreeNode<T> child : nodeChildren){
				flag++;
				if(flag <= count){
					increment = index + value;
					maxBreadthOfTree(child,increment,max);
					value = value-1;
				}
				else{
					increment = index - 1 - flagEven;
					maxBreadthOfTree(child,increment,max);
					flagEven++;
				}
			}
			
		}
		else{
			count = childrenSize/2;
			value = count;
			for(NaryTreeNode<T> child : nodeChildren){
				
				if(flag1 < count){
					increment = value + index;
					maxBreadthOfTree(child,increment,max);
					value = value-1;
				}
				else if(flagOdd == count){
					maxBreadthOfTree(child,index,max);
				}
				else{
					increment = index-(1-flagOdd);
					maxBreadthOfTree(child,increment,max);
					flagOdd++;
				}
				flag1++;
				
			}
		}
		
		
	}
	
	public int maxBreadth(){
		 int maxPositive = 0;
		 int minNegative = 0;
		 int[] max = new int[2];
		 max[0] = 0;
		 max[1] = 0;
		
		maxBreadthOfTree(root,0,max);
		
		System.out.println("max: "+max[0] + ",min: "+max[1] );
		return max[0]+(-1*max[1])+1;
		
		
	}
	
}
