package myProjectUber;

public class TripInfo {
	
	private Driver driver;
	private Customer customer;
	private int customerRating;
	private int driverRating;
	
	public TripInfo(Driver driver, Customer customer, int customerRating,int driverRating) {
		this.driver = driver;
		this.customer = customer;
		this.customerRating = customerRating;
		this.driverRating = driverRating;
	}
	
	public TripInfo(String customerName,String driverName, int customerRating, int driverRating) {
		this.driver = new Driver(driverName, customerRating, 1);
		this.customer = new Customer(customerName, driverRating,1);
		this.customerRating = customerRating;
		this.driverRating = driverRating;
	}
	
	public Driver getDriver() {
		return driver;
	}

	public int getCustomerRating() {
		return customerRating;
	}

	public int getDriverRating() {
		return driverRating;
	}
	
	public Customer getCustomer() {
		return customer;
	}


}
