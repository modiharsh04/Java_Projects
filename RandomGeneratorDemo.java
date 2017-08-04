package practice;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class RandomGenerator<T>{
	
	List<T> arr;

	public RandomGenerator(ArrayList<T> arr){
		this.arr = (ArrayList<T>) arr;
	}

	@SuppressWarnings("unchecked")
	public void randomize(){
		int len = arr.size();
		SecureRandom rand = new SecureRandom();
		for (int i = len -1;i>0;i--){
			int index = rand.nextInt(i);
			String temp = (String) arr.get(index);
			arr.set(index,arr.get(i));
			arr.set(i , (T) temp);
		}
	}

	public String toString(){
		String s ="";
		for (int i=0;i<arr.size();++i){
			s +="\n" + (i+1)+" --> "+arr.get(i);
		}
		return s;
	}
}

public class RandomGeneratorDemo<T>{
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		System.out.print("Enter number of elements of array: ");
		try {
			int entries = reader.nextInt();
			reader.nextLine();
			for (int i = 0; i < entries;++i) {
				System.out.print("Enter value : ");
				String value = reader.nextLine();
				arr.add(value);
			}
		} catch (InputMismatchException e) {
			System.out.println("invalid input!..retry please !!");
		} finally {
			reader.close();
		}
		RandomGenerator<String> random1 = new RandomGenerator<>(arr);
		random1.randomize();
		System.out.println(random1);
	}
}