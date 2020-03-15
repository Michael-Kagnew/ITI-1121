public class Cashier implements Queue<T> {
	
	private Queue<Customer> queue;
	private Customer currentCustomer;
	private int totalCustomerWaitTime;
	private int customersServed;
	private int totalItemsServed;

	public Cashier(){
		queue = new ArrayQueue<Customer>();
		currentCustomer = null;
		totalCustomerWaitTime = 0;
		customersServed = 0;
		totalItemsServed = 0;

	}

	public void addCustomer(Customer c){
		//Pre condition
		if (queue.isFull()){
			throw new IllegalStateException("Too many customers!");
		}
		
		queue.enqueue(c);
	}

	public int getQueueSize(){
		return queue.size();
	}

}
