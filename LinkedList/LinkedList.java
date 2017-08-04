public class LinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int len;	

	public LinnkedList() {
		this.head = null;
		this.tail = null;
		len = 0;
	}
	
	public LinnkedList(T data) {
		this.head = new Node<T> (data);
		this.tail = this.head;
		len += 1;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	public int getLen() {
		return len;
	}
	
	public void add(T data){
		if(len == 0){
			head = new Node<T>(data);
			tail = head;
		}
		Node<T> newNode = new Node<>(data);
		Node<T> currentNode = head;
		
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		tail = currentNode.getNext();
		len++;
	}
	
	public void add(int index, T data) {
		if(index-1 > this.len || index < 1){
			System.out.println("invalid index!!   try again!!");
		}
		else if(index == this.len){
			addlast(data);
		}
		else{
			if(index != 1){
				Node<T> currNode = head;
				for(int i=2;i < index;i++){
					currNode = currNode.getNext();
				}
				Node<T> newNode = new Node<>(data, currNode.getNext());
				currNode.setNext(newNode);
				len++;
			}else {
				addFirst(data);
			}
		}
	}
	
	public void addFirst(T data){
		if (head != null){
			Node<T> newNode = new Node<>(data,head);
			this.head = newNode; 
		}
		else {
			this.head = new Node<>(data);
			tail = head;
		}
		len++;
	}
	
	public void addlast(T data){
		Node<T> newNode = new Node<>(data);
		tail.setNext(newNode);
		tail = newNode;
		len++;
	}
	
	public void removeFirst() {
		this.removeAt(1);
	}
	
	public void removeLast() {
		this.removeAt(len);
	}
	
	public void removeAt(int index) {
		if (head == null){
			System.out.println("Bad index!! length of Linkedlist is : "+len);
		}else{			
			if (index > 0 && index <= len) {
				if (index != 1) {
					Node<T> currNode = head;
					for (int i = 2; i < index; i++) {
						currNode = currNode.getNext();
					}
					if (index != len) {
						currNode.setNext((currNode.getNext()).getNext());
					}else {
						tail = currNode;
						currNode.setNext(null);
					}
				} else {
					head = head.getNext();
				}
				len--;
			}
		}
	}
	
	public void updateFirst(T data) {
		head.setData(data);
	}
	
	public void updateLast(T data) {
		tail.setData(data);
	}
	
	public void update(int index, T data) {
		if(head == null){
			System.out.println("Linklist is not initialized...add intead of updating..");
		}
		else if (index>0 && index < len){
			Node<T> currNode = head;
			for(int i=1;i<index;i++){
				currNode = currNode.getNext();
			}
			currNode.setData(data);
		}
		else if(index == len){
			tail.setData(data);
		}
		else {
			System.out.println("Invalid index!! length of Linkedlist is : "+ len);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String output = "";
		Node<T> currentNode = this.head;
		int i = 1;
//		output += "\n" + i + " " + currentNode.getData();
		while(currentNode.getNext() != null){
			output += "\n" + i + " " + currentNode.getData();
			currentNode = currentNode.getNext();
			i++;
		}
		output += "\n" + i + " " + tail.getData();
		return output;
	}
}
