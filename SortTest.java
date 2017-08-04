package practice;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = {1,5,7,3,8,9,6,4,2};
		Sort sort = new Sort();
		for (int i: arr) System.out.print(i + " ");
		System.out.println();
		sort.mergeSort(arr);
		for (int i: arr) System.out.print(i + " ");
	}
}
