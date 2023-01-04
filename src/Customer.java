public class Customer {
	private String name;
	
	private String id;
	
	private double totalSales = 0.0;
	
	public Customer() {
		
	}
	
	
	public Customer(String name, String id, double totalSales) {
		this.name = name;
		this.id = id;
		this.totalSales = totalSales;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getTotalSales() {
		return totalSales;
	}


	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	
	
	public String toString() {
		return "Name: " + name + ".\n"
			+ "Id: " + id + "\n"
			+ "Total Sales: " + Double.toString(totalSales)+ "\n";
	}

}
