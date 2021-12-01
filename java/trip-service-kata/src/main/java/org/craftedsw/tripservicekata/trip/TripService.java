package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	/**
	 * @deprecated Use {@link #getTripsByUser(User,User, List)} instead
	 */
	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		return getTripsByUser(user, UserSession.getInstance().getLoggedUser());
	}


	protected List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = getUserTripList(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}


	protected List<Trip> getUserTripList(User user) {
		return TripDAO.findTripsByUser(user);
	}
	
}
