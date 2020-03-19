public class Cashier{
	
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
		if (queue.size() == 1000){
			throw new IllegalStateException("Too many customers!");
		}
		
		queue.enqueue(c);
	}

	public int getQueueSize(){
		return queue.size();
	}

	public void serveCustomers(int currentTime){


			if (!queue.isEmpty()){
				
				if(currentCustomer == null){
				currentCustomer = queue.dequeue();
				totalItemsServed+=currentCustomer.getNumberOfItems();
				customersServed++;
				totalCustomerWaitTime += currentTime- currentCustomer.getArrivalTime() ;	
				}
			
			} else{
				return;
			}

			currentCustomer.serve();

			if (currentCustomer.getNumberOfItems() == 0){
				currentCustomer = null;
				

			}

		


	}

	public int getTotalCustomerWaitTime(){
		return totalCustomerWaitTime;
	}

	public int getTotalItemsServed(){
		return totalItemsServed;
	}

	public int getTotalCustomersServed(){
		return customersServed;
	}
	public String toString(){
		String mess =null;
		mess+=("The total number of customers served is" + customersServed+"\n");
		mess+=("the total wait time is " + totalCustomerWaitTime);
		return mess;
	}
}
