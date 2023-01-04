import java.util.Scanner;
import java.util.ArrayList;

/**
* Term Project - Sales Application
* Author: Andrew Rios
* Class: CMIS 141/6383 
* Date: March 6 2022
* Purpose: Customers sales entry and lookup application
*/

public class SalesApplication {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //create object to scan input
		
		int selection = 0;
		
		CustomerDatabase custDB = new CustomerDatabase();
		
		do {
			// display menu options to the user
			SalesApplication.displayMenuOptions();
			System.out.println("\n Enter your selection : ");
			selection = scan.nextInt();
			
			// next action
			switch (selection) {
			
			case 1: // prompt the user for the number of customers to load
				SalesApplication.loadCustomers(custDB, scan);
				break;
			case 2: // prompt the user for a single customers data
				SalesApplication.addNewCustomer(custDB, scan);
				break;
			case 3: // display all customers
				SalesApplication.displayAllCustomers(custDB);
				break;
			case 4: // prompt the user for a customer ID
				SalesApplication.customerLookup(custDB, scan);
				break;
			case 5: // prompt the user for the sales range 
				SalesApplication.salesLookup(custDB, scan);
				break;
			}
			
			// reset the scanner
			scan.reset();
			
		} while (selection != 9);
		System.out.println("Exiting Sales Application...");
	}
	
	public static void displayMenuOptions() {
		System.out.println("\n    MENU");
		System.out.println("1: Load customer data ");
		System.out.println("2: Add new customer ");
		System.out.println("3: Display all customers ");
		System.out.println("4: Retrieve specific customer's data ");
		System.out.println("5: Retrieve customers with total sales based on range ");
		System.out.println("9: Exit program");
	}
	
	/**
	 * Add new customers to the database
	 * @param custDB
	 */
	public static void loadCustomers(CustomerDatabase custDB, Scanner scan) {
		System.out.print("\nHow many customers do you want to enter in the database? ");
		int numCust = scan.nextInt();
	
		String name, id;
		double totalSales;
		
		for (int i=0; i<numCust; i++) {
			System.out.println("\nEnter customer name: ");
			name = scan.next();
			
			System.out.println("\nEnter customer id (must be unique): ");
			id = scan.next();
			
			
			System.out.println("\nEnter customer total sales: ");
			totalSales = scan.nextDouble();
			
			// add new customer to the database
			custDB.addNewCustomer(name, id, totalSales);
			
		}
	}
	
	/**
	 * Prints out all customer descriptions in the database
	 * @param custDB
	 */
	public static void displayAllCustomers(CustomerDatabase custDB) {
		ArrayList<String> custDescriptions = custDB.getAllCustomerDescriptions();
		int numCusts = custDescriptions.size();
		System.out.println();
		System.out.println("There are " + Integer.toString(numCusts) + " customers in the database.");
		
		for (String descr : custDescriptions) {
			System.out.println(descr);
		}


	}
	
	/**
	 * Add a single customer to the database
	 * @param custDB
	 */
	public static void addNewCustomer(CustomerDatabase custDB, Scanner scan) {

		String name, id;
		double totalSales;

		System.out.println("\nEnter customer name: ");
		name = scan.next();//save name input to variable
			
		System.out.println("\nEnter customer id (must be unique): ");
		id = scan.next();//save custom ID input to variable
			
			
		System.out.println("\nEnter customer total sales: ");
		totalSales = scan.nextDouble();//save sales input to variable
			
		// add new customer to the database
		custDB.addNewCustomer(name, id, totalSales);//call custDB.addNewCustomer() and pass in name, id & sales
			
	}
	
	/**
	 * Prints out a single customer description based on customer ID
	 * @param custDB
	 */
	public static void customerLookup(CustomerDatabase custDB, Scanner scan) {
		
		String id;
		
		System.out.println("\nEnter customer id (must be unique): ");//prompt for customer ID
		id = scan.next();//save customer id to variable 
		
		System.out.println(custDB.getCustomerDescription(id));//print return value from custDB.getCustomerDescription() passing in ID 
	}
	
	
	/**
	 * Prints out customer descriptions based on sales range
	 * @param custDB
	 */
	public static void salesLookup(CustomerDatabase custDB, Scanner scan) {
		
		double low, high;//variables for min max of sales range

		System.out.println("\nEnter the low end of the sales range: ");
		low = scan.nextDouble();//save min value to variable
			
		System.out.println("\nEnter the high end of the sales range: ");
		high = scan.nextDouble();//save max value to variable
		
		System.out.println(custDB.getCustomerDesciptions(low,high));//print custDB.getCustomerDesciptions passing in min max sales ranges 
	}


}
