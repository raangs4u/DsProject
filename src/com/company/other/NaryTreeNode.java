package com.company.other;

import java.util.ArrayList;
import java.util.List;




public class NaryTreeNode<T> {

	public T data;
	public List<NaryTreeNode<T>> children;
	
	public NaryTreeNode(){
		children = new ArrayList<NaryTreeNode<T>>();
	}
	
	public NaryTreeNode(T data){
		this.data = data;
		children = new ArrayList<NaryTreeNode<T>>();
	}
	
	public T getData(){
		return this.data;
	}
	public void setData(T data){
		this.data = data;
	}
	
	public List<NaryTreeNode<T>> getChildren(){
		return this.children;
	}
	
	public int getChildrenSize(){
		return getChildren().size();
	}
	
	public boolean hasChildren(){
		return getChildren().size()>0 ;
	}
	
	public void setChildren(List<NaryTreeNode<T>> children){
		this.children = children;
	}
	
	public void addChild(NaryTreeNode<T> child){
		children.add(child);
	}
	public void addChildAtGivenIndex(int index,NaryTreeNode<T> child){
		children.add(index,child);
	}
	
	
}
