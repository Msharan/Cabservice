package myProjectUber;

public class Edge {
	
	private Driver driver;
	private Customer customer;
	private int driverRating;
	private int customerRating;
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}
	public int getCustomerRating() {
		return customerRating;
	}
	public void setCustomerRating(int customerRating) {
		this.customerRating = customerRating;
	}

}
