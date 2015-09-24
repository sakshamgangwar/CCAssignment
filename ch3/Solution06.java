import java.util.LinkedList;

/**
 * Class to test data structures used to maintain Animal Shelter, with
 * operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {
	public static void main(String[] args) {
		AnimalShelter a = new AnimalShelter();
		a.enqueue(new Animal("dog1", Type.DOG));
		a.enqueue(new Animal("dog2", Type.DOG));
		a.enqueue(new Animal("cat1", Type.CAT));
		a.enqueue(new Animal("cat2", Type.CAT));
		a.enqueue(new Animal("cat3", Type.CAT));

		System.out.println(a.dequeueAny());

		System.out.println(a.dequeueDog());

		System.out.println(a.dequeueCat());

		System.out.println(a.dequeueAny());
	}
}

/**
 * Animal Shelter is implemented by using two linked lists to maintain list of
 * inserted animals in the shelter, separately for dogs and cats. It provides
 * operation to insert : enqueue and operations to remove animals from the
 * shelter using arrival time or based on the type of animal.
 * 
 * @author Saksham Gangwar
 *
 */
class AnimalShelter {
	LinkedList<Animal> dogList = new LinkedList<Animal>();
	LinkedList<Animal> catList = new LinkedList<Animal>();

	/**
	 * Variable used to maintain arrival time for the animal, less the value,
	 * more old the animal is.
	 */
	int time = 0;

	/**
	 * Method responsible for adding new animals in the shelter.
	 * 
	 * @param animal
	 */
	public void enqueue(Animal animal) {

		/**
		 * Setting the arrival time for the animal.
		 */
		time++;
		animal.setArrivalTime(time);
		/**
		 * based on the type inserting in the specific list.
		 */
		if (animal.type == Type.DOG)
			dogList.addFirst(animal);
		if (animal.type == Type.CAT)
			catList.addFirst(animal);
	}

	/**
	 * Method to dequeue any type of animal based on the arrival time of the
	 * animal. the animal which has been in shelter for long time will be
	 * removed first.
	 * 
	 * @return - Animal
	 */
	public Animal dequeueAny() {
		if (dogList.size() == 0)
			return dequeueCat();
		if (catList.size() == 0)
			return dequeueDog();

		if (dogList.peekLast().arrivalTime < catList.peekLast().arrivalTime)
			return dogList.pollLast();
		else
			return catList.pollLast();
	}

	/**
	 * Method to get the oldest came dog in the shelter.
	 * 
	 * @return - Animal
	 */
	public Animal dequeueDog() {
		return dogList.pollLast();
	}

	/**
	 * Method to get the oldest came cat in the shelter.
	 * 
	 * @return - Animal
	 */
	public Animal dequeueCat() {
		return catList.pollLast();
	}

}

class Animal {
	String name;
	int arrivalTime;
	/**
	 * enum to maintain type of the animal, it can be cat or dog.
	 */
	Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Animal(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", arrivalTime=" + arrivalTime
				+ ", type=" + type + "]";
	}

}

enum Type {
	DOG, CAT
}
