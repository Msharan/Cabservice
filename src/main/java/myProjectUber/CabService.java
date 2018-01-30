package myProjectUber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CabService {
	
	private HashMap<String,List<TripInfo>> customeToDriverMap = new HashMap<String,List<TripInfo>>();
	private HashMap<String,Customer> customerMap = new HashMap<String,Customer>();
	private HashMap<String,Driver> driverMap = new HashMap<String,Driver>();
	
	public void addTrip(TripInfo tripInfo) {
		Customer customer;
		Driver driver;
		if(!customerMap.containsKey(tripInfo.getCustomer().getCustomerName())) {
			customer = tripInfo.getCustomer();
			customerMap.put(tripInfo.getCustomer().getCustomerName(), customer);
		} else {
			customer = customerMap.get(tripInfo.getCustomer().getCustomerName());
			int cusRating =((customer.getAvgRating() * customer.getNoOfTripsCompleted())+ tripInfo.getCustomerRating())/(customer.getNoOfTripsCompleted() +1) ;
			customer.setAvgRating(cusRating);
			customer.setNoOfTripsCompleted(customer.getNoOfTripsCompleted()+1);
		}
		if(!driverMap.containsKey(tripInfo.getDriver().getDriverName())) {
			driver = tripInfo.getDriver();
			driverMap.put(tripInfo.getDriver().getDriverName(), driver);
		} else {
			driver = driverMap.get(tripInfo.getDriver().getDriverName());
			int drivRating =((driver.getAvgRating() * driver.getNoOfTripsCompleted())+ tripInfo.getDriverRating())/(driver.getNoOfTripsCompleted() +1) ;
			driver.setAvgRating(drivRating);
			driver.setNoOfTripsCompleted(driver.getNoOfTripsCompleted()+1);
		}
		if(customeToDriverMap.containsKey(tripInfo.getCustomer().getCustomerName())){
			List<TripInfo> obj = customeToDriverMap.get(tripInfo.getCustomer().getCustomerName());
			obj.add(tripInfo);
			customeToDriverMap.put(tripInfo.getCustomer().getCustomerName(), obj);
		} else {
			List<TripInfo> obj = new ArrayList<TripInfo>();
			obj.add(tripInfo);
			customeToDriverMap.put(tripInfo.getCustomer().getCustomerName(), obj);
		}
	}
	
	public  Set<Driver> findDriver(String customerName, FilterParams params) {
		Set<Driver> driverSet = new HashSet<Driver>();
		int customerRating = getCustomerRating(customerName);
		driverSet = findDriverBasedOnAvgRating(customerName,customerRating);
		if(driverSet.isEmpty()){
			driverSet = getDrivenDrivers(customerName);
		}
		driverSet = filterDrivers(driverSet,params,customerName);
		return driverSet;
	}
	
	private  int getCustomerRating(String customerName) {
		return customerMap.get(customerName).getAvgRating();
	}
	
	private Set<Driver> findDriverBasedOnAvgRating(String customerName,int customerRating) {
		Set<Driver> driverSet = new HashSet<Driver>();
		for (Map.Entry<String,Driver> entry : driverMap.entrySet()) {
			if(entry.getValue().getAvgRating() >= customerRating) {
				driverSet.add(entry.getValue());
			}
		}
		return driverSet;
	}
	
	private Set<Driver> getDrivenDrivers(String customerName) {
		Set<Driver> driverSet = new HashSet<Driver>();
		if(customeToDriverMap.containsKey(customerName) && !customeToDriverMap.get(customerName).isEmpty()) {
			List<TripInfo> drivenDriver = customeToDriverMap.get(customerName);
			for(TripInfo tripInfo : drivenDriver) {
				driverSet.add(tripInfo.getDriver());
			}
		}
		return driverSet;
	}
	
	private Set<Driver> filterDrivers(Set<Driver> driverSet,FilterParams params, String customerName) {
		Set<Driver> driverSet1 = new HashSet<Driver>();
		if(customeToDriverMap.containsKey(customerName) && !customeToDriverMap.get(customerName).isEmpty()) {
			List<TripInfo> drivenDriver = customeToDriverMap.get(customerName);
			for(TripInfo tripInfo : drivenDriver) {
				if(driverSet.contains(tripInfo.getDriver()) && tripInfo.getDriverRating()<params.getMinRating()) {
					driverSet.remove(tripInfo.getDriver());
				}
			}
		}
		driverSet1.addAll(driverSet);
		return driverSet1;
	}
	
	
}
