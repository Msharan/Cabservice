package myProjectUber;

public class Customer {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}

	private String customerName;
	private int avgRating;
	private int noOfTripsCompleted;

	public Customer(String customerName, int avgRating, int noOfTripsCompleted) {
		this.customerName = customerName;
		this.avgRating = avgRating;
		this.noOfTripsCompleted = noOfTripsCompleted;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getAvgRating() {
		return avgRating;
	}

	public int getNoOfTripsCompleted() {
		return noOfTripsCompleted;
	}
	
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	
	public void setNoOfTripsCompleted(int noOfTripsCompleted) {
		this.noOfTripsCompleted = noOfTripsCompleted;
	}
}
