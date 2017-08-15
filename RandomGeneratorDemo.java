import java.io.*;
import java.util.*;

class RandomGenerator<T>{

	protected void randomize(List<T> arr){
		int len = arr.size();
		Random rand = new Random();
		for (int i = len -1;i>0;i--){
			int index = rand.nextInt(i);
			T temp = (T) arr.get(index);
			arr.set(index,arr.get(i));
			arr.set(i , (T) temp);
		}
	}
}

public class RandomGeneratorDemo<T>{

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Console reader = System.console();
		if (reader == null) {
		    System.out.println("No console: non-interactive mode!");
		    System.exit(0);
		}
		List<String> arr = new ArrayList<String>();
		System.out.print("Enter number of elements of array: ");
		try {
			int entries = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < entries;++i) {
				System.out.print("Enter value : ");
				String value = reader.readLine().trim();
				arr.add(value);
			}
		} catch (NumberFormatException e) {
			System.out.println("invalid input!..retry please !!");
		} finally {
			reader.close();
		}
		RandomGenerator<String> random1 = new RandomGenerator<>();
		random1.randomize(arr);
		System.out.println(arr);
	}
}