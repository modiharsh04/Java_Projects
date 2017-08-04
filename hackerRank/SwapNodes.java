import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapNodes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Tree tree = new Tree();
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        Node root = new Node();
        root.data = 1;
        int height = 1;
        for (int i=0;i<n;i++){
            int left = read.nextInt();
            int right = read.nextInt();
            tree.add(root,i+1,left,right);
        }
        height = tree.height(root);
        int k = read.nextInt();
        for (int i=0;i<k;i++){
            int parent = read.nextInt();
            int j=1;
            while((j*parent) <= height){
                tree.swap(root,(j*parent),1);
                j++;
            }
            tree.inTraverseTree(root);
            System.out.println();
        }
    }
}

class Node {
    
    int data;
    Node left;
    Node right;

    public Node(){

    }

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    int height;
    
    int height(Node root) {
      	// Write your code here.
        if (root == null)
            return -1;
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (leftH > rightH)
            return leftH+1;
        return rightH+1;
        
    }
    
    public void add(Node node,int data,int left,int right){
        if (node == null){
            return;
        }
        if (node.data == data){
            if (left != -1)
                node.left =new Node( left);
            if (right != -1)
                node.right = new Node(right);
        } else {
            add(node.left,data,left,right);
            add(node.right,data,left,right);
        }
    }
    
    void swap(Node root,int data,int level){
        if(root == null)
            return;
        if(level == data){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        swap(root.left,data,level+1);
        swap(root.right,data,level+1);
    }
    
    public void inTraverseTree(Node root){
        if (root == null)
            return;
        inTraverseTree(root.left);
        System.out.print(root.data + " ");
        inTraverseTree(root.right);
    }
    
}