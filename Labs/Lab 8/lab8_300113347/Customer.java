import java.util.Random;
public class Customer{

	private int arrivalTime;
	private int intitialNumberOfItems;
	private int numberOfItems;
	private static final int MAX_NUM_ITEMS = 25;

	public Customer(int arrivalTime){
		this.arrivalTime = arrivalTime;


		Random generator;  
		generator = new Random(); 
		numberOfItems = intitialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;

	}

	public int getArrivalTime(){
		return arrivalTime;
	}

	public int getNumberOfItems(){
		return numberOfItems;
	}

	public int getNumberOfServedItems(){
		return intitialNumberOfItems-numberOfItems;
	}

	public void serve(){
		numberOfItems--;
	}

	

}