public class Test{
	
	public static void main(String[] args){

	 Cashier cashier = new Cashier();
       Customer customer = new Customer(5);
        cashier.addCustomer(customer);

         int items = customer.getNumberOfItems();

        for (int i = 0; i < items; i++) {
          cashier.serveCustomers(10);
          System.out.println(cashier.getTotalItemsServed());
        }

      //  System.out.println(cashier.);

	}
}