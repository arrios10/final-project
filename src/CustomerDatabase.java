import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CustomerDatabase {

	private Map<String, Customer> customers = new HashMap<String, Customer>();
	
	/**
	 * Add new customer by providing name, id, and total sales
	 * @param customer
	 */
	public void addNewCustomer(String name, String id, double totalSales) {
		this.addNewCustomer(new Customer(name, id, totalSales));	
	}
	
	/**
	 * Add new customer by providing a Customer instance 
	 * @param customer
	 */
	public void addNewCustomer(Customer customer) {
		
		customers.put(customer.getId(), customer);
	}
	
	/**
	 * Returns all Customer instances in the database
	 * @return
	 */
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> allCustomers = new ArrayList<Customer>();
		
		for (Customer cust : customers.values()) {
			allCustomers.add(cust);
		}
		
		return allCustomers;
		
	}
	
	
	/**
	 * Returns an array of Customer descriptions
	 * @return
	 */
	public ArrayList<String> getAllCustomerDescriptions() {
		ArrayList<String> allCustomers = new ArrayList<String>();
		
		for (Customer cust : customers.values()) {
			allCustomers.add(cust.toString());
		}
		
		return allCustomers;
		
	}
	
	
	/**
	 * Returns a description of a customer 
	 * @param id
	 * @return
	 */
	public String getCustomerDescription(String id) {
		Customer cust = this.customers.get(id);
		String description = "";
		
		if (cust != null) {
			description = cust.toString();
		}
		return description;
		
	}

	/**
	 * Returns all customers whose total sales are between low and high
	 * @param low
	 * @param high
	 * @return
	 */
	public ArrayList<String> getCustomerDesciptions(double low, double high) {
		ArrayList<String> matchedCustomers = new ArrayList<String>();
		
		for (Customer cust : customers.values()) {
			double totalSales = cust.getTotalSales();
			if (totalSales >= low && totalSales <= high) {
				matchedCustomers.add(cust.toString());
			}
		}
		
		return matchedCustomers;
		
	}
	

}
