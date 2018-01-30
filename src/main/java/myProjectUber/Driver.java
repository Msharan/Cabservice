package myProjectUber;

public class Driver {
	
	private String driverName;
	private int avgRating;
	private int noOfTripsCompleted;
	
	public Driver(String driverName, int avgRating, int noOfTripsCompleted) {
		this.driverName = driverName;
		this.avgRating = avgRating;
		this.noOfTripsCompleted = noOfTripsCompleted;
	}
	
	public String getDriverName() {
		return driverName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
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
		Driver other = (Driver) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		return true;
	}	
	
	

}
