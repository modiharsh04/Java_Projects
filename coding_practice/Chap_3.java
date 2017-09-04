class Chap_3{

	class StackOfPlates{
		List<Stack> stacks;
		int capacity;
		int 
		StackOfPlates(int c){
			this.capacity = c;
		}
		void push(int val){

		}
	}

	class Stack{
		private Node head;
		Stack(){
			head = new Stack();
		}
		void push(int val){
			Node temp = new Node(val);
			temp.next = head;
			head = temp;
		}

		int pop(){
			if (head == null) throw EmptyStackException();
			int val = head.data;
			head = head.next;
			return val;
		}

		int peek(){
			if (head == null) throw EmptyStackException();
			return head.data;
		}

		boolean isEmpty(){
			return (head==null);
		}
	}

	class StackWithMin extends Stack {
		private Stack minStack;
		final int MAX_VALUE = 2147483647;
		StackWithMin(){
			minStack = new Stack();
		}
		void push(int val){
			if (val< min()) minStack.push(val);
			super.push(val);
		}

		int pop(){
			int val = super.pop();
			if (min() == val) minStack.pop();
			return val;
		}

		int min(){
			return (minStack.isEmpty())?MAX_VALUE:minStack.peek();
		}
	}


	class Node{
		int data;
		Node next;
		Node(int v){
			data = val;
		}
	}
}