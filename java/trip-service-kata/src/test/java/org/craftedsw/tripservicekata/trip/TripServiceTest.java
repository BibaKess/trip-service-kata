package org.craftedsw.tripservicekata.trip;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class TripServiceTest {
    private static final Trip ROME = new Trip();
    private static final Trip CORSE = new Trip();
     TripDAO tripDAO = Mockito.mock(TripDAO.class);
    TripService tripService = new TripService(tripDAO);
    User guest = null;
    User viewer = new User();
    User traveler = new User();

    @Test
     void guestsCantSeeTrips() throws Exception {

        User notImportant = null;
        Assertions.assertThatThrownBy(() -> tripService.getTripsByUser(notImportant, guest));
    }

    @Test
     void viewerCantSeeTripsWhenTravelerHasNoFriends() throws Exception {

        List<Trip> trips = tripService.getTripsByUser(traveler, viewer);

        Assertions.assertThat(trips).isEmpty();
    }

    @Test
     void viewerCantSeeTripsOfTravelersHeIsNotFriendsWith() throws Exception {
        traveler.addFriend(new User());

        List<Trip> trips = tripService.getTripsByUser(traveler, viewer);

        Assertions.assertThat(trips).isEmpty();
    }

    @Test
     void viewerCanSeeTripsWhenFriendsWithTraveler() throws Exception {
        List<Trip> trips = Arrays.asList(CORSE, ROME);
        Mockito.doReturn(trips).when(tripDAO).getUserTripList(traveler);

        traveler.addFriend(viewer);

        List<Trip> visibleTrips = tripService.getTripsByUser(traveler, viewer);

        Assertions.assertThat(visibleTrips).isEqualTo(trips);


    }
}
