import java.util.*;
import java.io.*;

class ElevatorStops{
	Queue<Person> persons;
	Elevator elevator;
	int totalFloors;

	public int elevatorTotalStops(int[] weight, int[] toFloor, int totalFloors, int maxWeight, int maxPerson) {
		persons = new LinkedList<>();
		elevator = new Elevator(maxWeight,maxPerson);
		this.totalFloors = totalFloors;
		for (int i=0;i<weight.length;i++)
			persons.offer(new Person(weight[i],toFloor[i]));
		int stops = 0;
		while (!persons.isEmpty())
			stops += tripStops();
		return stops;
	}

	int tripStops (){
		Elevator trip = new Elevator(0,0);
		BitSet floors = new BitSet(totalFloors);
		while (!persons.isEmpty() && trip.personCnt < elevator.personCnt && (trip.weight+persons.peek().getWeight()) <= elevator.weight){
			Person person = persons.poll();
			trip.weight += person.getWeight();
			trip.personCnt += 1;
			floors.set(person.getFloor());
		}
		return floors.cardinality()+1;
	}
}

class Elevator {
	protected int weight;
	protected int personCnt;
	Elevator(){}
	Elevator(int w, int p){
		weight = w;
		personCnt = p;
	}
}

class Person {
	private int weight;
	private int floor;
	public Person(int z,int y){
		this.weight = z;
		this.floor = y;
	}
	public int getWeight() {
		return this.weight;
	}
	public int getFloor() {
		return this.floor;
	}
}