import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRankTreeMethods {

}

class Node {
	int data;
	Node left;
	Node right;
}

class Tree {

	void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data +  " ");
		inOrder(root.right);
	}

	int height(Node root) {
		if (root == null)
			return -1;
		int leftH = height(root.left);
		int rightH = height(root.right);
		if (leftH > rightH)
			return leftH+1;
		return rightH+1;
	}

	//Next three methods are for getting top view
	void top_view(Node root)
	{
		if (root == null)
			return;
		left_top(root.left);
		System.out.print(root.data+" ");
		right_top(root.right);
	}
	void left_top(Node root){
		if (root == null)
			return;
		left_top(root.left);
		System.out.print(root.data+" ");
	}
	void right_top(Node root){
		if (root == null)
			return;
		System.out.print(root.data+" ");
		right_top(root.right);
	}

	void levelOrder(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) 
		{
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	Node binaryInsert(Node root,int value){
		Node cur = root;
		if (cur == null){
			cur = new Node();
			cur.data = value;
			cur.left = cur.right = null;
			return cur;
		}
		if  (value<root.data)
			cur.left = binaryInsert(cur.left,value);
		else
			cur.right = binaryInsert(cur.right,value);
		return root;
	}

	void huffmandecode(String S ,Node root)
	{
		Node cur = root;
		String[] s = S.split("");
		String result="";
		for (int i=1;i<s.length;i++){
			if(s[i].equals("0")){
				cur = cur.left;
			}
			if(s[i].equals("1")){
				cur = cur.right;
			}
			if(cur.left==null&&cur.right==null){
				result += cur.data;
				cur = root;
			}
		}
		System.out.println(result);
	}

	Node lcaBinaryTree(Node root,int v1,int v2)
	{
    //if (root == null)
      //  return null;
		if(v1<root.data && v2<root.data)
			return lcaBinaryTree(root.left,v1,v2);
		if (v1>root.data && v2>root.data)
			return lcaBinaryTree(root.right,v1,v2);
		return root;
	}

}