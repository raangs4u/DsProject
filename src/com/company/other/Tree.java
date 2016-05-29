package com.company.other;

public class Tree {

	public static void main(String[] args){
		NaryTree<Integer> tree = new NaryTree<Integer>();
		buildNaryTree(tree);
	}
	
	public static void buildNaryTree(NaryTree<Integer> tree){
		
		
		
		tree.addElementToTree(0, 25);
		tree.addElementToTree(25,30);
		tree.addElementToTree(25,35);
		tree.addElementToTree(25,40);
		tree.addElementToTree(25,45);
		

		tree.addElementToTree(30,55);
		tree.addElementToTree(30,60);
		tree.addElementToTree(60,50);
		
		tree.addElementToTree(40,65);
		tree.addElementToTree(40,70);
		
		tree.addElementToTree(65,75);
		tree.addElementToTree(65,80);

		tree.addElementToTree(80, 100);
		tree.addElementToTree(80, 101);
		tree.addElementToTree(80, 102);
		tree.addElementToTree(80, 103);
		tree.addElementToTree(80, 104);


		tree.printNaryTree();
		
		int max = tree.maxBreadth();
		
		System.out.println("max: "+ max);
		
	}
	
	
}
