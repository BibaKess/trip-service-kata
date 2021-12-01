package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TripServiceTest {
	
	@Test
	public void check_user_not_logged() throws Exception {
		TripService tripService = new TripService();
		User user = new User();
		
		Assertions.assertThrows(UserNotLoggedInException.class, ()->tripService.getTripsByUser(user , null));
	}
	
	@Test
	public void check_user_logged_with_empty_tripList() throws Exception {
		TripService tripService = new TripService() {
			@Override
			protected List<Trip> getUserTripList(User user) {
				return new ArrayList<Trip>();
			}
		};
		
		User user = new User();
		User loggedUser = new User();
		user.addFriend(loggedUser);

		List<Trip> result = tripService.getTripsByUser(user , loggedUser);
		
		Assertions.assertEquals(0, result.size());
	}
	
	@Test
	public void check_user_logged_with_not_empty_tripList() throws Exception {
		TripService tripService = new TripService() {
			@Override
			protected List<Trip> getUserTripList(User user) {
				return new ArrayList<Trip>();
			}
		};
		
		User user = new User();
		User loggedUser = new User();
		user.addFriend(loggedUser);

		List<Trip> result = tripService.getTripsByUser(user , loggedUser);
		
		Assertions.assertEquals(0, result.size());
		
	}
}
