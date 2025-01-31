package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;

public class TripDAO {

    /**
     * @deprecated please use instance method
     */
	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}

    public List<Trip> getUserTripList(User user) {
        return TripDAO.findTripsByUser(user);
    }


}