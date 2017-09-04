import java.io.*;
import java.util.*;

class LinkedListHelper<T>{
	
	Node<T> reverseLL(Node head){
		if (head == null || head.next == null) return head;
		Node cur = head.next;
		head.next = null;
		while (cur != null){
			 Node nxt = cur.next;
			 cur.next = head;
			 head = cur;
			 cur = nxt;
		}
		return head;
	}
	
	Node<T> getElemFromLast(Node head,int k){
		Node<T> cur = head;
		Node<T> run = head;
		for (int i = 0;i<k;i++){
			if (run == null) return null;
			run = run.getNext();
		}
		while (run != null){
			run = run.getNext();
			cur = cur.getNext();
		}
		return cur;
	}

	Node<T> removeDups(Node<T> head){
		//HashSet method.
		if (head == null || head.getNext() == null) return head;
		Set<T> set = new HashSet<>();
		Node<T> cur = head;
		while(cur.getNext() != null){
			set.add(cur.getData());
			if (set.contains(cur.getNext().getData()))
				cur.setNext(cur.getNext().getNext());
			else cur = cur.getNext();
		}
		return head;
	}

	void removeMiddle(Node<T> mid){
		if (mid == null || mid.getNext() == null) return;
		mid.setData(mid.getNext().getData());
		mid.setNext(mid.getNext().getNext());
	}

	Node<Integer> partElements(Node<Integer> head, int partVal){
		if (head == null) return head;
		Node<Integer> smallL = head;
		Node<Integer> largeL = head;
		
		while (head != null){
			Node<Integer> next = head.getNext();
			if (head.getData() < partVal){
				head.setNext(smallL);
				smallL = head;
			} else {
				largeL.setNext(head);
				largeL = head;
			}
			head = next;
		}
		largeL.setNext(null);
		return smallL;
	}

	Node<Integer> sumList(Node<Integer> h1, Node<Integer> h2){
		int carry=0;
		Node<Integer> cur = new Node<>(0);
		Node<Integer> head = cur;
		while (h1 != null || h2!=null || carry != 0){
			int sum = carry + (h1 != null)?h1.getData():0
					+ (h2 != null)?h2.getData():0;
			carry = sum/10;
			sum = sum%10;
			cur.setNext( new Node<Integer>(sum) );
			h1 = (h1 == null)?h1:h1.getNext();
			h2 = (h2 == null)?h2:h2.getNext();
			cur = cur.getNext();
		}
		return head;
	}
	//Recursive Approach
	/*
	boolean isPallindromLL(Node<T> cur, Node<T> run){
		if (run == null) return cur;
		if (run.getNext() == null) return cur.getNext();
		Node<T> check = isPallindromLL(cur.getNext(), run.getNext().getNext());
		if (check == null || check.getData() != cur.getData()) return null;
		return (cur.getNext());
	}
	*/
	boolean isPallindromLL(Node<T> head){
		Node<T> cur = head;
		Node<T> run = head;
		Dequeue<Integer> stack = new LinkedList<>();
		while(run != null && run.getNext() != null){
			stack.addLast(cur.getData());
			cur = cur.getNext();
			run = run.getNext().getNext();
		}
		if (run != null) cur = cur.getNext();
		while(cur != null){
			if (stack.pollLast() != cur.getData()) return false;
			cur = cur.getNext();
		}
		return true;
	}

	// I can use set too;
	boolean isCycle(Node<T> head){
		if (head == null || head.getNext() == null) return false;
		Node<T> run = head.getNext().getNext();
		while (run != null && run.getNext() != null){
			if (head == run) return true;
			head = head.getNext();
			run = run.getNext().getNext();
		}
		return false;
	}
}