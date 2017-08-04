public class LinkedListTest {

	public static void main(String[] args) {
		LinnkedList<String> linnkedList = new LinnkedList<>("Harsh");
		linnkedList.add("Arvindbhai");
		linnkedList.add("Modi");
		linnkedList.add("family");
		System.out.println(linnkedList);
//		linnkedList.removeAt(1);
//		linnkedList.removeFirst();
//		linnkedList.addFirst("Mr");
//		System.out.println(linnkedList);
//		System.out.println((linnkedList.getLen()));
//		linnkedList.add(1,"Shri");
//		linnkedList.add(2,".");
//		linnkedList.add(3,"father");
//		linnkedList.add(4,"is");
		linnkedList.addlast("awesome");
//		linnkedList.update(1, "Modh");
		linnkedList.removeLast();
		System.out.println(linnkedList);
		System.out.println("tail: "+ linnkedList.getTail().getData());
	}

}
