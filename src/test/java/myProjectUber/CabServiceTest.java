package myProjectUber;

import java.util.Set;

public class CabServiceTest {
	public static void main(String args[]){
		CabService cabService = new CabService();
		cabService.addTrip(new TripInfo("c1","d1",1,1));
		cabService.addTrip(new TripInfo("c2","d1",1,4));
		cabService.addTrip(new TripInfo("c3","d1",3,2));
		cabService.addTrip(new TripInfo("c1","d2",1,5));
		cabService.addTrip(new TripInfo("c2","d2",2,2));
		cabService.addTrip(new TripInfo("c3","d2",3,3));
		cabService.addTrip(new TripInfo("c1","d3",1,3));
		cabService.addTrip(new TripInfo("c2","d3",1,4));
		cabService.addTrip(new TripInfo("c3","d3",1,5));
		FilterParams params = new FilterParams();
		params.setMinRating(4);
		Set<Driver> driverList = cabService.findDriver("c3", params);
		for(Driver driver: driverList){
			System.out.println(driver.getDriverName());
		}
	}
}
 