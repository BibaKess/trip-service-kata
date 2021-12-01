package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user)  {
		return getTripsByUser(user, UserSession.getInstance().getLoggedUser());
	}


	protected List<Trip> getTripsByUser(User user, User loggedUser) {
		if (loggedUser != null) {
			return user.isFriend(loggedUser) ? getUserTripList(user) : new ArrayList<Trip>();
		} else {
			throw new UserNotLoggedInException();
		}
	}


	protected List<Trip> getUserTripList(User user) {
		return TripDAO.findTripsByUser(user);
	}
	
}
