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


	protected List<Trip> getTripsByUser(User user, User loggedUser) {
		if (loggedUser != null) {
			boolean isFriend = isFriend(user, loggedUser);
			return isFriend ? getUserTripList(user) : new ArrayList<Trip>();
		} else {
			throw new UserNotLoggedInException();
		}
	}


	/**
	 * @deprecated Use {@link org.craftedsw.tripservicekata.user.User#isFriend(User)} instead
	 */
	private boolean isFriend(User user, User loggedUser) {
		return user.isFriend(loggedUser);
	}


	protected List<Trip> getUserTripList(User user) {
		return TripDAO.findTripsByUser(user);
	}
	
}
