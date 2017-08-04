public class Node<T> {

	private T data;
	private Node<T> next;
	
	@SuppressWarnings("unchecked")
	public Node() {
		this.data = (T) "";
		this.next = null;
	}
	
	public Node(T value, Node<T> nxt) {
		this.data = value;
		this.next = nxt;
	}
	
	public Node(T value) {
		this.data = value;
		this.next = null;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getData(){
		return this.data;
	}
	
	public void setData(T value){
		this.data = value;
	}
	
}
