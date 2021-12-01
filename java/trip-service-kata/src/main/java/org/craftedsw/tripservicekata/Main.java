package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;

public class Main {

    public static void main(String[] args)  {
        TripService tripService = new TripService();
        try {
            tripService.getTripsByUser(new User());
        } catch (UserNotLoggedInException e) {
            throw new RuntimeException(e);
        }
    }
}
