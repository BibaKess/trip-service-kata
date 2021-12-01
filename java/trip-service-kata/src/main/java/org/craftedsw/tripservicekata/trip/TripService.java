package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserNotLoggedInException;

public class TripService {


    private final TripDAO tripDAO;

    public TripService() {
        this(new TripDAO());
    }

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedUser) {
		if (loggedUser != null) {
			return user.isFriend(loggedUser) ? getUserTripList(user) : new ArrayList<Trip>();
		} else {
			throw new UserNotLoggedInException();
		}
	}


	protected List<Trip> getUserTripList(User user) {
		return tripDAO.getUserTripList(user);
	}
	
}
